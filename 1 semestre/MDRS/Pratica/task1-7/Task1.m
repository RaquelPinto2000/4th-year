close all, clear all,clc

%% Task1
% 1.a
% regra de bayes
p = 0.60;
n=4; % nº de perguntas
pe=1*p+1/n*(1-p)

% 1.b
p = 0.7;
n= 5;
pE = 1*p /(p+(1-p)/n)

% 1.c
x=linspace(0, 1, 100); % prob de acertar a resposta
m =[3 4 5]; % nº de perguntas
y1=1*x+1/m(1)*(1-x); % prob de saber a resposta
y2=1*x+1/m(2)*(1-x); % prob de saber a resposta
y3=1*x+1/m(3)*(1-x); % prob de saber a resposta
figure(1)

plot(x*100,y1*100,x*100,y2*100,'--',x*100,y3*100,':')
title("Probability of right answer(%)")
ylim([0 100])
grid on
xlabel("p(%)")
legend("n=3","n=4","n=5", Location="northwest")


% Conclusao : um aluno que estude 90 % a probabilidade da nota coincidir
% com o que sabe é boa mas um aluno que estude 50 % quantas mais opcoes
% existe menos probabilidade tem de passar

%1.d
x1=linspace(0,1,100);
m =[3 4 5];
%calculo da probabilidade
y4=x1*m(1)./(1+(m(1)-1)*x1); % por o ./ para fazer a divisao por elemento e nao por matriz
y5=x1*m(2)./(1+(m(2)-1)*x1);
y6=x1*m(3)./(1+(m(3)-1)*x1);

figure(2)

plot(x1*100,y4*100,x1*100,y5*100,'--',x1*100,y6*100,':')
title("Probability of knowing the answer(%)")
ylim([0 100])
grid on
xlabel("p(%)")
legend("n=3","n=4","n=5", Location="northwest")

% Conclusao : quanto mais respostas certas mais probabilidade do estudante
% saber as respostas as perguntas e quantas mais opcoes por perguntas for
% mais probabilidade existe do estudante saber as perguntas as quais
% acertou (e mais dificil acertares a sorte numa que tenha muitas 
% % opcoes do que numa que nao tenha)

