	.data
values:	.word 1,2,3,4,5,6,7,8,9,10
nelem:	.word 10
	.text
	.global main
main:	addi r1, r0, nelem	;r1=add(nelem)
	nop
	nop
	lw r1,0(r1)		;r1=val(nelem)
	addi r2,r0,values	;r2 = add(values[0])
	add r3,r0,r0		;r3= i=0 (counting variable)
	addi r8,r1,-1		;r8=nelem-1
	nop
	nop

loop1:	slt r9,r3,r8		;r9 = (i<nelem -1)
	nop
	nop
	beqz r9,end		;is the end of operations been reached?
	nop
	nop
	nop

	addi r6,r2,4		;r6 = add(values[j])
	lw r4,0(r2)		;r4 = val(values[i])
	addi r5,r3,1		;r5=j=i+1(counting variable)

loop2:	lw r7,0(r6)		;r7 = val(values[i])
	nop
	nop
	slt r9,r4,r7		;r9= resultado da comparacao
	nop
	nop
	beqz r9,goon		;branch -> if

	nop
	nop
	nop
	add r9,r4,r0		;r9 = value[i] ->temp
	add r4,r7,r0		;r4=value[j]
	add r7,r9,r0		;r7=r9=value[i]
	nop
	sw 0(r2),r4		;escrever o valor de r4 na memoria
	nop
	sw 0(r6),r7		;escrever o valor de r7

goon:	addi r5,r5,1 		;j=j+1
	nop
	addi r6,r6,4 		;avancar posicoes no array j

	slt r9,r5,r1		;ver a condicao do for
	nop
	nop
	bnez r9,loop2		;branch -> for
	nop
	nop
	nop

	addi r3,r3,1		;i=i+1
	addi r2,r2,4		;r2=add(value[i])
	j loop1
	nop
	nop
	nop
end:	trap 0
