clear all; close all;
%podes usar esta para o projeto

%localizacao de cada no
Nodes= [20 60
       250 30
       550 150
       310 100
       100 130
       580 230
       120 190
       400 220
       220 280];

%ligacoes dos nos
Links= [1 2
        1 5
        2 4
        3 4
        3 6
        3 8
        4 5
        4 8
        5 7
        6 8
        7 8
        7 9
        8 9];

%no origem - no destino - debito binario da origem para o destino - debito
%binario do destino para a origem
T= [1  3  1.0 1.0
    1  4  0.7 0.5
    2  7  3.4 2.5
    3  4  2.4 2.1
    4  9  2.0 1.4
    5  6  1.2 1.5
    5  8  2.1 2.7
    5  9  2.6 1.9];

nNodes= 9;
nLinks= size(Links,1);
nFlows= size(T,1);

B= 625;  %Average packet size in Bytes

co= Nodes(:,1)+j*Nodes(:,2); %calculo para a distancia de cada no

%distancia entre os nos -> ver imagem dos slides
L= inf(nNodes);    %Square matrix with arc lengths (in Km)
for i=1:nNodes
    L(i,i)= 0;
end
C= zeros(nNodes);  %Square matrix with arc capacities (in Gbps)
for i=1:nLinks
    %capacidade ou carga do link na pode ser maior que os 10 gigabits por segundo
    C(Links(i,1),Links(i,2))= 10;  %Gbps
    C(Links(i,2),Links(i,1))= 10;  %Gbps
    d= abs(co(Links(i,1))-co(Links(i,2)));
    %matriz L da nos o tamanho do link
    L(Links(i,1),Links(i,2))= d+5; %Km
    L(Links(i,2),Links(i,1))= d+5; %Km
end
L= round(L);  %Km

% Compute up to 100 paths for each flow:
n= 100;
%calcula os n caminhos mais curtos calculatePaths
[sP nSP]= calculatePaths(L,T,n); %esta funcao retorna mais que um caminho para cada link (tabela -> sao 8 - 1 a 5, 1 a 2... ver no grafo)
%sP sao os caminhos e o nSp sao os custos dos caminhos sP

%Compute the link loads using the first (shortest) path of each flow:
sol= ones(1,nFlows);
Loads= calculateLinkLoads(nNodes,Links,T,sP,sol); %trafego de cada link
maxLoad= max(max(Loads(:,3:4)))

%Optimization algorithm resorting to the random strategy:
fprintf("solucao random");
t= tic; %contagem de tempo tic (comecar a contar) e top (parar de contar)
bestLoad= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    for i= 1:nFlows
        sol(i)= randi(nSP(i)); %selecionar um custo random para cada fluxo
    end
    %trafego (carga) do link com custo= sol
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    %seleciona o que tem maior trafego
    load= max(max(Loads(:,3:4)));
    allValues= [allValues load]; %adiciona o load a matriz allValues
    %ve qual o caminho com o menor trafego -> link com menor trafego,
    %melhor para enviar pacotes
    if load<bestLoad
        bestSol= sol; %melhor custo random para cada fluxo (tabela dos slides)
        bestLoad= load;
    end
end
%traco azul
figure(1)
plot(sort(allValues));
title("Random and Greedy - alinea A e C")
bestSol
bestLoad

% alinea a
fprintf("Alinea A - solucao greedy ramdomized");
%Optimization algorithm resorting to the greedy randomized strategy:
t= tic;
bestLoad= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    ax2 = randperm(nFlows); % array com numeros aleatórios com tamanho nFlows
    sol= zeros(1,nFlows);
    for i= ax2 %fluxos
        k_best = 0;
        best = inf;
        %calculo do custo minimo para os valores aleatorios do fluxo (origem e destino existem 8 fluxos)
        for k = 1:nSP(i) 
            sol(i)= k;
            Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
            load= max(max(Loads(:,3:4)));
            if load < best
                k_best = k;
                best = load;
            end
        end
        sol(i) = k_best; %melhor custo para o fluxo i
    end
    %calculo do trafego para o melhor custo -> como no random
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    allValues= [allValues load];
    if load<bestLoad
        bestSol= sol;
        bestLoad= load;
    end
end
%figure(2)
hold on %traco vermelho
plot(sort(allValues)); %estamos a ordenar os valores para apresentar no grafico
%title("Greedy")
bestSol
bestLoad

% alinea B -> conclusao
% a greedy e muito mais pesada que a estrategia random, mas por outro lado
% compensou porque os valores sao melhores que no random


% aqui neste problema a estrategia randi e melhor pois ao longo
% do tempo ela vai aumentando e na greedy nao. A randi gera solucoes muito
% mas mas gera uma melhor que a greedy pois tem tempo para correr mais
% vezes
% em redes maiores a greedy era melhor mas neste caso nao, so temos 8
% fluxos por isso random e melhor


