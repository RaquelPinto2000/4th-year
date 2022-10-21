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

entity countdown_timer is
  Port (clk: in std_logic;
        btnC : in std_logic;
        btnR : in std_logic;
        an: out std_logic_vector(7 downto 0);
        seg: out std_logic_vector(6 downto 0);
        dp: out std_logic;
        led: out std_logic_vector(0 downto 0));
end countdown_timer;

architecture Behavioral of countdown_timer is

signal s_led : std_logic;
signal s_en,s_enCounter : std_logic;
signal s_dm, s_um, s_us, s_ds : std_logic_vector(3 downto 0);
signal s_dp_en : std_logic_vector(7 downto 0);
signal s_dp : std_logic := '1';
signal s_btnC, s_btnR: std_logic; -- botoes
signal s_controler : std_logic; -- pause/start
begin

DebounceUnit_C: entity work.DebounceUnit(Behavioral)
    generic map(kHzClkFreq => 100_000,
                mSecMinInWidth=>100,
                inPolarity=>'1',
                outPolarity=>'1')
                
    port map(refclk=>clk,
             dirtyIn=> btnC,
             pulsedOut=>s_btnC);

DebounceUnit_R: entity work.DebounceUnit(Behavioral)
    generic map(kHzClkFreq => 100_000,
                mSecMinInWidth=>100,
                inPolarity=>'1',
                outPolarity=>'1')
                
    port map(refclk=>clk,
             dirtyIn=> btnR,
             pulsedOut=>s_btnR);
        
PulseGenerator_Counter: entity work.PulseGenerator_counter(Behavioral)  -- 1hz
    port map (clk => clk,
              reset => s_btnR,
              pulse=> s_enCounter);
      
PulseGenerator: entity work.PulseGenerator(Behavioral)-- 800 hz -> alternar os ans 
    port map (clk => clk,
              reset => s_btnR,
              pulse=> s_en);

control_Unit: entity work.control_Unit(Behavioral)
     port map (clk => clk,
              reset => s_btnR,
              start_pause => s_btnC,
              is_finished => s_led, -- contador chegou ao fim
              controler => s_controler);
                   
counter_total: entity work.counter_total (Behavioral)
    port map(clk => clk,
             reset => s_btnR,
             enable => s_enCounter, -- pulso
             controler => s_controler,
             up_down=> '0',
             DM => s_dm,
             UM => s_um,
             DS => s_ds,
             US => s_us,
             led =>s_led);
                         
blinkPoint: process(s_enCounter, s_controler)
    begin
        if(rising_edge(s_enCounter) and s_controler = '1') then
            s_dp <= not s_dp;
        end if;
    end process;
    s_dp_en <= "00000" & s_dp & "00";             
        
Nexys4DispDriver: entity work.Nexys4DispDriver (Behavioral)
    port map (clk=> clk,
              enable_clk => s_en,
              EN_digit => "00001111", -- ativar os 4 ulimos displays
              EN_dot => s_dp_en, -- ponto do meio a piscar 1 hz
              D0 => s_us, --us
              D1 => s_ds,-- ds
              D2 => s_um,--um
              D3 => s_dm,--dm
              D4 => "0000",
              D5 => "0000",
              D6 => "0000",
              D7 => "0000",
              an => an,
              seg => seg,
              dp => dp);

led(0) <= s_led;
end Behavioral;
