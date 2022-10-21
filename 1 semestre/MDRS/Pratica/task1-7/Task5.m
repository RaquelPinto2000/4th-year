close all, clear all, clc

%% Task 5 -> Throughput = taxa de transferencia de pacotes
%Simulator1(lambda,C,f,P)
% no printf temos de por %% para ele imprimir %

% 5.a
fprintf("Alinea A\n")
N=10;
lambda = 1800;
C= 10;
f=1000000;
P=10000;
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator1(lambda,C,f,P);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss)/N);
fprintf('PacketLoss (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay)/N);
fprintf('AvPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay)/N);
fprintf('MaxPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)


%5.b
fprintf("Alinea B\n")
N=100;
lambda = 1800;
C= 10;
f=1000000;
P=10000;
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator1(lambda,C,f,P);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss)/N);
fprintf('PacketLoss (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay)/N);
fprintf('AvPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay)/N);
fprintf('MaxPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao: Para a mesma simulacao pode haver paramentros de desempenho que
% precisamos de mais simulacoes para termos um intervalo de confianca
% pequeno (mais confianca no numero obtido)
% temos de ver o intervalo de confianca para saber quantas simulacoes e
% preciso fazermos, quanto menor confianca (equivale a intervalo de erro menor), melhor
% Aqui neste caso como repetimos a simulacao mais vezes mais pequeno ficou
% o intervalo de confianca

%5.c
fprintf("Alinea C\n")
N=100;
lambda = 1800;
C= 10;
f=10000;
P=10000;
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator1(lambda,C,f,P);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss)/N);
fprintf('PacketLoss (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay)/N);
fprintf('AvPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay)/N);
fprintf('MaxPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao : temos mais pacotes perdidos, porque a fila de espera e mais
% pequena e assim ela enche mais rapidamente e os pacotes que chegam
% intertanto perdem-se porque a fila esta cheia, como a fila é mais pequena
% cada pacote tem um delay mais pequeno porque vai ter que esperar menos
% tempo na fila. Os intervalos de confianca aperta -> indica que estamos
% proximos de ter uma confianca boa da media de atraso de pacotes.
% A taxa de transferencia e mais pequena porque vai ha menos pacotes a
% serem atendidos (pacotes perdidos na fila)

%5.d
fprintf("Alinea D\n")
N=100;
lambda = 1800;
C= 10;
f=2000;
P=10000;
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator1(lambda,C,f,P);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss)/N);
fprintf('PacketLoss (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay)/N);
fprintf('AvPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay)/N);
fprintf('MaxPacketDelay (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

%Conclusao : voltamos a diminuir a fila de espera, voltou a haver mais
%pacotes perdidos, Os atrasos de transmissao diminuem pela mesma razao -> a
%espera e mais pequena na fila
% O throughput diminui porque os pacotes perdidos aumenta -> a taxa de
% transferencia e melhor pq existe menos pacotes totais (alguns sao
% perdidos na fila)


%% 5.e
lambda = 1800;
packetSize = 64:1518;
%delay = 10*10^-6;
C = 10*10^6;
prob = zeros(1,1518);
prob(packetSize) = (1 - 0.19 - 0.23 -0.17) / (length(packetSize)-3);
prob(64) = 0.19;
prob(110) = 0.23;
prob(1518) = 0.17;
Spacket = packetSize.*8./C;
Spacket2= Spacket.^2;
E = sum(prob(packetSize).*Spacket);
E_2 = sum(prob(packetSize).*Spacket2);
avgPacketSize = sum(prob(packetSize).*packetSize);

% Calcular o W (O atraso médio no sistema)
AvPacketDelay = (((lambda.*E_2) ./ (2*(1-lambda.*E)))+E)*10^3; %converter em ms
avgThroughput = avgPacketSize*8*lambda/10^6; % 10^6 para por em mbps
%calcular a perda de pacotes
N=100;
i=1:N;
ro = C /(avgPacketSize*8);
PacketLoss= ((lambda/ro)^N)/(sum((lambda/ro).^i));
% arredondado da 0
fprintf('Packet Lost (%%) = %.2e\n',PacketLoss)
fprintf('AvPacketDelay (ms) = %.2e\n',AvPacketDelay)
fprintf('Throughput (Mbps) = %.2e\n',avgThroughput)
