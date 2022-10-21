LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY Parallel IS
	PORT(x : IN	 STD_LOGIC_VECTOR(31 DOWNTO 0); -- entrada, 1 deles e o cin (carry in)
		  c : OUT STD_LOGIC_VECTOR(5 DOWNTO 0); -- saida, 1 deles e o cout (carry out)
			);
END Parallel;

ARCHITECTURE behavior OF Parallel IS
BEGIN
	
END behavior;