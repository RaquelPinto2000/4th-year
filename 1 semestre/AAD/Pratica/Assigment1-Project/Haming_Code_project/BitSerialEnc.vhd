library IEEE;
use IEEE.STD_LOGIC_1164.all;

LIBRARY arithmetic;
USE arithmetic.all;

LIBRARY simpleLogic;
USE simpleLogic.all;

LIBRARY control;
USE control.all;

LIBRARY flipFlopDPET;
USE flipFlopDPET.all;

LIBRARY counter_5bits;
USE counter_5bits.all;


LIBRARY ieee;
USE ieee.std_logic_1164.all;

entity BitSerialEnc is
	port (m: in std_logic;
		  clk:   in std_logic;
		  nGRst : in std_logic;
		  x: out std_logic;
		  saida : out std_logic_vector(4 downto 0)); -- adicionamos a saida do counter para ser mais facil de ver os numeros
end BitSerialEnc;

architecture Structural of BitSerialEnc is
	--sinais do control e do counter
	signal s_rst, s_Sout : std_logic;
	signal s_SPar : std_logic_vector (1 downto 0);
	signal s_a, s_b, s_c, s_d : std_logic;
	signal s_add : std_logic_vector(4 downto 0); -- saida do counter_5bits
	
	signal s_A0,s_A1,s_A2,s_A3: std_logic; --sinais da saida dos ands
	signal s_Xor0,s_Xor1,s_Xor2,s_Xor3: std_logic; --sinais da saida dos xors
	signal s_F0,s_F1,s_F2,s_F3 : std_logic; -- saida dos flip_flops
	signal s_mux4_1,s_mux2_1 : std_logic; -- saida dos mux
	
	
	COMPONENT control
		PORT (add: in std_logic_vector(4 downto 0); 
			nGRst: in std_logic; -- reset entra no reset do contador
			rst: out std_logic; -- reset dos flip_flops e do counter
			Sout: out std_logic; -- sinal do mux 2:1
			SPar: out std_logic_vector (1 downto 0); -- sinal do mux 4:1
			a: out std_logic;
			b: out std_logic;
			c: out std_logic;
			d: out std_logic); 
	END COMPONENT;

	component counter_5bits
		PORT (nRst: IN STD_LOGIC;
			  clk:  IN STD_LOGIC;
			  c:    OUT STD_LOGIC_VECTOR (4 DOWNTO 0));
	end component;
	
	component gateXOr2
		PORT (x0, x1: IN STD_LOGIC;
				y: OUT STD_LOGIC);
	END component;
	
	component gateAnd2
		PORT (x0, x1 : IN STD_LOGIC;
				y: OUT STD_LOGIC);
	end component;
	
	component MUX2_1
		PORT (Sout:     	IN STD_LOGIC;
			  dataIn0: 		IN STD_LOGIC;
			  dataIn1: 		IN STD_LOGIC;
			  dataOut:     OUT STD_LOGIC);
	end component;
	
	component Mux4_1 
		port(SPar    : in  std_logic_vector(1 downto 0);
			  dataIn0 : in  std_logic;
			  dataIn1 : in  std_logic;
			  dataIn2 : in  std_logic;
			  dataIn3 : in  std_logic;
			  dataOut : out std_logic);
	end component;
	
	component flipFlopDPET
		PORT (clk, D: IN STD_LOGIC;
			  nSet, nRst: IN STD_LOGIC;
			  Q, nQ: OUT STD_LOGIC);
		end component;
	
	
begin   
	
	count : counter_5bits port map (s_rst, clk, s_add);
		
	cont : control port map (s_add, nGRst, s_rst,s_Sout,s_SPar,s_a,s_b,s_c,s_d);
		
	And0 : gateAnd2 port map (m,s_a,s_A0);
	And1 : gateAnd2 port map (m,s_b,s_A1);
	And2 : gateAnd2 port map (m,s_c,s_A2);
	And3 : gateAnd2 port map (m,s_d,s_A3);
	
	Xor0 : gateXOr2 port map (s_A0, s_F0,s_Xor0);
	Xor1 : gateXOr2 port map (s_A1, s_F1,s_Xor1);
	Xor2 : gateXOr2 port map (s_A2, s_F2,s_Xor2);
	Xor3 : gateXOr2 port map (s_A3, s_F3,s_Xor3);
	
	flip0 : flipFlopDPET port map (clk,s_Xor0,'1',s_rst,s_F0);
	flip1 : flipFlopDPET port map (clk,s_Xor1,'1',s_rst,s_F1);
	flip2 : flipFlopDPET port map (clk,s_Xor2,'1',s_rst,s_F2);
	flip3 : flipFlopDPET port map (clk,s_Xor3,'1',s_rst,s_F3);
	
	m4_1 : Mux4_1 port map (s_SPar,s_F0,s_F1,s_F2,s_F3,s_mux4_1);
	
	m2_1 : MUX2_1 port map (s_Sout,m,s_mux4_1,s_mux2_1);
		
	flip4 : flipFlopDPET port map (clk,s_mux2_1,'1',s_rst,x);
	
	-- adicionamos a saida do counter para ser mais facil de ver os numeros
	saida<=s_add; 
	
end Structural;