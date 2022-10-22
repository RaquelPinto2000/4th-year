LIBRARY ieee;
USE ieee.std_logic_1164.all;
USE ieee.std_logic_arith.all;
USE ieee.std_logic_unsigned.all;


LIBRARY simpleLogic;
USE simpleLogic.all;

ENTITY contMem IS
  PORT (add:  IN STD_LOGIC_VECTOR (4 DOWNTO 0); -- endereco de memoria a aceder (counter)
        dOut: OUT STD_LOGIC_VECTOR (7 DOWNTO 0)); -- uma posicao da memoria
END contMem;

ARCHITECTURE behavior OF contMem IS
BEGIN
	PROCESS (add)
    TYPE CMem IS ARRAY(0 TO 16) OF STD_LOGIC_VECTOR (7 DOWNTO 0);
  				
			VARIABLE prog: CMem := (CONV_STD_LOGIC_VECTOR (16#C1#, 8),  -- a=1, b=1, c=0, d=0, SPar=00, Sout = 0, nrst = 1, counter = 00000
											CONV_STD_LOGIC_VECTOR (16#A1#, 8),  -- a=1, b=0, c=1, d=0, SPar=00, Sout = 0, nrst = 1, counter = 00001
											CONV_STD_LOGIC_VECTOR (16#91#, 8),  -- a=1, b=0, c=0, d=1, SPar=00, Sout = 0, nrst = 1, counter = 00010
											CONV_STD_LOGIC_VECTOR (16#61#, 8),  -- a=0, b=1, c=1, d=0, SPar=00, Sout = 0, nrst = 1, counter = 00011
											CONV_STD_LOGIC_VECTOR (16#51#, 8),  -- a=0, b=1, c=0, d=1, SPar=00, Sout = 0, nrst = 1, counter = 00100
											CONV_STD_LOGIC_VECTOR (16#31#, 8),  -- a=0, b=0, c=1, d=1, SPar=00, Sout = 0, nrst = 1, counter = 00101
											CONV_STD_LOGIC_VECTOR (16#E1#, 8),  -- a=1, b=1, c=1, d=0, SPar=00, Sout = 0, nrst = 1, counter = 00110
											CONV_STD_LOGIC_VECTOR (16#D1#, 8),  -- a=1, b=1, c=0, d=1, SPar=00, Sout = 0, nrst = 1, counter = 00111
											CONV_STD_LOGIC_VECTOR (16#B1#, 8),  -- a=1, b=0, c=1, d=1, SPar=00, Sout = 0, nrst = 1, counter = 01000
											CONV_STD_LOGIC_VECTOR (16#71#, 8),  -- a=0, b=1, c=1, d=1, SPar=00, Sout = 0, nrst = 1, counter = 01001
											CONV_STD_LOGIC_VECTOR (16#F1#, 8),  -- a=1, b=1, c=1, d=1, SPar=00, Sout = 0, nrst = 1, counter = 01010
											
											CONV_STD_LOGIC_VECTOR (16#03#, 8),  -- a=0, b=0, c=0, d=0, SPar=00, Sout = 1, nrst = 1, counter = 01011
											CONV_STD_LOGIC_VECTOR (16#07#, 8),  -- a=0, b=0, c=0, d=0, SPar=01, Sout = 1, nrst = 1, counter = 01100
											CONV_STD_LOGIC_VECTOR (16#0B#, 8),  -- a=0, b=0, c=0, d=0, SPar=10, Sout = 1, nrst = 1, counter = 01101
											CONV_STD_LOGIC_VECTOR (16#0F#, 8),  -- a=0, b=0, c=0, d=0, SPar=11, Sout = 1, nrst = 1, counter = 01110
											
											CONV_STD_LOGIC_VECTOR (16#01#, 8),  -- a=0, b=0, c=0, d=0, SPar=00, Sout = 0, nrst = 1, counter = 01111	
											
											CONV_STD_LOGIC_VECTOR (16#00#, 8)); -- a=0, b=0, c=0, d=0, SPar=00, Sout = 0, nrst = 0, counter = 10000

	VARIABLE pos: INTEGER;
	BEGIN
    pos := CONV_INTEGER (add);
    dOut <= prog(pos);
  END PROCESS;
END behavior;


  
LIBRARY ieee;
USE ieee.std_logic_1164.all;

entity control is
port( add: in std_logic_vector(4 downto 0);
		nGRst: in std_logic; -- reset entra no reset do contador
		rst: out std_logic; -- reset dos flip_flops e do counter
		Sout: out std_logic; -- sinal do mux 2:1
		SPar: out std_logic_vector (1 downto 0); -- sinal do mux 4:1
		-- o que multiplica pelo mi
	   a: out std_logic;
		b: out std_logic;
		c: out std_logic;
		d: out std_logic); 
end control;

architecture Structural of control is

	signal s_add : std_logic_vector(7 downto 0); -- saida do contMem
	SIGNAL iNRst,nRst: STD_LOGIC;
	
	COMPONENT contMem
		PORT (add:  IN STD_LOGIC_VECTOR (4 DOWNTO 0);
            dOut: OUT STD_LOGIC_VECTOR (7 DOWNTO 0));
	END COMPONENT;
	
	component gateNand2 
	PORT (x0, x1: IN STD_LOGIC;
        y: OUT STD_LOGIC);
	end component;
begin
	
	cMem : contMem port map (add,s_add);
		
	a<=s_add(7);
	b<=s_add(6);
	c<=s_add(5);
	d<=s_add(4);
	SPar <= s_add(3 downto 2);
	Sout <= s_add(1);
	
	rst <=  s_add(0) and nGRst;

end Structural;

