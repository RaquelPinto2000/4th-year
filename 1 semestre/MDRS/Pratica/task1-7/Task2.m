close all, clear all,clc

%% Task 2
% 100 * 8 experiencias de bernoulli independentes
% com sucesso com prob. p ou insucesso com prob de 1-p

% 2.a
n = 100*8; % converter sempre para bits -> 1 byte = 8 bits
p = 10^(-2);
%i = linspace (1,n,n) = i=1:n
%i=0;
%prob=0;
%while i~=n
%    prob = prob + nchoosek(n,i) * p^i * ((1-p)^(n-i))
%    i = i +1;
%end
prob = (nchoosek(n,0)* (p^0) *(1-p)^(n-0))*100 %tu queres calcular a prob. quando n ha erros

% 2.b
n1 = 1000*8;
p1 = 10^(-3);
prob1 = (nchoosek(n1,1)* (p1^1) *(1-p1)^(n1-1))*100 %tu queres calcular a prob. quando ha 1 erro

% 2.c
n2 = 200*8;
p2 = 10^(-4);
prob0 = nchoosek(n2,0)* (p2^0) *(1-p2)^(n2-0); % probabilidade de nao haver erros
prob2 = (1- prob0)*100 % prob de 1 ou + erros = 1- prob. de nao haver erros

%2.d

%x = linspace (10^(-8),10^(-2));  %nao uses o linspace aqui, esta funcao
%nao funciona, acho que nao assume a base 10
x = logspace(-8,-2); % funcao mais apropriada para fazer coisas de base 10 
t1 = 100*8;
t2 = 200*8;
t3 = 1000*8;
y1 = (nchoosek(t1,0)* (x.^0) .*(1-x).^(t1-0));
y2 = (nchoosek(t2,0)* (x.^0) .*(1-x).^(t2-0));
y3 = (nchoosek(t3,0)* (x.^0) .*(1-x).^(t3-0));
figure(1)
semilogx(x,y1*100,x,y2*100,"--",x,y3*100,":")
title("Probability of packet reception without errors(%)")
grid on
legend("100 bytes","200 bytes","1000 bytes", Location="southwest")
xlabel("Bit Error Rate")

% Conclusao : quanto maior for a taxa de erros de pacotes (proxima de 0)
% menor sera a probabilidade dos pacotes nao terem erros (proxima de 0)
% Tbm se pode ver que so a partir de 10^(-5) da taxa de erros de pacotes e 
% que a probabilidade de ter erro diminui (mais erros)
% Quanto mais bits os pacotes tiverem maior a probabilidade de ter erros nos
% pacotes (menor a probabilidade de nao ter)

%2.e
p3=10^(-4);
p4=10^(-3);
p5=10^(-2);
x1 = 64 : 1518; % nao se multiplica por 8 pq a escala é em bytes
%x1 = aux.*8;
%nchoosek(x1,0)
y4 = (1* (p3^0) * (1-p3).^(x1-0));
y5 = (1* (p4^0) *(1-p4).^(x1-0));
y6 = (1* (p5^0) *(1-p5).^(x1-0));
figure(2)
semilogy(x1,y4,x1,y5,"--",x1,y6,":")
title("Probability of packet reception without errors")
grid on
legend("ber=1e-4","ber=1e-3","ber=1e-2", Location="southwest")
xlabel("Packer size (Bytes)")

% Conclusao: quanto maior foi o tamanho do pacote menor probabilidade dos
% pacotes recebidos nao terem erros (mais erros nos pacotes com maior tamanho)
% Quanto maior for a taxa de erros maior a probabilidade de ter erros nos
% pacotes (menor a probabilidade de nao ter)
