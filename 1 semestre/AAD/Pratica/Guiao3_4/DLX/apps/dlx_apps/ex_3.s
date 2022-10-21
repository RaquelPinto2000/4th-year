	.data
values:	.word	1,2,3,4,5,6,7,8,9,10
nelem:	.word	10
sum:	.space 	4
	.text	
	.global main
main:	addi r1,r0,nelem ; r1 = espaco do array
	lw r1,0(r1)	 ; vai ler o elemento na ultima posicao do array (saber quando acabar o loop)
	addi r2,r0,values ; r2 = values[0] -> indexes AC1
	addi r3,r0,0;	;r3=0 -> valores para somar
	addi r4,r0,0; 	r4=0 -> o sitio do array

loop:	lw r5,0(r2) 	;vais ler o conteudo do values[r2]
	add r3,r3,r5
	addi r4,r4,1
	addi r2,r2,4; vais subir no array (4 bits)
	sub r7,r1,r4	;vais tirar o espaco que ocupaste -> ver quantos nª faltam sumar
	bnez r7,loop ;se r7 diferente de 0 vai para o loop
	addi r6,r0,sum	;vai reservar espaco na memoria para depois escrever
	sw 0(r6),r3 ; escrever (fazemos ao contrario de ac1)
	trap 0