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
        btnU : in std_logic;
        btnD : in std_logic;
        an: out std_logic_vector(7 downto 0);
        seg: out std_logic_vector(6 downto 0);
        dp: out std_logic;
        led: out std_logic_vector(0 downto 0));
end countdown_timer;

architecture Behavioral of countdown_timer is

signal s_led : std_logic;
signal s_en,s_enCounter, s_en2hz, s_en4hz : std_logic;
signal s_dm, s_um, s_us, s_ds : std_logic_vector(3 downto 0);
signal s_dp_en : std_logic_vector(7 downto 0);
signal s_dp : std_logic := '1';
signal s_btnC, s_btnR, s_btnU, s_btnD: std_logic; -- botoes
signal s_controler : std_logic; -- pause/start
signal s_status: std_logic_vector(3 downto 0);
signal s_EN_digit, s_an: std_logic_vector(7 downto 0);
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

flipflop_U: entity work.flip_flop(Behavioral)
    port map (clk => clk,
             dataIn => btnU,
             dataOut => s_btnU);

flipflop_D: entity work.flip_flop(Behavioral)
    port map (clk => clk,
             dataIn => btnD,
             dataOut => s_btnD);
        
PulseGenerator_Counter: entity work.PulseGenerator_counter(Behavioral)  -- 1hz
    port map (clk => clk,
              reset => '0',
              pulse=> s_enCounter);
      
PulseGenerator: entity work.PulseGenerator(Behavioral)-- 800 hz -> alternar os ans 
    port map (clk => clk,
              reset => '0',
              pulse=> s_en);

PulseGenerator_2Hz: entity work.PulseGenerator_2Hz(Behavioral)  -- 2hz -> up/down no modo de ajust
    port map (clk => clk,
              reset => '0',
              pulse=> s_en2hz);
              
PulseGenerator_4Hz: entity work.PulseGenerator_4Hz(Behavioral)  -- 4hz -> piscar no modo de ajuste
    port map (clk => clk,
              reset => '0',
              pulse=> s_en4hz);
              
                      
control_Unit: entity work.control_Unit(Behavioral)
     port map (clk => clk,
              reset => '0',
              s_btnR => s_btnR,
              start_pause => s_btnC,
              is_finished => s_led, -- contador chegou ao fim
              status => s_status,
              controler => s_controler);
                   
counter_total: entity work.counter_total (Behavioral)
    port map(clk => clk,
             clk_2Hz => s_en2hz,  
             reset => '0',
             enable => s_enCounter, -- pulso
             controler => s_controler,
             up=> s_btnU,
             down=> s_btnD,
             status => s_status,
             DM => s_dm,
             UM => s_um,
             DS => s_ds,
             US => s_us,
             led =>s_led);
                         
blinkPoint: process(clk, s_en2hz, s_controler)
    begin
        if(rising_edge(clk) and s_en2hz='1' and s_controler = '1') then
            s_dp <= not s_dp;
        end if;
    end process;
    s_dp_en <= "00000" & s_dp & "00";             

blinkDigit: process(clk, s_en4hz)
    begin
        if(rising_edge(clk) and s_en4hz='1') then
            s_EN_digit <= "00001111";
            if(s_status = "1000") then
                if(s_EN_digit = "00000111")then 
                    s_EN_digit <= "00001111";
                else
                    s_EN_digit <= "00000111";
                end if;
            elsif (s_status = "0100") then
                 if ( s_EN_digit = "00001011") then
                    s_EN_digit <= "00001111";
                 else
                     s_EN_digit <= "00001011";
                 end if;
            elsif (s_status = "0010") then
                  if ( s_EN_digit="00001101") then
                    s_EN_digit <= "00001111";
                  else
                    s_EN_digit <= "00001101";
                  end if;    
            elsif (s_status = "0001") then
                  if(s_EN_digit = "00001110") then
                      s_EN_digit <= "00001111";
                  else
                      s_EN_digit <= "00001110";
                  end if; 
            else 
                 s_EN_digit <= "00001111";
            end if;
        end if;
    end process;   


Nexys4DispDriver: entity work.Nexys4DispDriver (Behavioral)
    port map (clk=> clk,
              enable_clk => s_en,
              EN_digit => s_EN_digit, -- ativar os 4 ulimos displays
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
