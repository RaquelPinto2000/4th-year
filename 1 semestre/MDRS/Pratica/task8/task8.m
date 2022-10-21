clear all;
close all;
%acho que podes usar isto para o projeto

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

co= Nodes(:,1)+j*Nodes(:,2);

L= inf(nNodes);    %Square matrix with arc lengths (in Km)
for i=1:nNodes
    L(i,i)= 0;
end
C= zeros(nNodes);  %Square matrix with arc capacities (in Gbps)
for i=1:nLinks
    C(Links(i,1),Links(i,2))= 10;  %Gbps
    C(Links(i,2),Links(i,1))= 10;  %Gbps
    d= abs(co(Links(i,1))-co(Links(i,2)));
    L(Links(i,1),Links(i,2))= d+5; %Km
    L(Links(i,2),Links(i,1))= d+5; %Km
end
L= round(L);  %Km

% alinea A
fprintf("Alinea A");
MTBF = (450*360*24)./L;
A = MTBF./(MTBF+24); % a= availability
A(isnan(A))=0; % quando a matriz a tiver Nan mete essa posicao a 0 em vez do Nan

%mins de L = shorted path 
%calcular a avalibility de cada caminho tipo de 1 a 4 calculas de 1 a 2 e
%de 2 a 4
[sP nSP]= calculatePaths(L,T,1); %retorna o 1º caminho para cada link que e o melhor
%sP sao os caminhos e o nSp sao os custos dos caminhos sP
av = ones(1,nFlows); %avalibility tudo a 1 - inicializacao
for i = 1:nFlows
    aux = cell2mat(sP{i}); %transforma o {...} num array para conseguirmos aceder ao que esta dentro dos {}
    arr = size(aux); % n de linhas n de colunas -> nos queremos os nos = n de colunas
    for j = 1:arr(1,2)-1  %percorre o fluxo i -> o array aux
        av(i) = av(i) * A(aux(j),aux(j+1));
        %estao sempre em serie, pois da sempre o caminho mais curto no
        %calculatePaths
    end
end
av

% alinea B
%tens que ter os links = infinito da alinea a
%a=
fprintf("Alinea B");
AuxL = -log(A)*100;

for i=1:nFlows
    aux = cell2mat(sP{1});
    arr = size(aux);
    for j=2:length(aux)
        %AuxL(aux(j),aux(j+1))=inf;
        AuxL(aux(j),aux(j-1))= inf;
        AuxL(aux(j-1),aux(j))= inf;
    end
end


[sP2 nSP2]= calculatePaths(AuxL,T,1);%retorna o 1º e o 2º caminhos para cada link que sao os melhores

avb = ones(1,nFlows); %avalibility tudo a 1 - inicializacao
for i = 1:nFlows
    aux = cell2mat(sP2{i}); %transforma o {...} num array para conseguirmos aceder ao que esta dentro dos {}
    %tbm dava para fazer aux = sP2{i}{1} -> so temos 1 coluna -> 1 caminho
    arr = size(aux); % n de linhas n de colunas -> nos queremos os nos = n de colunas
    for j = 1:arr(1,2)-1  
        avb(i) = avb(i) * AuxL(aux(j),aux(j+1));
        %estao sempre em serie, pois da sempre o caminho mais curto no
        %calculatePaths
    end
    if ~isempty(sP2{i}{1})
        fprintf("ola -> %.5f\n",avb(i));
    end
end




%alinea C
fprintf("Alinea C");
%sP

bandwidth = zeros(1,nLinks);
bt = T(:,3);
bt_2 = T(:,4);
orig = T(:,1);
dest = T(:,2);
no1_link = Links(:,1);
no2_link = Links(:,2);
for i=1:nFlows
    aux = cell2mat(sP{i}); %caminho do fluxo i
    arr = size(aux);
    %ver origem e destino e ver qual é a bt respetivo
    origem = aux(1);
    destino = aux(arr(1,2));
    for k=1:nFlows
        if orig(k)==origem && dest(k) == destino
            capacidade = bt(k);
        end
        if orig(k)==destino && dest(k) == origem
            capacidade = bt_2(k);
        end
    end
    
    for j=1:arr(1,2)-1       %percorrer nós do fluxo i
        no1 = aux(j);
        no2 = aux(j+1);
        for m = 1:nLinks
            if (no1 == no1_link(m) && no2 == no2_link(m)) || (no1 == no2_link(m) && no2 == no1_link(m))
                bandwidth(m) = bandwidth(m) + capacidade;
            end
        end
    end
