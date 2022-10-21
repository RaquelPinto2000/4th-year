
clear all;
close all;

Nodes= [30 70
       350 40
       550 180
       310 130
       100 170
       540 290
       120 240
       400 310
       220 370
       550 380];
   
Links= [1 2
        1 5
        2 3
        2 4
        3 4
        3 6
        3 8
        4 5
        4 8
        5 7
        6 8
        6 10
        7 8
        7 9
        8 9
        9 10];

T= [1  3  1.0 1.0
    1  4  0.7 0.5
    2  7  2.4 1.5
    3  4  2.4 2.1
    4  9  1.0 2.2
    5  6  1.2 1.5
    5  8  2.1 2.5
    5  9  1.6 1.9
    6 10  1.4 1.6];

nNodes= 10;
nLinks= size(Links,1);
nFlows= size(T,1);

co= Nodes(:,1)+j*Nodes(:,2);
L= inf(nNodes);    %Square matrix with arc lengths (in Km)
for i=1:nNodes
    L(i,i)= 0;
end
for i=1:nLinks
    d= abs(co(Links(i,1))-co(Links(i,2)));
    L(Links(i,1),Links(i,2))= d+5; %Km
    L(Links(i,2),Links(i,1))= d+5; %Km
end
L= round(L);  %Km

fprintf("Task 3 - Alinea A\n");
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
    fprintf('Fluxo %d:\n',i);
    fprintf('1º caminho: %d',aux(1));
    for j= 2:length(aux)
        fprintf('-%d',aux(j));
    end
    fprintf("\n");
    for j = 1:arr(1,2)-1  %percorre o fluxo i -> o array aux
        av(i) = av(i) * A(aux(j),aux(j+1));
        %estao sempre em serie, pois da sempre o caminho mais curto no
        %calculatePaths
    end
    aux = av(i)*100;
    fprintf("Disponibilidade= %f = %f%%\n",av(i),aux);
end