% alinea C
fprintf("Alinea C - solucao random");
t= tic;
bestLoad= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    %ver os 6 percursos mais pequenos mas se tivermos menos que 6 caminhos
    %queremos todos eles.
    for i= 1:nFlows
        % nSP(i) -> numero de percursos queremos 6 desses, se nSP(i) <6
        % queremos nSP(i) -> todos
        n = min(6,nSP(i)); %correr so 6 vezes -> os primeiros 6
        sol(i)= randi(n);
        %sol = custo para cada fluxo
    end
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4))); %maior trafego (carga) que existe -> o que passa no link
    allValues= [allValues load];
    if load<bestLoad
        bestSol= sol;
        bestLoad= load;
    end
end
%traco amarelo
hold on
plot(sort(allValues));
%title("Random and Greedy")
bestSol
bestLoad

%Optimization algorithm resorting to the greedy randomized strategy:
fprintf("Alinea C - solucao greedy random");
t= tic;
bestLoad= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    ax2 = randperm(nFlows); % array numa ordem aleatória
    sol= zeros(1,nFlows);
    for i= ax2
        k_best = 0;
        best = inf;
        % nSP(i) -> numero de percursos queremos 6 desses, se nSP(i) <6
        % queremos nSP(i)
        n = min(6,nSP(i)); %correr so 6 vezes -> os primeiros 6
        for k = 1:n
            sol(i)= k;
            Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
            load= max(max(Loads(:,3:4)));
            if load < best
                k_best = k;
                best = load;
            end
        end
        sol(i) = k_best;
    end
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    allValues= [allValues load];
    if load<bestLoad
        bestSol= sol;
        bestLoad= load;
    end
end
%figure(2)
hold on %traco roxo
plot(sort(allValues));
%title("Greedy")
bestSol
bestLoad
legend('random - A','greedy randomized - A','random - C','greedy randomized - C',Location="southeast");
%no final de todos os componentes estarem no grafico mete se legenda antes
%nao da - da erro

%conclusao -> complexidade computancional praticamente nula mas existe uma
%melhora significativa de valores quer no random quer no greedy randomized
% o random e bem pior que o greedy randomized. 
% temos muito mais solucoes boas e poucas mas no greedy com percursos de
% tamanho 6 que com eles todos, pois as melhores solucoes custumam estar
% nos primeiros shorted paths.

% mesmo para uma rede pequena se reduzirmos o shorted path as solucoes
% ficam melhores -> nos retiramos solucoes mas como sao as ultimas solucoes
% estamos a tirar as solucoes mas ficando com as boas

% o objetivo disto tudo e gerar poucas solucoes mas com resultados bons e
% nao gerar muitas e com resultados piores

% alinea D
fprintf("Alinea D - random");
%solucao random
t= tic;
bestEnergy= inf;
sol= zeros(1,nFlows);
allValues= [];
%quando mais comprimento do link mais energia -> logo queremos o que tem
%menos energia, menos comprimento
while toc(t)<10
    for i= 1:nFlows
        sol(i)= randi(nSP(i));
    end
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    if load<=10
        energy = 0;
        for a=1:nLinks
            %loads(a,1) loads(a,2) sao os nós
            %loads(a,3) loads(a,4) sao os valores dos trafegos (cargas) que
            %passam no link entre os nós, nas duas direcoes
            % ve se esta a passar trafego entre os links numa e noutra direcao
            if Loads(a,3)+Loads(a,4)>0 %esta a suportar trafego nao pode dormir
                energy = energy + L(Loads(a,1),Loads(a,2)); %a energia e igual a energia + o comprimento do link (L -> comprimento do link)
            end
        end
    else
        energy=inf; %garante que nao escolhe se a capacidade/carga for maior que 10 gigabits
    end
    %vai escolher a menor energia
    allValues= [allValues energy];
    if energy<bestEnergy
        bestSol= sol;
        bestEnergy= energy;
    end
    %problema -> poupa energia consentrando ao maximo o numero de percursos
    %pelos menores links mas nao queremos uma solucao com a carga maxima de
    %10 gigabits por segundo, para verificar isso precisamos do if do
    %load<=10
end

%traco azul
figure(2)
plot(sort(allValues));
title("Random and Greedy randomized")
bestSol
bestEnergy

% solucao greedy
%greedy normal com isto da energia
fprintf("Alinea D - greedy randomized");
t= tic;
bestEnergyGreedy= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    ax2 = randperm(nFlows); % array numa ordem aleatória
    sol= zeros(1,nFlows);
    for i= ax2
        k_best = 0;
        best = inf;
        %encontrar o melhor vizinho
        for k = 1:nSP(i)
            sol(i)= k;
            Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
            load= max(max(Loads(:,3:4)));

            if load<=10
                energy = 0;
                for a=1:nLinks
                    if Loads(a,3)+Loads(a,4)>0 %esta a suportar trafego nao pode dormir
                        energy = energy + L(Loads(a,1),Loads(a,2)); %a energia e igual a energia + o comprimento do link (L -> comprimento do link)
                    end
                end
            else
                energy=inf; %garante que nao escolhe se a capacidade/carga for maior que 10 gigabits
            end

            if energy < best
                k_best = k;
                best = energy;
            end
        end
        sol(i) = k_best; % percurso com a melhor escolha
        %melhor custo
    end
    %depois temos que ver para cada custo qual e a menor energia (pelo
    %comprimento) por isso e que fazemos esta parte final tbm
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    if load<=10
        energy = 0;
        for a=1:nLinks
            if Loads(a,3)+Loads(a,4)>0 %esta a suportar trafego nao pode dormir
                energy = energy + L(Loads(a,1),Loads(a,2)); %a energia e igual a energia + o comprimento do link (L -> comprimento do link)
            end
        end
    else
        energy=inf; %garante que nao escolhe se a capacidade/carga for maior que 10 gigabits
    end

    allValues= [allValues energy];
    if energy <bestEnergyGreedy
        bestSol= sol;
        bestEnergyGreedy= energy;
    end
