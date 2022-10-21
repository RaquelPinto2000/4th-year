close all, clear all, clc

%% Task 7 -> simulador 3
%Throughput = taxa de transferencia de pacotes

%7.a
%simulador 3

%7.b
fprintf("Alinea B\n")
N=100;
n=20;
lambda = 1800;
C= 10;
f=1000000;
P=10000;
PacketLoss_Data=zeros(1,N);
PacketLoss_VoIP=zeros(1,N);
AvPacketDelay_Data= zeros (1,N);
AvPacketDelay_VoIP= zeros (1,N);
MaxPacketDelay_Data=zeros(1,N);
MaxPacketDelay_VoIP=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss_Data(i),PacketLoss_VoIP(i),AvPacketDelay_Data(i),AvPacketDelay_VoIP(i), MaxPacketDelay_Data(i),MaxPacketDelay_VoIP(i), Throughput(i)]= Simulator3(lambda,C,f,P,n);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss_Data);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_Data)/N);
fprintf('PacketLoss_Data (%%) = %.2e +- %.2e\n',media,term)
media = mean(PacketLoss_VoIP);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_VoIP)/N);
fprintf('PacketLoss_VoIP (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_Data)/N);
fprintf('AvPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_VoIP)/N);
fprintf('AvPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_Data)/N);
fprintf('MaxPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_VoIP)/N);
fprintf('MaxPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% 7.c
fprintf("Alinea C\n")
N=100;
n=20;
lambda = 1800;
C= 10;
f=10000;
P=10000;
PacketLoss_Data=zeros(1,N);
PacketLoss_VoIP=zeros(1,N);
AvPacketDelay_Data= zeros (1,N);
AvPacketDelay_VoIP= zeros (1,N);
MaxPacketDelay_Data=zeros(1,N);
MaxPacketDelay_VoIP=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss_Data(i),PacketLoss_VoIP(i),AvPacketDelay_Data(i),AvPacketDelay_VoIP(i), MaxPacketDelay_Data(i),MaxPacketDelay_VoIP(i), Throughput(i)]= Simulator3(lambda,C,f,P,n);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss_Data);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_Data)/N);
fprintf('PacketLoss_Data (%%) = %.2e +- %.2e\n',media,term)
media = mean(PacketLoss_VoIP);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_VoIP)/N);
fprintf('PacketLoss_VoIP (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_Data)/N);
fprintf('AvPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_VoIP)/N);
fprintf('AvPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_Data)/N);
fprintf('MaxPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_VoIP)/N);
fprintf('MaxPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao: A diferenca dos resultados para a alinea 7.a é porque como a
% fila de espera e mais pequena, ela vai encher mais rapidamente e depois
% os pacotes sao descartados, logo existe perda de pacotes maior e menos
% delay de pacotes, pois cada pacote nao precisa de esperar tanto na fila
% que a fila é mais pequena
% A taxa de transmissao de pacotes e mais baixa porque como se perde mais
% pacotes (fila mais pequena) vao ser enviados menos pacotes 


% 7.d
fprintf("Alinea D\n")
N=100;
n=20;
lambda = 1800;
C= 10;
f=2000;
P=10000;
PacketLoss_Data=zeros(1,N);
PacketLoss_VoIP=zeros(1,N);
AvPacketDelay_Data= zeros (1,N);
AvPacketDelay_VoIP= zeros (1,N);
MaxPacketDelay_Data=zeros(1,N);
MaxPacketDelay_VoIP=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss_Data(i),PacketLoss_VoIP(i),AvPacketDelay_Data(i),AvPacketDelay_VoIP(i), MaxPacketDelay_Data(i),MaxPacketDelay_VoIP(i), Throughput(i)]= Simulator3(lambda,C,f,P,n);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss_Data);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_Data)/N);
fprintf('PacketLoss_Data (%%) = %.2e +- %.2e\n',media,term)
media = mean(PacketLoss_VoIP);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_VoIP)/N);
fprintf('PacketLoss_VoIP (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_Data)/N);
fprintf('AvPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_VoIP)/N);
fprintf('AvPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_Data)/N);
fprintf('MaxPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_VoIP)/N);
fprintf('MaxPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao: A diferenca dos resultados para a alinea 7.a é porque como a
% fila de espera e mais pequena, ela vai encher mais rapidamente e depois
% os pacotes sao descartados, logo existe perda de pacotes maior e menos
% delay de pacotes, pois cada pacote nao precisa de esperar tanto na fila
% que a fila é mais pequena
% A taxa de transmissao de pacotes e mais baixa porque como se perde mais
% pacotes (fila mais pequena) vao ser enviados menos pacotes 

%% 7.e -> simulador 4
fprintf("Alinea E\n")
N=100;
n=20;
lambda = 1800;
C= 10;
f=1000000;
P=10000;
PacketLoss_Data=zeros(1,N);
PacketLoss_VoIP=zeros(1,N);
AvPacketDelay_Data= zeros (1,N);
AvPacketDelay_VoIP= zeros (1,N);
MaxPacketDelay_Data=zeros(1,N);
MaxPacketDelay_VoIP=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss_Data(i),PacketLoss_VoIP(i),AvPacketDelay_Data(i),AvPacketDelay_VoIP(i), MaxPacketDelay_Data(i),MaxPacketDelay_VoIP(i), Throughput(i)]= Simulator4(lambda,C,f,P,n);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss_Data);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_Data)/N);
fprintf('PacketLoss_Data (%%) = %.2e +- %.2e\n',media,term)
media = mean(PacketLoss_VoIP);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_VoIP)/N);
fprintf('PacketLoss_VoIP (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_Data)/N);
fprintf('AvPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_VoIP)/N);
fprintf('AvPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_Data)/N);
fprintf('MaxPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_VoIP)/N);
fprintf('MaxPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao: comparando com os resultados da alinea d, os pacotes VoIP a serem atentidos demoram
% menos tempo que na alinea b e os pacotes data demoram muito mais tempo a
% serem atendidos, pois existe maior prioridade no atendimento destes
% O numero de pacotes perdidos sao = pois nao se alterou as filas de
% espera mas sim a prioridade de atendimento. 
% Isto acontece porque agora
% o router (simulador do router) da prioridade aos pacotes VoIP o que
% significa que se a fila estiver cheia e vier um pacore VoIP um pacote de
% data vai ser eliminado.
% a taxa de transferencia de pacotes vai ser mais pequena porque se vai
% perder alguns pacotes

% A taxa de transferencia (throughput) tambem nao varia porque os pacotes
% enviados sao os mesmos e em igual numero que antes, so que agora por uma 
% ordem diferente

%7.f
fprintf("Alinea F\n")
N=100;
n=20;
lambda = 1800;
C= 10;
f=10000;
P=10000;
PacketLoss_Data=zeros(1,N);
PacketLoss_VoIP=zeros(1,N);
AvPacketDelay_Data= zeros (1,N);
AvPacketDelay_VoIP= zeros (1,N);
MaxPacketDelay_Data=zeros(1,N);
MaxPacketDelay_VoIP=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss_Data(i),PacketLoss_VoIP(i),AvPacketDelay_Data(i),AvPacketDelay_VoIP(i), MaxPacketDelay_Data(i),MaxPacketDelay_VoIP(i), Throughput(i)]= Simulator4(lambda,C,f,P,n);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss_Data);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_Data)/N);
fprintf('PacketLoss_Data (%%) = %.2e +- %.2e\n',media,term)
media = mean(PacketLoss_VoIP);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_VoIP)/N);
fprintf('PacketLoss_VoIP (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_Data)/N);
fprintf('AvPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_VoIP)/N);
fprintf('AvPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_Data)/N);
fprintf('MaxPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_VoIP)/N);
fprintf('MaxPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao: comparando com os resultados da alinea d, os pacotes VoIP a serem atentidos demoram
% menos tempo que na alinea b e os pacotes data demoram muito mais tempo a
% serem atendidos, pois existe maior prioridade no atendimento destes
% O numero de pacotes perdidos sao = pois nao se alterou as filas de
% espera mas sim a prioridade de atendimento. 
% Isto acontece porque agora
% o router (simulador do router) da prioridade aos pacotes VoIP o que
% significa que se a fila estiver cheia e vier um pacore VoIP um pacote de
% data vai ser eliminado.
% a taxa de transferencia de pacotes vai ser mais pequena porque se vai
% perder alguns pacotes

% A taxa de transferencia (throughput) tambem nao varia porque os pacotes
% enviados sao os mesmos e em igual numero que antes, so que agora por uma 
% ordem diferente

%7.g
fprintf("Alinea G\n")
N=100;
n=20;
lambda = 1800;
C= 10;
f=2000;
P=10000;
PacketLoss_Data=zeros(1,N);
PacketLoss_VoIP=zeros(1,N);
AvPacketDelay_Data= zeros (1,N);
AvPacketDelay_VoIP= zeros (1,N);
MaxPacketDelay_Data=zeros(1,N);
MaxPacketDelay_VoIP=zeros(1,N);
Throughput = zeros(1,N);
for i=1:N
   [PacketLoss_Data(i),PacketLoss_VoIP(i),AvPacketDelay_Data(i),AvPacketDelay_VoIP(i), MaxPacketDelay_Data(i),MaxPacketDelay_VoIP(i), Throughput(i)]= Simulator4(lambda,C,f,P,n);
end

alfa= 0.1; %90% confidence interval%
media = mean(PacketLoss_Data);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_Data)/N);
fprintf('PacketLoss_Data (%%) = %.2e +- %.2e\n',media,term)
media = mean(PacketLoss_VoIP);
term = norminv(1-alfa/2)*sqrt(var(PacketLoss_VoIP)/N);
fprintf('PacketLoss_VoIP (%%) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_Data)/N);
fprintf('AvPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(AvPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(AvPacketDelay_VoIP)/N);
fprintf('AvPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_Data);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_Data)/N);
fprintf('MaxPacketDelay_Data (ms) = %.2e +- %.2e\n',media,term)
media = mean(MaxPacketDelay_VoIP);
term = norminv(1-alfa/2)*sqrt(var(MaxPacketDelay_VoIP)/N);
fprintf('MaxPacketDelay_VoIP (ms) = %.2e +- %.2e\n',media,term)
media = mean(Throughput);
term = norminv(1-alfa/2)*sqrt(var(Throughput)/N);
fprintf('Throughput (Mbps) = %.2e +- %.2e\n',media,term)

% Conclusao: comparando com os resultados da alinea d, os pacotes VoIP a serem atentidos demoram
% menos tempo que na alinea b e os pacotes data demoram muito mais tempo a
% serem atendidos, pois existe maior prioridade no atendimento destes
% O numero de pacotes perdidos sao = pois nao se alterou as filas de
% espera mas sim a prioridade de atendimento. 
% Isto acontece porque agora
% o router (simulador do router) da prioridade aos pacotes VoIP o que
% significa que se a fila estiver cheia e vier um pacore VoIP um pacote de
% data vai ser eliminado.
% a taxa de transferencia de pacotes vai ser mais pequena porque se vai
% perder alguns pacotes

% A taxa de transferencia (throughput) tambem nao varia porque os pacotes
% enviados sao os mesmos e em igual numero que antes, so que agora por uma 
% ordem diferente