----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 26.03.2022 14:55:42
-- Design Name: 
-- Module Name: mux_seg - Behavioral
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

entity mux_seg is
  Port ( counter : in std_logic_vector(2 downto 0);
         en_digit : in std_logic_vector(7 downto 0);
         v0: in std_logic_vector(3 downto 0);
         v1: in std_logic_vector(3 downto 0);
         v2: in std_logic_vector(3 downto 0);
         v3: in std_logic_vector(3 downto 0);
         v4: in std_logic_vector(3 downto 0);
         v5: in std_logic_vector(3 downto 0);
         v6: in std_logic_vector(3 downto 0);
         v7: in std_logic_vector(3 downto 0);
         valor: out std_logic_vector(3 downto 0);
         controler: out std_logic);
end mux_seg;

architecture Behavioral of mux_seg is

begin

valor <= v0 when (counter = "000") else
         v1 when (counter = "001") else
         v2 when (counter = "010") else
         v3 when (counter = "011") else
         v4 when (counter = "100") else
         v5 when (counter = "101") else
         v6 when (counter = "110") else
         v7 when (counter = "111") else
         "0000";

controler <= en_digit(0) when (counter = "000") else
             en_digit(1) when (counter = "001") else
             en_digit(2) when (counter = "010") else
             en_digit(3) when (counter = "011") else
             en_digit(4) when (counter = "100") else
             en_digit(5) when (counter = "101") else
             en_digit(6) when (counter = "110") else
             en_digit(7) when (counter = "111") else
             '0';
    
end Behavioral;
