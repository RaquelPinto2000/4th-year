----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 02.04.2022 17:00:06
-- Design Name: 
-- Module Name: control_Unit - Behavioral
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

-- maquina de estados- pause e start
entity control_Unit is
  Port (clk: in std_logic;
        reset : in std_logic;
        start_pause: in std_logic;
        is_finished: in std_logic; -- contador chegou ao fim
        controler: out std_logic); -- = 1 -> start, = 0 pause
end control_Unit;

architecture Behavioral of control_Unit is
    type TState is (START, PAUSE);
    signal pState, nState: TState; -- estado presente e proximo estado
    
begin

sync_process : process(clk)
    begin
        if (rising_edge (clk)) then
            if (reset = '1') then -- estado pause para controler ficar a 0
                pState <= PAUSE;        
            else
                pState <= nState;
            end if;
         end if;
     end process; 

comb_process : process(clk, pState, reset, start_pause, is_finished)
    begin
        case pState is
            when PAUSE =>
                if (start_pause = '1') then
                    nState <= START;
                else
                    nState <= PAUSE;
                end if;              
                controler <= '0';
            
            when START =>
                controler <= '0';
                if (start_pause = '1') then
                    nState <= PAUSE;
                elsif (is_finished = '1') then
                    nState <= PAUSE;
                else 
                    nState <= START;
                    controler <= '1';                
                end if;     
                  
            when others =>
                controler <= '0';
                nState <= PAUSE;
            end case;
        end process;
        
end Behavioral;
