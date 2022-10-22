LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY MUX2_1 IS 
  PORT (Sout:     	IN STD_LOGIC; 
        dataIn0: 		IN STD_LOGIC;
		  dataIn1: 		IN STD_LOGIC;
        dataOut:     OUT STD_LOGIC);
END MUX2_1;

ARCHITECTURE structure OF MUX2_1 IS
	signal s_A0,s_A1,s_N: std_logic;
	
  COMPONENT gateAnd2
    PORT (x0, x1: IN STD_LOGIC;
          y: OUT STD_LOGIC);
  END COMPONENT;
  COMPONENT gateOr2
    PORT (x0, x1: IN STD_LOGIC;
          y: OUT STD_LOGIC);
  END COMPONENT;
  COMPONENT  gateNot
	PORT	(x : IN STD_LOGIC;
			y: OUT STD_LOGIC);
	END COMPONENT;
	
BEGIN
	notS 	 : gateNot PORT MAP (Sout, s_N);
	andIn0 : gateAnd2 PORT MAP (dataIn0, s_N, s_A0);
	andIn1 : gateAnd2 PORT MAP (dataIn1, Sout, s_A1);
	orMux  : gateOr2 PORT MAP (s_A0,s_A1,dataOut);
END structure;




LIBRARY ieee;
USE ieee.std_logic_1164.all;

entity Mux4_1 is
	port(SPar    : in  std_logic_vector(1 downto 0);
		  -- dataIn0 = x12, dataIn1 = x13, dataIn2 = x14, dataIn3 = x15
		  dataIn0 : in  std_logic;
		  dataIn1 : in  std_logic;
		  dataIn2 : in  std_logic;
		  dataIn3 : in  std_logic;
		  dataOut : out std_logic);
end Mux4_1;

ARCHITECTURE structure OF MUX4_1 IS
	signal s_A0,s_A1,s_A2,s_A3,s_N0,s_N1: std_logic;
	
  COMPONENT gateAnd3
    PORT (x0, x1, x2: IN STD_LOGIC;
          y: OUT STD_LOGIC);
  END COMPONENT;
  COMPONENT gateOr4
    PORT (x0, x1, x2, x3: IN STD_LOGIC;
          y: OUT STD_LOGIC);
  END COMPONENT;
  COMPONENT  gateNot
	PORT	(x : IN STD_LOGIC;
			y: OUT STD_LOGIC);
	END COMPONENT;
		
BEGIN
	
	notS0  : gateNot PORT MAP (SPar(0), s_N0);
	notS1  : gateNot PORT MAP (SPar(1), s_N1);
	
	andIn0 : gateAnd3 PORT MAP (SPar(0), SPar(1), dataIn3,s_A0);
	andIn1 : gateAnd3 PORT MAP (SPar(1), s_N0, dataIn2,s_A1);
	andIn2 : gateAnd3 PORT MAP (s_N1, SPar(0), dataIn1,s_A2);
	andIn3 : gateAnd3 PORT MAP (s_N1, s_N0, dataIn0,s_A3);
	
	orMux	 : gateOr4 PORT MAP (s_A0,s_A1,s_A2,s_A3,dataOut);
	
END structure;
