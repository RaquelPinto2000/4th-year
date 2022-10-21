close all, clear all,clc

%% Task4

% 4.a
%delay = 10^(-6);
%size = 64 : 1518;
%percSobra = 100 - 19 - 23 - 17;
%nValores = (109-65) + ()
%prob = 0.19*64 + 0.23*110 + 0.17*1518 +
% OU
%prob = 
%media = sum(p.*x); % sumatorio da multiplicacao elemento a elemento 

%capacidade que tem de passar
C = 10*10^6; % = 10e(6) -> e(6) e o 10^6 
delay = 10*10^-6;
packetSize = 64:1518;
prob = zeros(1,1518);
prob(packetSize) = (1 - 0.19 - 0.23 -0.17) / (length(packetSize)-3);
prob(64) = 0.19;
prob(110) = 0.23;
prob(1518) = 0.17;

avgPacketSize = sum(prob(packetSize).*packetSize)
% bits /(segundo) -> bps (bits por segundo)
avgPacketTime = avgPacketSize*8/C


% 4.b -> media da taxa de transferencia -> nº de bits dos pacotes que
% estao a chegar naqueles fluxo de pacotes
lambda = 1000; % pacotes por segundo que passam 

avgThroughput = avgPacketSize*8*lambda/10^6 % 10^6 para por em mbps

% 4.c
capacidade = C/(avgPacketSize*8)
% tu tens 100Mbps e recebes pacotes com media de tamanho de 50bits por
% segundo entao recebes 2 pacotes nesses 100Mbps -> 100/50

% 4.d -> atraso medio da fila
%slide 65 mas para todo os valores
Spacket = packetSize.*8./C;
Spacket2= Spacket.^2;
E = sum(prob(packetSize).*Spacket);
E_2 = sum(prob(packetSize).*Spacket2);
queuingDelay = (lambda*E_2)/(2*(1-lambda*E))
propagacionDelay = delay;
systemDelay = queuingDelay + avgPacketTime + propagacionDelay % queuing delay + transmission time + propagation delays


% 4.e
x = 100 : 2000; %lambda
C=10*10^(6);

y = (x.*E_2)./(2.*(1-x.*E))+E;

figure(1)
plot (x,y)
title("Average system delay (seconds)")
grid on
xlabel("lambda (pps)")

% Conclusao: com a chegada dos pacotes ao sistema, a media do atraso do 
% sistema cresce exponencialmente, ficando sempre proximo de 0, ou seja a
% media de atrado do sistema nunca é significativa

%4.f
lambda1 = 100:2000;
lambda2 = 200:4000;
lambda3 = 1000:20000;
C1 = 10e6; % = 10*10^6
C2 = 20e6; % = 20*10^6
C3 = 100e6; % = 100*10^6

%converter para bbps -> ver caderno
PPS1 = C1/(avgPacketSize*8);
PPS2 = C2/(avgPacketSize*8);
PPS3 = C3/(avgPacketSize*8);

%percentagem para cada lambda -> ver caderno
PERC1 = (lambda1./PPS1) .* 100;
PERC2 = (lambda2./PPS2) .* 100;
PERC3 = (lambda3./PPS3) .* 100;

% como no 4.d mas com outros valores
S1 = ((packetSize.*8)./C1);
S2 = ((packetSize.*8)./C2);
S3 = ((packetSize.*8)./C3);
S1_2 = S1.^2;
S2_2 = S2.^2;
S3_2 = S3.^2;
E1 = sum(prob(packetSize).*S1);
E2 = sum(prob(packetSize).*S2);
E3 = sum(prob(packetSize).*S3);
E1_2 = sum(prob(packetSize).*S1_2);
E2_2 = sum(prob(packetSize).*S2_2);
E3_2 = sum(prob(packetSize).*S3_2);

% calculo do atraso medio na fila de espera
w1 = (lambda1.*E1_2) ./ (2*(1-lambda1.*E1));
w2 = (lambda2.*E2_2) ./ (2*(1-lambda2.*E2));
w3 = (lambda3.*E3_2) ./ (2*(1-lambda3.*E3));

figure(2);
plot(PERC1,w1, PERC2, w2, PERC3, w3)
legend('C=10Mbps', 'C=20Mbps', 'C=100Mbps', Location="northwest")
title('Average system delay (seconds)')
xlabel('lambda (% of the link capacity)')
grid on

% Conclusao: O atraso médio do sistema em função da taxa de chegada dos 
% pacotes aumenta pouco conforme a % de capacidade da ligacao, nao
% aumentando nada ate a 70% aumentado depois exponencialmente -> quanto
% menos capacidade de ligacao maior é a exponencial comparado com os outros
% valores de capacidade