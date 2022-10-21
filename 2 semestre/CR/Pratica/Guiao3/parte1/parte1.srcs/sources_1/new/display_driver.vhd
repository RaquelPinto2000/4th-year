----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 27.03.2022 12:19:54
-- Design Name: 
-- Module Name: display_driver - Behavioral
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

entity display_driver is
  Port (clk: in std_logic;
        sw: in std_logic_vector (15 downto 0);
        an: out std_logic_vector(7 downto 0);
        seg: out std_logic_vector(6 downto 0);
        dp: out std_logic);
end display_driver;

architecture Behavioral of display_driver is
signal s_en : std_logic;
begin
        
PulseGenerator: entity work.PulseGenerator(Behavioral)
    port map (clk => clk,
              reset => '0',
              pulse=> s_en);
              
Nexys4DispDriver: entity work.Nexys4DispDriver (Behavioral)
    port map (clk=> clk,
              enable_clk => s_en,
              EN_digit => sw(7 downto 0), -- sw de 7 a 0 por ex
              EN_dot => sw(15 downto 8),
              D0 => "0000",
              D1 => "0001",
              D2 => "0010",
              D3 => "0011",
              D4 => "0100",
              D5 => "0101",
              D6 => "0110",
              D7 => "0111",
              an => an,
              seg => seg,
              dp => dp);

end Behavioral;
