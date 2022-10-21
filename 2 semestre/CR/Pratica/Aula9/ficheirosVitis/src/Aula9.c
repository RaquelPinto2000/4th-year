/******************************************************************************
*
* Copyright (C) 2009 - 2014 Xilinx, Inc.  All rights reserved.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* Use of the Software is limited solely to applications:
* (a) running on a Xilinx device, or
* (b) that interact with a Xilinx device through a bus or interconnect.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
* XILINX  BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF
* OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*
* Except as contained in this notice, the name of the Xilinx shall not be used
* in advertising or otherwise to promote the sale, use or other dealings in
* this Software without prior written authorization from Xilinx.
*
******************************************************************************/

/*
 * helloworld.c: simple test application
 *
 * This application configures UART 16550 to baud rate 9600.
 * PS7 UART (Zynq) is not initialized by this application, since
 * bootrom/bsp configures it to baud rate 115200
 *
 * ------------------------------------------------
 * | UART TYPE   BAUD RATE                        |
 * ------------------------------------------------
 *   uartns550   9600
 *   uartlite    Configurable only in HW design
 *   ps7_uart    115200 (configured by bootrom/bsp)
 */

#include <stdio.h>
#include "platform.h"
#include "xil_printf.h"
#include "xil_io.h"
#include "xparameters.h"
#include "xuartlite_l.h"

#define RED_IDX		0
#define GREEN_IDX	1
#define BLUE_IDX	2
#define BRIGHT_IDX	3

// USE PuTTY - hold '+' or '-' buttons continuously



int main()
{
	char ch;
	int sel = 0;
	int val[3] = {0, 0, 0}; // RGB brightness levels

    init_platform();

	print("Hello Custom Coprocessor\n\r");

	//em cada iteracao
	for (int i = 0; i < 10; i++)
	{
		//Xil_Out32 - permite enviar pro periferio (XPAR_CUSTOMCOPR) 32 bits
		// que tem como endereco base o XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR
		Xil_Out32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 0, i); //escreve no endereco base o valor de i = 1 registo
		Xil_Out32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 4, i + 1);//escreve no endereco base +4 bytes o valor de i+1 = 2 registo
		Xil_Out32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 8, i + 2); //escreve no endereco base +8 bytes o valor de i +2 = 3 registo
		xil_printf("%d + %d + %d = %d\n", 	Xil_In32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 0),
											Xil_In32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 4),
											Xil_In32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 8),
											Xil_In32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 12));

		if (Xil_In32(XPAR_CUSTOMCOPR_0_S00_AXI_BASEADDR + 12) == (3 * i + 3)) //xonfirmar se esta tudo escrito -> i + i+1+i+2 = 3i+3
			xil_printf("OK\n");
		else
			xil_printf("ERROR\n");
	}
	print("Successfully ran Custom Coprocessor application");


    xil_printf("Hello Custom Peripheral\n\r");

    Xil_Out32(XPAR_CUSTOMPERIPH_0_S00_AXI_BASEADDR + (RED_IDX    * 4), val[RED_IDX]);
    Xil_Out32(XPAR_CUSTOMPERIPH_0_S00_AXI_BASEADDR + (GREEN_IDX  * 4), val[GREEN_IDX]);
    Xil_Out32(XPAR_CUSTOMPERIPH_0_S00_AXI_BASEADDR + (BLUE_IDX   * 4), val[BLUE_IDX]);
    Xil_Out32(XPAR_CUSTOMPERIPH_0_S00_AXI_BASEADDR + (BRIGHT_IDX * 4), 500); //-- PWM output frequency = 100 MHz / (500 * 2**8) ~ 781 Hz

    /*One easy way to build a PWM generator is to use two counters:
    Counter 1 (s_clkEnbCnt) limits the frequency of PWM pulses
	Counter 2 (s_pwmCounter) controls duty-cycle of PWM pulses (pulse width)
	PWM frequency = system clock / ((2**number_of_bits_counter_2) * counter_1_MaxValue)

	When talking about PWM switching frequency, we mean how often the PWM output alternates between the ON and OFF states.

	The ideal PWM frequency depends on what kind of device you are controlling.

	The duty cycle of the PWM waveform is used to set the brightness of the LED.
    */

    xil_printf("\r(R,G,B)=(%03d,%03d,%03d)", val[RED_IDX], val[GREEN_IDX], val[BLUE_IDX]);

    while(1)
    {
    	ch = XUartLite_RecvByte(XPAR_AXI_UARTLITE_0_BASEADDR); // receives a single byte using the UART para o microblaze
    	//funcao de leitura bloqueadora
    	if ((ch == 'r') || (ch == 'R'))
		{
			sel = RED_IDX;
		}
    	else if ((ch == 'g') || (ch == 'G'))
		{
			sel = GREEN_IDX;
		}
    	else if ((ch == 'b') || (ch == 'B'))
		{
			sel = BLUE_IDX;
		}
    	else if (ch == '+') //aumentar o brilho
    	{
    		if (val[sel] < 255)
    		{
    			val[sel]++;
    		}
    	}
    	else if (ch == '-') //diminuir o brilho
    	{
    		if (val[sel] > 0)
			{
				val[sel]--;
			}
    	}

    	Xil_Out32(XPAR_CUSTOMPERIPH_0_S00_AXI_BASEADDR + (sel * 4), val[sel]);
    	xil_printf("\r(R,G,B)=(%03d,%03d,%03d)", val[RED_IDX], val[GREEN_IDX], val[BLUE_IDX]);
    }

    cleanup_platform();
    return 0;
}