end

hold on %traco vermelho
plot(sort(allValues));
%title("Greedy")
bestSol
bestEnergyGreedy

% alinea E -> conclusao
% temos menos solucoes no random que antes mas a melhor solucao do greedy
% randomized e menos eficiente em termos computacionais mas e muito mais
% eficiente em termos de resultados que o random


% alinea F 
fprintf("Alinea F - random");
%solucao randam
%igual ao D mas com os caminhos mais curtos como antes
t= tic;
bestEnergy= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    for i= 1:nFlows
        n = min(6,nSP(i)); %correr so 6 vezes -> os primeiros 6
        sol(i)= randi(n);
    end
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    if load<=10
        energy = 0;
        for a=1:nLinks
            if Loads(a,3)+Loads(a,4)>0 %esta a suportar trafego nao pode dormir
                energy = energy + L(Loads(a,1),Loads(a,2)); %a energia e igual a energia + o comprimento do link (L -> comprimento do link)
            end
        end
    else
        energy=inf; %garante que nao escolhe se a capacidade/carga for maior que 10 gigabits
    end
    allValues= [allValues energy];
    if energy<bestEnergy
        bestSol= sol;
        bestEnergy= energy;
    end
    %problema -> poupa energia consentrando ao maximo o numero de percursos
    %pelos menores links mas nao queremos uma solucao com a carga maxima de
    %10 gigabits por segundo, para verificar isso precisamos do if do
    %load<=10
end

%traco amarelo
hold on
plot(sort(allValues));
title("Random and Greedy randomized")
bestSol
bestEnergy

% solucao greedy
fprintf("Alinea F - greedy randomized");
t= tic;
bestEnergyGreedy= inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    ax2 = randperm(nFlows); % array numa ordem aleatória
    sol= zeros(1,nFlows);
    for i= ax2
        k_best = 0;
        best = inf;
        %encontrar o melhor vizinho
         n = min(6,nSP(i)); %correr so 6 vezes -> os primeiros 6
        for k = 1:n
            sol(i)= k;
            Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
            load= max(max(Loads(:,3:4)));

            if load<=10
                energy = 0;
                for a=1:nLinks
                    if Loads(a,3)+Loads(a,4)>0 %esta a suportar trafego nao pode dormir
                        energy = energy + L(Loads(a,1),Loads(a,2)); %a energia e igual a energia + o comprimento do link (L -> comprimento do link)
                    end
                end
            else
                energy=inf; %garante que nao escolhe se a capacidade/carga for maior que 10 gigabits
            end

            if energy < best
                k_best = k;
                best = energy;
            end
        end
        sol(i) = k_best; % percurso com a melhor escolha
    end
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= max(max(Loads(:,3:4)));
    if load<=10
        energy = 0;
        for a=1:nLinks
            if Loads(a,3)+Loads(a,4)>0 %esta a suportar trafego nao pode dormir
                energy = energy + L(Loads(a,1),Loads(a,2)); %a energia e igual a energia + o comprimento do link (L -> comprimento do link)
            end
        end
    else
        energy=inf; %garante que nao escolhe se a capacidade/carga for maior que 10 gigabits
    end

    allValues= [allValues energy];
    if energy <bestEnergyGreedy
        bestSol= sol;
        bestEnergyGreedy= energy;
    end
end

hold on %traco roxo
plot(sort(allValues));
%title("Greedy")
bestSol
bestEnergyGreedy
legend('random - D','greedy randomized - D','random - F',' randomized - F',Location="southeast");

%conclusao -> complexidade computancional praticamente nula mas existe uma
%melhora significativa de valores quer no random quer no greedy randomized
% o random e bem pior que o greedy randomized. 
% temos muito mais solucoes boas e poucas mas no greedy com percursos de
% tamanho 6 que com eles todos, pois as melhores solucoes custumam estar
% nos primeiros shorted paths.

% mesmo para uma rede pequena se reduzirmos o shorted path as solucoes
% ficam melhores -> nos retiramos solucoes mas como sao as ultimas solucoes
% estamos a tirar as solucoes mas ficando com as boas

% o objetivo disto tudo e gerar poucas solucoes mas com resultados bons e
% nao gerar muitas e com resultados piores

% o facto de nas greedy tem solucoes mais proximas antes e depois desta
% mudanca de 6 caminhos confirma que os melhores resultados estam nos
% primeiros shorted paths
