----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 26.03.2022 16:46:28
-- Design Name: 
-- Module Name: mux_dp - Behavioral
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

entity mux_dp is
  Port (counter: in std_logic_vector(2 downto 0);
        en_dot: in std_logic_vector(7 downto 0);
        s_dp: out std_logic);
end mux_dp;

architecture Behavioral of mux_dp is

begin
-- ative low
s_dp <= not en_dot(0) when counter="000" else
        not en_dot(1) when counter="001" else
        not en_dot(2) when counter="010" else
        not en_dot(3) when counter="011" else
        not en_dot(4) when counter="100" else
        not en_dot(5) when counter="101" else
        not en_dot(6) when counter="110" else
        not en_dot(7) when counter="111" else
        '1';
        

end Behavioral;
