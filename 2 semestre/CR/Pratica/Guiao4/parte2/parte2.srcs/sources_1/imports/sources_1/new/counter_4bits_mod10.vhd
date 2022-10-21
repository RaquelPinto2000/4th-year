----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 30.03.2022 11:22:43
-- Design Name: 
-- Module Name: counter_4bits - Behavioral
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
use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity counter_4bits_mod10 is
  Port (clk: in std_logic; 
        reset: in std_logic;
        enable: in std_logic;
        controler: in std_logic;
        up: in std_logic;
        down: in std_logic;
        status: in std_logic;
        counter : out std_logic_vector(3 downto 0);
        zero: out std_logic); -- sinal que indica se chegou a 0
end counter_4bits_mod10;

architecture Behavioral of counter_4bits_mod10 is
      signal s_counter : natural := 9;
begin

    process(clk)
    begin
        if(rising_edge(clk)) then
           if(reset = '1' or s_counter < 0 or s_counter >9) then
                s_counter <= 9;
           --decrementar o contador 
           elsif(enable ='1' and controler ='1') then
                s_counter <= (s_counter-1);           
           -- mudar o valor do contador
           elsif(status='1') then
                 if(up='1') then    
                    s_counter <= (s_counter+1);
                 elsif(down='1') then
                    s_counter <= (s_counter-1);
                 end if;
           end if;      
           if(s_counter=0 and status='0') then
                zero<='1';
           else 
                zero<='0';
           end if;
           counter<= std_logic_vector(to_unsigned(s_counter,counter'length));
        end if;
    end process;

end Behavioral;
