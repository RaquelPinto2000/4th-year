library IEEE;
use IEEE.STD_LOGIC_1164.all;


entity ParallelEnc is
port(m: in std_logic_vector(10 downto 0);
		x: out std_logic_vector(14 downto 0));
end ParallelEnc;



architecture Structural of ParallelEnc is
	signal s_m17, s_m1117, s_m29, s_m38, s_m510, s_m611: std_logic; -- juntar xors
	signal s_x1, s_x2, s_x3, s_x4, s_x5, s_x6, s_x8, s_x9: std_logic; -- saidas dos xors
	
	component gateXOr2
		PORT (x0, x1: IN STD_LOGIC;
				y: OUT STD_LOGIC);
	END component;
	
	component gateAnd4
		PORT (x0, x1, x2, x3: IN STD_LOGIC;
				y: OUT STD_LOGIC);
	end component;
	
begin
	m17  : gateXOr2 port map(m(0), m(6), s_m17);
	m1117: gateXOr2 port map(m(10), s_m17, s_m1117);
	m29  : gateXOr2 port map(m(1), m(8), s_m29);
	m38  : gateXOr2 port map(m(2), m(7), s_m38);
	m510 : gateXOr2 port map(m(4), m(9), s_m510);
	m611 : gateXOr2 port map(m(5), m(10), s_m611);
	
	
	--x12
	xor1 : gateXOr2 port map(s_m38, s_m29, s_x1);
	xor2 : gateXOr2 port map(s_m1117, s_x1, x(11));
	
	--x13
	xor3 : gateXOr2 port map(s_m510, m(7), s_x2);
	xor4 : gateXOr2 port map(s_m1117, m(3), s_x3);
	xor5 : gateXOr2 port map(s_x2,s_x3,x(12));
	
	--x14
	xor6 : gateXOr2 port map(s_m29, s_m611, s_x5);
	xor7 : gateXOr2 port map(m(3), m(6), s_x6);
	xor8 : gateXOr2 port map(s_x6, m(9), s_x4);
	xor9 : gateXOr2 port map(s_x5, s_x4, x(13));
	
	--x15
	xor10 : gateXOr2 port map(s_m38, s_m510, s_x8);
	xor11 : gateXOr2 port map(m(8), s_m611, s_x9);
	xor12 : gateXOr2 port map(s_x8, s_x9, x(14));

	x(10 downto 0) <= m(10 downto 0);
	

end Structural;