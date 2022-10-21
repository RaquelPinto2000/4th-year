close all, clear all ,clc

%% Task 3
%prob da ligacao estar em cada um dos 5 estados
% se o inicio for o estado da esquerda metemos o de baixo/cima se for o estado da direita metemos o de cima/baixo 
%3.a
%p2 = 1/(1+(1/5)+(2/20*1/5)+(5/100*2/20*1/5)+(8/600*5/100*2/20*1/5))
%10^-6
p0 = 1/((1+8/600)+(8/600*5/100)+(8/600*5/100*2/20)+(8/600*5/100*2/20*1/5))
%10^-5 -> p1 = p0*8/600
p1 = (8/600)/((1+8/600)+(8/600*5/100)+(8/600*5/100*2/20)+(8/600*5/100*2/20*1/5))
%10^-4 -> p2 = p0*8/600*5/100
p2 = (8/600*5/100)/((1+8/600)+(8/600*5/100)+(8/600*5/100*2/20)+(8/600*5/100*2/20*1/5))
%10^-3 -> p3 = p0*8/600*5/100*2/20
p3 = (8/600*5/100*2/20)/((1+8/600)+(8/600*5/100)+(8/600*5/100*2/20)+(8/600*5/100*2/20*1/5))
%10^-2 -> p4 = p0*8/600*5/100*2/20*1/5
p4 = (8/600*5/100*2/20*1/5)/((1+8/600)+(8/600*5/100)+(8/600*5/100*2/20)+(8/600*5/100*2/20*1/5))

%3.b = 3.a
% numa cadeia de markov a probabilidade de cada estado = a percentagem de 
% tempo medio em que o sistema esta em cada estado -> sao as mesmas contas

%3.c -> media e o ber (10^...) * a probabilidade de ele estar em cada
%estado (calculado na 3.a)
% (media pesada)
media = 10^(-6)*p0 + 10^(-5)*p1 + 10^(-4)*p2 + 10^(-3)*p3 + 10^(-2)*p4

%3.d -> tempo em horas
t0=(1/8) * 60 %10^-6
t1=(1/(600+5)) * 60 %10^-5
t2=(1/(100+2)) * 60 %10^-4
t3=(1/(20+1)) * 60 %10^-3
t4=(1/(5)) * 60 %10^-2

%3.e -> link na interferencia é pelo menos 10^(-3) ou seja e 10^-3 e o 10^-2
% (os estados de interferencia sao o 10^-3 e o -2 e os estados normais sao
% os outros todos)
PNormal = p0+p1+p2
PInterferencia = p4+p3

%3.f (media pesada)
mInterferencia = (10^(-3)* p3 + 10^(-2)*p4) /PInterferencia
mNormal = (10^(-6)*p0 + 10^(-5)*p1 + 10^(-4)*p2) /PNormal

%3.g
% prob. do pacote ser recebido pela estacao de destino sabendo que tem pelo
% menos 1 erro = 1 - prob do pacote ser recebido pela estacao de destino 
% sabendo que nao tem erros
x = 64 : 1500;
x = x.*8;
p = [10^(-6) 10^(-5) 10^(-4) 10^(-3) 10^(-2)];

% probabilidade de um pacote chegar com pelo menos 1 erro
% (combinacao de qualquer coisa a 0 = 1) probabilidade binomial -> aquela com as combinacoes
% nestas probabilidades tem que ser sempre em bit *8
prob0 = 1- (1*(p(1)^0) * (1-p(1)).^(x-0));
prob1 = 1- (1*(p(2)^0) * (1-p(2)).^(x-0));
prob2 = 1- (1*(p(3)^0) * (1-p(3)).^(x-0));
prob3 = 1- (1*(p(4)^0) * (1-p(4)).^(x-0));
prob4 = 1- (1*(p(5)^0) * (1-p(5)).^(x-0));

y = (prob0*p0) + (prob1 * p1)+ (prob2 *p2) + (prob3*p3) + (prob4*p4);

figure(1)
plot (x/8,y)
title("Prob. of ate least one error")
ylim([0 0.014])
grid on
xlabel("B(Bytes)")

% Conclusao : a probabilidade do pacote ser recebido pela estação de 
% destino com pelo menos um erro aumenta pouco com o numero de bytes. ou
% seja é pouco provavel receber se pacotes com pelo menos 1 erro 

% 3.h
% probabilidade de chegada ao 10^... com pelo menos 1 erro
y0 = ((prob0*p0)./(prob0*p0+prob1*p1+prob2*p2+prob3*p3+prob4*p4));
y1 = ((prob1*p1)./(prob0*p0+prob1*p1+prob2*p2+prob3*p3+prob4*p4));
y2 = ((prob2*p2)./(prob0*p0+prob1*p1+prob2*p2+prob3*p3+prob4*p4));

y = y0+y1+y2;
figure(2)
plot(x/8,y)
title("Prob. of Normal State")
%ylim([0.93 1])
grid on
xlabel("B(Bytes)")

% Conclusao : quando recebemos pacotes com erros a probabilidade do estado
% normal baixa mas baixa muito pouco, fica sempre proximo de 1. Se nao
% tivermos pacotes com erros a prob. aproxima se de 1 (0.999....)

% 3.i
probE0 = (1*(p(1)^0) * (1-p(1)).^(x-0));
probE1 = (1*(p(2)^0) * (1-p(2)).^(x-0));
probE2 = (1*(p(3)^0) * (1-p(3)).^(x-0));
probE3 = (1*(p(4)^0) * (1-p(4)).^(x-0));
probE4 = (1*(p(5)^0) * (1-p(5)).^(x-0));

% probabilidade de chegada ao 10^... nao ter erros
y3 = ((probE3*p3)./(probE0*p0+probE1*p1+probE2*p2+probE3*p3+probE4*p4));
y4 = ((probE4*p4)./(probE0*p0+probE1*p1+probE2*p2+probE3*p3+probE4*p4));

y = y3+y4;
figure(3)
semilogy (x/8,y)
title("Prob. of Intereference State")
grid on
xlabel("B(Bytes)")

% Conclusao : quando recebemos pacotes sem erros no estado de interferencia
% a probabilidade aumenta mas aumenta pouco e quando recebemos pacotes com
% erros a prob. desce bastante (perto de 0)