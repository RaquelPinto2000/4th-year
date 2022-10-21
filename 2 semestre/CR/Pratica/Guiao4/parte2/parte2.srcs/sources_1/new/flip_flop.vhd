----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 13.04.2022 08:54:24
-- Design Name: 
-- Module Name: flip_flop - Behavioral
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

entity flip_flop is
    Port (clk: in std_logic;
          dataIn: in std_logic;
          dataOut: out std_logic );
end flip_flop;

architecture Behavioral of flip_flop is

begin
    process(clk)
    begin
        if(rising_edge(clk))then
            dataOut<=dataIn;
        end if;
    end process;

end Behavioral;
