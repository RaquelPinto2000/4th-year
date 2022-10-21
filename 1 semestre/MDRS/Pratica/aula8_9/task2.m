clear all;
close all;
%a parte do hill climbing nao uses no projeto - so se for a solucao do
%gameiro

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
[sP nSP]= calculatePaths(L,T,n); 
%sP sao os caminhos e o nSp sao os custos dos caminhos sP

%Compute the link loads using the first (shortest) path of each flow:
sol= ones(1,nFlows);
Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
maxLoad= max(max(Loads(:,3:4)))

%Multi Start Hill Climbing Heuristic: slide 29
t= tic;
bestLoad= inf;
bestneighbour = inf;
sol= zeros(1,nFlows);
allValues= [];
while toc(t)<10
    % melhor vizinho (slide 22) -> best neighbour
    for i= 1:nFlows
        sol(i)= nSP(1); %inicializar o custo na primeira solucao
    end
     
   ax2= randperm(nFlows);
    sol= zeros(1,nFlows);
    for i= ax2
        k_best= 0;
        best= inf;
        for k= 1:nSP(i)
            sol(i)= k;
            Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
            load= max(max(Loads(:,3:4)));
            if load<best
                k_best= k;
                best= load;
            end
        end
        sol(i)= k_best;
    end
    Loads= calculateLinkLoads(nNodes,Links,T,sP,sol);
    load= best;

    allValues= [allValues load];

    if load<bestLoad
        bestSol= sol;
        bestLoad= load;
    end
end
%traco azul
figure(1)
plot(sort(allValues));
title("hill climbing")
fprintf('   Best load = %.2f Gbps\n',bestLoad);
fprintf('   No. of solutions = %d\n',length(allValues));
fprintf('   Av. quality of solutions = %.2f Gbps\n',mean(allValues));
bestSol
bestLoad
