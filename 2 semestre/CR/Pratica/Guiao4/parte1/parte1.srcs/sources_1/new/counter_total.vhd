----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 30.03.2022 11:23:46
-- Design Name: 
-- Module Name: counter_total - Behavioral
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

entity counter_total is
  Port (clk: in std_logic; 
        reset: in std_logic;
        enable: in std_logic; -- vem do pulso
        controler: in std_logic; -- pause/start
        up_down: in std_logic; -- 0 por enquanto (sempre a descrementar)
        DM : out std_logic_vector(3 downto 0);
        UM : out std_logic_vector(3 downto 0);
        DS : out std_logic_vector(3 downto 0);
        US : out std_logic_vector(3 downto 0);
        led: out std_logic);
end counter_total;

architecture Behavioral of counter_total is
signal s_counter_us,s_counter_ds, s_counter_um, s_counter_dm : std_logic_vector(3 downto 0);
signal s_zero_us,s_zero_ds, s_zero_um, s_zero_dm : std_logic;
signal s_enable_ds,s_enable_um, s_enable_dm : std_logic;
--signal s_up_down:std_logic;
begin

--s_up_down <= '1'  when... else
             --'0'
--ligar os outros 4 counters
-- modificar os couters para ter a decremetar e incrementar
counter_us: entity work.counter_4bits_mod10(Behavioral)
    Port Map(clk => clk,
             reset => reset,
             enable => enable,
             controler => controler,
             up_down => up_down,
             counter => s_counter_us,
             zero => s_zero_us);

s_enable_ds <= (enable and s_zero_us);
  
counter_ds: entity work.counter_4bits_mod6(Behavioral)
    Port Map(clk => clk,
             reset => reset,
             enable => s_enable_ds,
             up_down => up_down,
             counter => s_counter_ds,
             zero => s_zero_ds);

s_enable_um <= (enable and s_zero_ds and s_zero_us);

counter_um: entity work.counter_4bits_mod10(Behavioral)
    Port Map(clk => clk,
             reset => reset,
             enable => s_enable_um,
             controler => '1',
             up_down => up_down,
             counter => s_counter_um,
             zero => s_zero_um);

s_enable_dm <= (enable and s_zero_um and s_zero_ds and s_zero_us );

counter_dm: entity work.counter_4bits_mod6(Behavioral)
    Port Map(clk => clk,
             reset => reset,
             enable => s_enable_dm,
             up_down => up_down,
             counter => s_counter_dm,
             zero => s_zero_dm);
 
-- podes tirar isto e ligar diretamente nas saidas
 DM <= s_counter_dm;
 UM <= s_counter_um;
 DS <= s_counter_ds;
 US <=s_counter_us;
 
led <= '1' when (s_counter_dm ="0000" and s_counter_ds ="0000" and
                 s_counter_um ="0000" and s_counter_dm ="0000") else 
       '0';
end Behavioral;