----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 16.03.2022 10:41:04
-- Design Name: 
-- Module Name: counter_1Hz - Behavioral
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

entity counter_1Hz is
  Port (clk : in std_logic;
        btnC: in std_logic; -- botao do reset - btnC
        btnU: in std_logic; -- botao do incremento - btnU
        btnD: in std_logic; -- botao do decremento - btnD
        btnR: in std_logic; -- botao de ativar os botoes btnU e btnD - btnR
        led: out std_logic_vector(3 downto 0);
        seg: out std_logic_vector (6 downto 0);
        an: out std_logic_vector(7 downto 0));
        
        
end counter_1Hz;

architecture Behavioral of counter_1Hz is
signal s_en : std_logic; -- sinal do pulso sem correcao Debounce
signal s_btnC: std_logic; -- com a correcao Debounce
signal s_btnR: std_logic; -- com a correcao Debounce
signal s_btnU: std_logic; -- com a correcao Debounce
signal s_btnD: std_logic; -- com a correcao Debounce
signal s_counter : std_logic_vector(3 downto 0);
signal s_controler: std_logic :='0';
signal s_enable: std_logic := '0';

begin

pulse1Hz: entity work.pulse1Hz(Behavioral)
    port map (clk => clk,
              reset => btnC,
              pulse=>s_en);
              
DebounceUnit_C: entity work.DebounceUnit(Behavioral)
    generic map(kHzClkFreq => 100000,
                mSecMinInWidth=>100,
                inPolarity=>'1',
                outPolarity=>'1')
                
    port map(refclk=>clk,
             dirtyIn=> btnC,
             pulsedOut=>s_btnC);

DebounceUnit_R: entity work.DebounceUnit(Behavioral)
    generic map(kHzClkFreq => 100000,
                mSecMinInWidth=>100,
                inPolarity=>'1',
                outPolarity=>'1')
                
    port map(refclk=>clk,
             dirtyIn=> btnR,
             pulsedOut=>s_btnR);

DebounceUnit_D: entity work.DebounceUnit(Behavioral)
    generic map(kHzClkFreq => 100000,
                mSecMinInWidth=>100,
                inPolarity=>'1',
                outPolarity=>'1')
                
    port map(refclk=>clk,
             dirtyIn=> btnD,
             pulsedOut=>s_btnD); 

DebounceUnit_U: entity work.DebounceUnit(Behavioral)
    generic map(kHzClkFreq => 100000,
                mSecMinInWidth=>100,
                inPolarity=>'1',
                outPolarity=>'1')
                
    port map(refclk=>clk,
             dirtyIn=> btnU,
             pulsedOut=>s_btnU); 
             
counter_4bits: entity work.counter(Behavioral)
    port map (clk =>clk,
              reset => s_btnC,
              enable => s_en,
              enable_btnU => btnU,
              enable_btnD => btnD,
              enable_btnR => btnR,
              controler=> s_controler, -- meter a piscar
              count => led,
              count_disp => s_counter);
           
display_7_seg: entity work.display_7_seg(Behavioral)
    port map (counter => s_counter,
              --an_L => s_an,
              s_seg_L => seg);
 
display_enable: process(s_en)
begin
    if(rising_edge(s_en)) then
        if(s_controler='1') then
           an(0) <= s_enable;
           s_enable <= not s_enable;
        else
           an <= x"FE";
        end if;
    end if;

end process;
end Behavioral;