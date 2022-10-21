----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 16.03.2022 10:45:19
-- Design Name: 
-- Module Name: pulse1Hz - Behavioral
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

entity pulse1Hz is
    Port (clk: in std_logic; -- de 100MHz da placa -> sempre
          reset: in std_logic;
          pulse: out std_logic);
end pulse1Hz;

architecture Behavioral of pulse1Hz is
--dividir a frequencia 1s/10ns
constant MAX : natural :=100_000_000; -- 100 milhoes
signal s_count : natural range 0 to MAX-1;
begin
    process(clk)
    begin
        if (rising_edge(clk)) then
            pulse<='0';
            if(reset = '1')then
                s_count  <=0;
            else
                s_count <= (s_count+1);
                if(s_count=MAX-1) then
                    s_count<=0;
                    pulse<='1'; --ativa o pulso (clk) uma vez por segundo
                end if;
            end if;
        end if;
    end process;
end Behavioral;