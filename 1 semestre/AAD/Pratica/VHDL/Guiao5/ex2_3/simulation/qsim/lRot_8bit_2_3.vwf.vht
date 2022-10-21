-- Copyright (C) 2017  Intel Corporation. All rights reserved.
-- Your use of Intel Corporation's design tools, logic functions 
-- and other software and tools, and its AMPP partner logic 
-- functions, and any output files from any of the foregoing 
-- (including device programming or simulation files), and any 
-- associated documentation or information are expressly subject 
-- to the terms and conditions of the Intel Program License 
-- Subscription Agreement, the Intel Quartus Prime License Agreement,
-- the Intel FPGA IP License Agreement, or other applicable license
-- agreement, including, without limitation, that your use is for
-- the sole purpose of programming logic devices manufactured by
-- Intel and sold by Intel or its authorized distributors.  Please
-- refer to the applicable agreement for further details.

-- *****************************************************************************
-- This file contains a Vhdl test bench with test vectors .The test vectors     
-- are exported from a vector file in the Quartus Waveform Editor and apply to  
-- the top level entity of the current Quartus project .The user can use this   
-- testbench to simulate his design using a third-party simulation tool .       
-- *****************************************************************************
-- Generated on "11/09/2021 16:24:35"
                                                             
-- Vhdl Test Bench(with test vectors) for design  :          lRot_8bit_2_3
-- 
-- Simulation tool : 3rd Party
-- 

LIBRARY ieee;                                               
USE ieee.std_logic_1164.all;                                

ENTITY lRot_8bit_2_3_vhd_vec_tst IS
END lRot_8bit_2_3_vhd_vec_tst;
ARCHITECTURE lRot_8bit_2_3_arch OF lRot_8bit_2_3_vhd_vec_tst IS
-- constants                                                 
-- signals                                                   
SIGNAL dIn : STD_LOGIC_VECTOR(7 DOWNTO 0);
SIGNAL dOut : STD_LOGIC_VECTOR(7 DOWNTO 0);
SIGNAL sel : STD_LOGIC_VECTOR(2 DOWNTO 0);
COMPONENT lRot_8bit_2_3
	PORT (
	dIn : IN STD_LOGIC_VECTOR(7 DOWNTO 0);
	dOut : OUT STD_LOGIC_VECTOR(7 DOWNTO 0);
	sel : IN STD_LOGIC_VECTOR(2 DOWNTO 0)
	);
END COMPONENT;
BEGIN
	i1 : lRot_8bit_2_3
	PORT MAP (
-- list connections between master ports and signals
	dIn => dIn,
	dOut => dOut,
	sel => sel
	);
-- dIn[7]
t_prcs_dIn_7: PROCESS
BEGIN
	dIn(7) <= '0';
WAIT;
END PROCESS t_prcs_dIn_7;
-- dIn[6]
t_prcs_dIn_6: PROCESS
BEGIN
	dIn(6) <= '1';
WAIT;
END PROCESS t_prcs_dIn_6;
-- dIn[5]
t_prcs_dIn_5: PROCESS
BEGIN
	dIn(5) <= '0';
WAIT;
END PROCESS t_prcs_dIn_5;
-- dIn[4]
t_prcs_dIn_4: PROCESS
BEGIN
	dIn(4) <= '0';
WAIT;
END PROCESS t_prcs_dIn_4;
-- dIn[3]
t_prcs_dIn_3: PROCESS
BEGIN
	dIn(3) <= '1';
WAIT;
END PROCESS t_prcs_dIn_3;
-- dIn[2]
t_prcs_dIn_2: PROCESS
BEGIN
	dIn(2) <= '0';
WAIT;
END PROCESS t_prcs_dIn_2;
-- dIn[1]
t_prcs_dIn_1: PROCESS
BEGIN
	dIn(1) <= '1';
WAIT;
END PROCESS t_prcs_dIn_1;
-- dIn[0]
t_prcs_dIn_0: PROCESS
BEGIN
	dIn(0) <= '1';
WAIT;
END PROCESS t_prcs_dIn_0;
-- sel[2]
t_prcs_sel_2: PROCESS
BEGIN
	sel(2) <= '0';
WAIT;
END PROCESS t_prcs_sel_2;
-- sel[1]
t_prcs_sel_1: PROCESS
BEGIN
	sel(1) <= '0';
WAIT;
END PROCESS t_prcs_sel_1;
-- sel[0]
t_prcs_sel_0: PROCESS
BEGIN
	sel(0) <= '0';
WAIT;
END PROCESS t_prcs_sel_0;
END lRot_8bit_2_3_arch;
