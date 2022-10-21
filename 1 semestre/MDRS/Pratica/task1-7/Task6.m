close all, clear all, clc

%% Task 6

%6.a
%simulador2

%6.b
fprintf("Alinea B\n")
N=100;
lambda = 1800;
C= 10;
f=1000000;
P=10000;
b=10^(-6);
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator2(lambda,C,f,P,b);
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


%6.c
fprintf("Alinea C\n")
N=100;
lambda = 1800;
C= 10;
f=10000;
P=10000;
b=10^(-6);
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator2(lambda,C,f,P,b);
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


%6.d
fprintf("Alinea D\n")
N=100;
lambda = 1800;
C= 10;
f=2000;
P=10000;
b=10^(-6);
PacketLoss=zeros(1,N);
AvPacketDelay= zeros (1,N);
MaxPacketDelay=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss(i),AvPacketDelay(i),MaxPacketDelay(i),Throughput(i)]= Simulator2(lambda,C,f,P,b);
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

%% conclusoes para todas as alineas -> Throughput = taxa de transferencia
%Temos mais pacotes perdidos pq agora temos pacotes com erro que equivalem 
%a pacotes perdidos, porque eles sao enviados mas odestino descarta-os. 
% O resto dos valores sao iguais pq nao se alterou nada disso.
% para alem dos pacotes pedidos quando a fila esta cheia tbm tempos os
% pacotes perdidos (sao enviados mas sao descartados pelo destinatario) 
% com erros

% o bit error rate faz com que os pacotes sejam transmitidos com erro, ele
% influencia nas perdas de pacotes mas nao influencia em termos de AvPacketDelay 
% nem em MaxPacketDelay para isso nao interessa se o pacote tem erros ou nao
% o bit error rate interefere com o Throughput pois se o tamanho de pacores
% for grande ele tem maior prob de ter erros logo de ser descortado pelo
% destino ->nao conta para a taxa de transferencia se for descartado
% se o tamanho de pacores for pequeno a diferenca nao se nota pois tem
% menos prob de ter erros nos pacotes
% Throughput = nºdePacotesPorSegundo/TamanhoDePacotes