end

%sP2

bt = T(:,3);
bt_2 = T(:,4);
orig = T(:,1);
dest = T(:,2);
no1_link = Links(:,1);
no2_link = Links(:,2);
for i=1:nFlows
    aux = cell2mat(sP2{i}); %caminho do fluxo i
    arr = size(aux);
    %ver origem e destino e ver qual é a bt respetivo
    origem = aux(1);
    destino = aux(arr(1,2));
    for k=1:nFlows
        if orig(k)==origem && dest(k) == destino
            capacidade = bt(k);
        end
        if orig(k)==destino && dest(k) == origem
            capacidade = bt_2(k);
        end
    end
    
    for j=1:arr(1,2)-1       %percorrer nós do fluxo i
        no1 = aux(j);
        no2 = aux(j+1);
        for m = 1:nLinks
            if (no1 == no1_link(m) && no2 == no2_link(m)) || (no1 == no2_link(m) && no2 == no1_link(m))
                bandwidth(m) = bandwidth(m) + capacidade;
            end
        end
    end
end
bandwidth

%conclusao: as solucoes tem de ter pelo menos o ... de valor
%estamos a proteger todas as ligacoes menos a ligacao 3

%alinea D
fprintf("Alinea D");
%sP

bandwidth = zeros(1,nLinks);
bt = T(:,3);
bt_2 = T(:,4);
orig = T(:,1);
dest = T(:,2);
no1_link = Links(:,1);
no2_link = Links(:,2);
for i=1:nFlows
    aux = cell2mat(sP{i}); %caminho do fluxo i
    arr = size(aux);
    %ver origem e destino e ver qual é a bt respetivo
    origem = aux(1);
    destino = aux(arr(1,2));
    for k=1:nFlows
        if orig(k)==origem && dest(k) == destino
            capacidade = bt(k);
        end
        if orig(k)==destino && dest(k) == origem
            capacidade = bt_2(k);
        end
    end
    
    for j=1:arr(1,2)-1       %percorrer nós do fluxo i
        no1 = aux(j);
        no2 = aux(j+1);
        for m = 1:nLinks
            if (no1 == no1_link(m) && no2 == no2_link(m)) || (no1 == no2_link(m) && no2 == no1_link(m))
                if bandwidth(m) < capacidade
                    bandwidth(m) = capacidade;
                end
            end
        end
    end
end

%sP2

bt = T(:,3);
bt_2 = T(:,4);
orig = T(:,1);
dest = T(:,2);
no1_link = Links(:,1);
no2_link = Links(:,2);
for i=1:nFlows
    aux = cell2mat(sP2{i}); %caminho do fluxo i
    arr = size(aux);
    %ver origem e destino e ver qual é a bt respetivo
    origem = aux(1);
    destino = aux(arr(1,2));
    for k=1:nFlows
        if orig(k)==origem && dest(k) == destino
            capacidade = bt(k);
        end
        if orig(k)==destino && dest(k) == origem
            capacidade = bt_2(k);
        end
    end
    
    for j=1:arr(1,2)-1       %percorrer nós do fluxo i
        no1 = aux(j);
        no2 = aux(j+1);
        for m = 1:nLinks
            if (no1 == no1_link(m) && no2 == no2_link(m)) || (no1 == no2_link(m) && no2 == no1_link(m))
                if bandwidth(m) < capacidade
                    bandwidth(m) = capacidade;
                end
            end
        end
    end
end
bandwidth


%pode acontecer um caminho ja estar a ser utilizado por outro fluxo e o
%fluxo seguinte nunca chegar ao seu destino

%1+1 e melhor do que 1:1 pq o desenpenho de recuperacao de falhas de 1:1 e
%pior do que 1+1


