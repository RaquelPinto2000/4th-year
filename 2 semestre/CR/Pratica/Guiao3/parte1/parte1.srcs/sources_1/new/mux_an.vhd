----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 26.03.2022 15:08:18
-- Design Name: 
-- Module Name: mux_an - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity mux_an is
  Port (counter: in std_logic_vector(2 downto 0);
        s_an : out std_logic_vector(7 downto 0));
end mux_an;

architecture Behavioral of mux_an is

begin
--ative low
s_an <= "11111110" when (counter="000") else
        "11111101" when (counter="001") else
        "11111011" when (counter="010") else
        "11110111" when (counter="011") else
        "11101111" when (counter="100") else
        "11011111" when (counter="101") else
        "10111111" when (counter="110") else
        "01111111" when (counter="111")else
        "11111111";
  

end Behavioral;
