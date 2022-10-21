----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 23.03.2022 10:16:20
-- Design Name: 
-- Module Name: Nexys4DispDriver - Behavioral
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

entity Nexys4DispDriver is
  Port (clk: in std_logic;
        enable_clk: in std_logic;
        EN_digit : in std_logic_vector (7 downto 0); -- sw de 7 a 0 por ex
        EN_dot: in std_logic_vector(7 downto 0);
        D0: in std_logic_vector(3 downto 0);
        D1: in std_logic_vector(3 downto 0);
        D2: in std_logic_vector(3 downto 0);
        D3: in std_logic_vector(3 downto 0);
        D4: in std_logic_vector(3 downto 0);
        D5: in std_logic_vector(3 downto 0);
        D6: in std_logic_vector(3 downto 0);
        D7: in std_logic_vector(3 downto 0);
        an: out std_logic_vector(7 downto 0);
        seg: out std_logic_vector(6 downto 0);
        dp: out std_logic);
end Nexys4DispDriver;

architecture Behavioral of Nexys4DispDriver is
signal s_en : std_logic; -- sinal do pulso sem correcao Debounce
signal s_counter : std_logic_vector(2 downto 0); -- sinal do pulso sem correcao Debounce
signal s_seg: std_logic_vector(6 downto 0);
--signal s_en_dot: std_logic_vector(7 downto 0);

signal s_valor : std_logic_vector(3 downto 0);
signal s_controler: std_logic;
begin


--s_en_digit <= sw(7 downto 0);
--s_en_dot <=sw(15 downto 8);
           

counter_3bits: entity work.counter(Behavioral)
    port map (clk =>clk, 
              enable => enable_clk,      
              count => s_counter);

mux_seg: entity work.mux_seg(Behavioral)
    port map(counter => s_counter,
             en_digit => EN_digit,
             v0 =>D0,
             v1 =>D1,
             v2 =>D2,
             v3 =>D3,
             v4 =>D4,
             v5 =>D5,
             v6 =>D6,
             v7 =>D7,
             valor  => s_valor,
             controler => s_controler);
           
display_7_seg: entity work.display_7_seg(Behavioral)
    port map (counter => s_valor,
              --an_L => s_an,
              s_seg_L => s_seg);

mux_an: entity work.mux_an(Behavioral)
    port map(counter => s_counter,
             s_an => an);

mux_dp: entity work.mux_dp(Behavioral)
    port map(counter => s_counter,
             en_dot => EN_dot,
             s_dp => dp);
             
  --an <= x"FE";
 
sgMux: process(s_seg, s_controler)
       begin
          if (s_controler = '1') then
            seg <= s_seg;
          else
            seg <= "1111111";
          end if;
       end process;
 
 
    
end Behavioral;
