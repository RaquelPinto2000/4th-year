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
-- Generated on "12/06/2021 20:08:02"
                                                             
-- Vhdl Test Bench(with test vectors) for design  :          BitSerialEnc
-- 
-- Simulation tool : 3rd Party
-- 

LIBRARY ieee;                                               
USE ieee.std_logic_1164.all;                                

ENTITY BitSerialEnc_vhd_vec_tst IS
END BitSerialEnc_vhd_vec_tst;
ARCHITECTURE BitSerialEnc_arch OF BitSerialEnc_vhd_vec_tst IS
-- constants                                                 
-- signals                                                   
SIGNAL clk : STD_LOGIC;
SIGNAL m : STD_LOGIC;
SIGNAL nGRst : STD_LOGIC;
SIGNAL saida : STD_LOGIC_VECTOR(4 DOWNTO 0);
SIGNAL x : STD_LOGIC;
COMPONENT BitSerialEnc
	PORT (
	clk : IN STD_LOGIC;
	m : IN STD_LOGIC;
	nGRst : IN STD_LOGIC;
	saida : BUFFER STD_LOGIC_VECTOR(4 DOWNTO 0);
	x : BUFFER STD_LOGIC
	);
END COMPONENT;
BEGIN
	i1 : BitSerialEnc
	PORT MAP (
-- list connections between master ports and signals
	clk => clk,
	m => m,
	nGRst => nGRst,
	saida => saida,
	x => x
	);

-- clk
t_prcs_clk: PROCESS
BEGIN
LOOP
	clk <= '0';
	WAIT FOR 20000 ps;
	clk <= '1';
	WAIT FOR 20000 ps;
	IF (NOW >= 1000000 ps) THEN WAIT; END IF;
END LOOP;
END PROCESS t_prcs_clk;
END BitSerialEnc_arch;
