library IEEE;
use IEEE.STD_LOGIC_1164.all;

library simpleLogic;
use simpleLogic.all;


entity ParallelDecod is
port(y: in std_logic_vector(14 downto 0);
		ml: out std_logic_vector(10 downto 0));
end ParallelDecod;

architecture Structural of ParallelDecod is
	signal s_p, s_np: std_logic_vector(3 downto 0);
	signal s_y17, s_y1117, s_y29, s_y38, s_y510, s_y611: std_logic;
	signal s_x1, s_x2, s_x4, s_x5, s_x6, s_x8, s_x9, s_x10, s_x11, s_x13, s_x14, s_x15: std_logic;
	
	signal s_p12, s_p34, s_pn12, s_p1n2, s_pn34, s_p3n4: std_logic;
	signal s_a0, s_a7: std_logic;
	signal s_descodifOut: std_logic_vector(10 downto 0);
	
	component gateXOr2
		PORT (x0, x1: IN STD_LOGIC;
				y: OUT STD_LOGIC);
	END component;
	
	component gateAnd2
		PORT (x0, x1: IN STD_LOGIC;
				y: OUT STD_LOGIC);
	end component;
	
begin
	--Error Detection
	y17  : gateXOr2 port map(y(0), y(6), s_y17);
	y1117: gateXOr2 port map(y(10), s_y17, s_y1117);
	y29  : gateXOr2 port map(y(1), y(8), s_y29);
	y38  : gateXOr2 port map(y(2), y(7), s_y38);
	y510 : gateXOr2 port map(y(4), y(9), s_y510);
	y611 : gateXOr2 port map(y(5), y(10), s_y611);
	
	
	--p1
	xor1 : gateXOr2 port map(s_y1117, s_y29, s_x1);
	xor2 : gateXOr2 port map(s_y38, y(11), s_x2);
	xor3 : gateXOr2 port map(s_x1, s_x2, s_p(0));
	
	--p2
	xor4 : gateXOr2 port map(s_y1117, y(3), s_x4);
	xor5 : gateXOr2 port map(s_y510, y(12), s_x5);
	xor6 : gateXOr2 port map(y(7), s_x5, s_x6);
	xor7 : gateXOr2 port map(s_x4, s_x6, s_p(1));
	
	--p3
	xor8 : gateXOr2 port map(s_y29, y(3), s_x8);
	xor9 : gateXOr2 port map(s_y611, y(13), s_x9);
	xor10 : gateXOr2 port map(y(6), y(9), s_x10);
	xor11 : gateXOr2 port map(s_x9, s_x10, s_x11);
	xor12 : gateXOr2 port map(s_x8, s_x11, s_p(2));
	
	--p4
	xor13 : gateXOr2 port map(s_y38, s_y510, s_x13);
	xor14 : gateXOr2 port map(s_y611, y(8), s_x14);
	xor15 : gateXOr2 port map(s_x14, y(14), s_x15);
	xor16 : gateXOr2 port map(s_x13, s_x15, s_p(3));
	
	
	
	
	--Error Correction
	s_np(0) <= not s_p(0);
	s_np(1) <= not s_p(1);
	s_np(2) <= not s_p(2);
	s_np(3) <= not s_p(3);
	
	a_p12 : gateAnd2 port map(s_p(0), s_p(1), s_p12);
	a_p34 : gateAnd2 port map(s_p(2), s_p(3), s_p34);
	a_pn12: gateAnd2 port map(s_np(0), s_p(1), s_pn12);
	a_p1n2: gateAnd2 port map(s_p(0), s_np(1), s_p1n2);
	a_pn34: gateAnd2 port map(s_np(2), s_p(3), s_pn34);
	a_p3n4: gateAnd2 port map(s_p(2), s_np(3), s_p3n4);
	
	--sel0
	a0 : gateAnd2 port map(s_np(2), s_np(3), s_a0);
	a1 : gateAnd2 port map(s_a0, s_p12, s_descodifOut(0));
	--sel1
	a2 : gateAnd2 port map(s_p1n2, s_p3n4, s_descodifOut(1));
	--sel2
	a3 : gateAnd2 port map(s_p1n2, s_pn34, s_descodifOut(2));
	--sel3
	a4 : gateAnd2 port map(s_pn12, s_p3n4, s_descodifOut(3));
	--sel4
	a5 : gateAnd2 port map(s_pn12, s_pn34, s_descodifOut(4));
	--sel5
	a7 : gateAnd2 port map(s_np(0), s_np(1), s_a7);
	a6 : gateAnd2 port map(s_a7, s_p34, s_descodifOut(5));
	--sel6
	a8 : gateAnd2 port map(s_p12, s_p3n4, s_descodifOut(6));
	--sel7
	a9 : gateAnd2 port map(s_p12, s_pn34, s_descodifOut(7));
	--sel8
	a10 : gateAnd2 port map(s_p1n2, s_p34, s_descodifOut(8));
	--sel9
	a11 : gateAnd2 port map(s_pn12, s_p34,s_descodifOut(9));
	--sel10
	a12 : gateAnd2 port map(s_p12, s_p34,s_descodifOut(10));
	
	
	
	xorl0 : gateXOr2 port map(s_descodifOut(0), y(0), ml(0));
	xorl1 : gateXOr2 port map(s_descodifOut(1), y(1), ml(1));
	xorl2 : gateXOr2 port map(s_descodifOut(2), y(2), ml(2));
	xorl3 : gateXOr2 port map(s_descodifOut(3), y(3), ml(3));
	xorl4 : gateXOr2 port map(s_descodifOut(4), y(4), ml(4));
	xorl5 : gateXOr2 port map(s_descodifOut(5), y(5), ml(5));
	xorl6 : gateXOr2 port map(s_descodifOut(6), y(6), ml(6));
	xorl7 : gateXOr2 port map(s_descodifOut(7), y(7), ml(7));
	xorl8 : gateXOr2 port map(s_descodifOut(8), y(8), ml(8));
	xorl9 : gateXOr2 port map(s_descodifOut(9), y(9), ml(9));
	xorl10: gateXOr2 port map(s_descodifOut(10),y(10),ml(10));
	
	
	
	
end Structural;