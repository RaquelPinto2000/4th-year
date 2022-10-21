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

entity control_Unit is
  Port (clk: in std_logic;
        reset : in std_logic;
        s_btnR: in std_logic;
        start_pause: in std_logic;
        is_finished: in std_logic; -- contador chegou ao fim
        status: out std_logic_vector(3 downto 0);
        controler: out std_logic); -- = 1 -> start decrementar normalmente, = 0 -> pause
end control_Unit;

architecture Behavioral of control_Unit is
    type TState is (START, PAUSE, ST1, ST2, ST3, ST4);
    signal pState, nState: TState; -- estado presente e proximo estado
    
begin

sync_process : process(clk)
    begin
        if (rising_edge (clk)) then
            if (reset = '1') then
                pState <= PAUSE;        
            else
                pState <= nState;
            end if;
         end if;
     end process; 

comb_process : process(clk, pState, reset, start_pause, is_finished, s_btnR)
    begin
        case pState is
            when PAUSE =>
                status<="0000";
                if (start_pause = '1') then
                    nState <= START;
                elsif (s_btnR = '1') then
                    nState <= ST4;
                else
                    nState <= PAUSE;
                end if;              
                controler <= '0';
            
            when START =>
                status<="0000";
                controler <= '0';
                if (start_pause = '1') then
                    nState <= PAUSE;
                elsif (is_finished = '1') then
                    nState <= PAUSE;
                elsif (s_btnR = '1') then
                    nState <= ST4;
                    controler <= '0';
                else 
                    nState <= START;
                    controler <= '1';                
                end if; 
                
             -- ativar o us    
            when ST1 =>
                status<="0001";
                controler <= '0';
                if(s_btnR='1') then
                    nState <= PAUSE;
                    controler <= '0';
                else
                    nState <=ST1;
                end if;
             
             -- ativar o ds
            when ST2 =>
                status<="0010";
                controler <= '0';
                if(s_btnR='1') then
                    nState <= ST1;
                else
                    nState <=ST2;
                end if;
             
             -- ativar o um
            when ST3 =>
                status<="0100";
                controler <= '0';
                if(s_btnR='1') then
                    nState <= ST2;
                else
                    nState <=ST3;
                end if;
             
             -- ativar o dm
            when ST4 =>
                status<= "1000";
                controler <= '0';
                if(s_btnR='1') then
                    nState <= ST3;
                else
                    nState <=ST4;
                end if;  
                    
            when others =>
                status<="0000";
                controler <= '0';
                nState <= PAUSE;
            end case;
        end process;
        
end Behavioral;
