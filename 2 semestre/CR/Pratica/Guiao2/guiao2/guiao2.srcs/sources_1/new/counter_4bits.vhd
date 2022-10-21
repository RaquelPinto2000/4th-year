----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 16.03.2022 10:43:08
-- Design Name: 
-- Module Name: counter - Behavioral
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

entity counter is
  Port (clk : in std_logic;
        reset: in std_logic;
        enable: in std_logic; --pulso
        enable_btnU: in std_logic;
        enable_btnD: in std_logic;
        enable_btnR: in std_logic;
        controler: out std_logic;
        count: out std_logic_vector(3 downto 0);
        count_disp: out std_logic_vector(3 downto 0));
end counter;

architecture Behavioral of counter is
    signal s_counter : natural;
    signal s_controler : std_logic := '0';
begin
    process(clk)
    begin
        if(rising_edge(clk)) then
            if(reset='1' or s_counter >15) then
                s_counter <= 0;
            elsif(enable='1') then
                if(s_controler='0') then
                    s_counter <= (s_counter+1);
                end if;
                if(enable_btnR='1') then
                    s_controler <= not s_controler; 
                end if; 
                if(s_counter>0 and enable_btnD='1' and s_controler='1') then
                    s_counter <= (s_counter-1);
                elsif (s_counter<=15 and enable_btnU ='1' and s_controler='1') then
                    s_counter <= (s_counter+1);  
                end if;
            end if;
            count<= std_logic_vector(to_unsigned(s_counter,count'length));
            count_disp<= std_logic_vector(to_unsigned(s_counter,count'length));
            controler<=s_controler;
        end if;
    end process;

end Behavioral;