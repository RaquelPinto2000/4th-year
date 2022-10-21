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

-- VENDOR "Altera"
-- PROGRAM "Quartus Prime"
-- VERSION "Version 17.1.0 Build 590 10/25/2017 SJ Lite Edition"

-- DATE "11/09/2021 16:24:36"

-- 
-- Device: Altera EP4CGX15BF14C6 Package FBGA169
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY CYCLONEIV;
LIBRARY IEEE;
USE CYCLONEIV.CYCLONEIV_COMPONENTS.ALL;
USE IEEE.STD_LOGIC_1164.ALL;

ENTITY 	hard_block IS
    PORT (
	devoe : IN std_logic;
	devclrn : IN std_logic;
	devpor : IN std_logic
	);
END hard_block;

-- Design Ports Information
-- ~ALTERA_NCEO~	=>  Location: PIN_N5,	 I/O Standard: 2.5 V,	 Current Strength: 16mA
-- ~ALTERA_DATA0~	=>  Location: PIN_A5,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- ~ALTERA_ASDO~	=>  Location: PIN_B5,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- ~ALTERA_NCSO~	=>  Location: PIN_C5,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- ~ALTERA_DCLK~	=>  Location: PIN_A4,	 I/O Standard: 2.5 V,	 Current Strength: Default


ARCHITECTURE structure OF hard_block IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL \~ALTERA_DATA0~~padout\ : std_logic;
SIGNAL \~ALTERA_ASDO~~padout\ : std_logic;
SIGNAL \~ALTERA_NCSO~~padout\ : std_logic;
SIGNAL \~ALTERA_DATA0~~ibuf_o\ : std_logic;
SIGNAL \~ALTERA_ASDO~~ibuf_o\ : std_logic;
SIGNAL \~ALTERA_NCSO~~ibuf_o\ : std_logic;

BEGIN

ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;
END structure;


LIBRARY CYCLONEIV;
LIBRARY IEEE;
USE CYCLONEIV.CYCLONEIV_COMPONENTS.ALL;
USE IEEE.STD_LOGIC_1164.ALL;

ENTITY 	lRot_8bit_2_3 IS
    PORT (
	dIn : IN std_logic_vector(7 DOWNTO 0);
	sel : IN std_logic_vector(2 DOWNTO 0);
	dOut : OUT std_logic_vector(7 DOWNTO 0)
	);
END lRot_8bit_2_3;

-- Design Ports Information
-- sel[2]	=>  Location: PIN_F13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[0]	=>  Location: PIN_K13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[1]	=>  Location: PIN_J13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[2]	=>  Location: PIN_L12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[3]	=>  Location: PIN_M13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[4]	=>  Location: PIN_G10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[5]	=>  Location: PIN_L13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[6]	=>  Location: PIN_G9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dOut[7]	=>  Location: PIN_N13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[1]	=>  Location: PIN_F12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[5]	=>  Location: PIN_E13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- sel[1]	=>  Location: PIN_L9,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[3]	=>  Location: PIN_F11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[7]	=>  Location: PIN_L7,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- sel[0]	=>  Location: PIN_K11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[2]	=>  Location: PIN_H10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[6]	=>  Location: PIN_K12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[4]	=>  Location: PIN_H12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- dIn[0]	=>  Location: PIN_N10,	 I/O Standard: 2.5 V,	 Current Strength: Default


ARCHITECTURE structure OF lRot_8bit_2_3 IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_dIn : std_logic_vector(7 DOWNTO 0);
SIGNAL ww_sel : std_logic_vector(2 DOWNTO 0);
SIGNAL ww_dOut : std_logic_vector(7 DOWNTO 0);
SIGNAL \sel[2]~input_o\ : std_logic;
SIGNAL \dOut[0]~output_o\ : std_logic;
SIGNAL \dOut[1]~output_o\ : std_logic;
SIGNAL \dOut[2]~output_o\ : std_logic;
SIGNAL \dOut[3]~output_o\ : std_logic;
SIGNAL \dOut[4]~output_o\ : std_logic;
SIGNAL \dOut[5]~output_o\ : std_logic;
SIGNAL \dOut[6]~output_o\ : std_logic;
SIGNAL \dOut[7]~output_o\ : std_logic;
SIGNAL \sel[1]~input_o\ : std_logic;
SIGNAL \dIn[7]~input_o\ : std_logic;
SIGNAL \dIn[3]~input_o\ : std_logic;
SIGNAL \blk1|mult4|or0|y~1_combout\ : std_logic;
SIGNAL \dIn[5]~input_o\ : std_logic;
SIGNAL \dIn[1]~input_o\ : std_logic;
SIGNAL \blk1|mult4|or0|y~0_combout\ : std_logic;
SIGNAL \sel[0]~input_o\ : std_logic;
SIGNAL \blk1|mult4|or0|y~2_combout\ : std_logic;
SIGNAL \dIn[6]~input_o\ : std_logic;
SIGNAL \dIn[2]~input_o\ : std_logic;
SIGNAL \blk1|mult5|or0|y~0_combout\ : std_logic;
SIGNAL \dIn[0]~input_o\ : std_logic;
SIGNAL \dIn[4]~input_o\ : std_logic;
SIGNAL \blk1|mult5|or0|y~1_combout\ : std_logic;
SIGNAL \blk1|mult5|or0|y~2_combout\ : std_logic;
SIGNAL \blk1|mult0|or0|y~0_combout\ : std_logic;
SIGNAL \blk1|mult6|or0|y~0_combout\ : std_logic;
SIGNAL \blk1|mult1|or0|y~0_combout\ : std_logic;
SIGNAL \blk1|mult7|or0|y~0_combout\ : std_logic;
SIGNAL \blk1|mult0|or0|y~1_combout\ : std_logic;
SIGNAL \blk1|mult0|or0|y~2_combout\ : std_logic;
SIGNAL \blk1|mult1|or0|y~1_combout\ : std_logic;
SIGNAL \blk1|mult1|or0|y~2_combout\ : std_logic;
SIGNAL \blk1|mult2|or0|y~0_combout\ : std_logic;
SIGNAL \blk1|mult3|or0|y~0_combout\ : std_logic;

COMPONENT hard_block
    PORT (
	devoe : IN std_logic;
	devclrn : IN std_logic;
	devpor : IN std_logic);
END COMPONENT;

BEGIN

ww_dIn <= dIn;
ww_sel <= sel;
dOut <= ww_dOut;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;
auto_generated_inst : hard_block
PORT MAP (
	devoe => ww_devoe,
	devclrn => ww_devclrn,
	devpor => ww_devpor);

-- Location: IOOBUF_X33_Y15_N2
\dOut[0]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult4|or0|y~2_combout\,
	devoe => ww_devoe,
	o => \dOut[0]~output_o\);

-- Location: IOOBUF_X33_Y15_N9
\dOut[1]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult5|or0|y~2_combout\,
	devoe => ww_devoe,
	o => \dOut[1]~output_o\);

-- Location: IOOBUF_X33_Y12_N2
\dOut[2]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult6|or0|y~0_combout\,
	devoe => ww_devoe,
	o => \dOut[2]~output_o\);

-- Location: IOOBUF_X33_Y10_N2
\dOut[3]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult7|or0|y~0_combout\,
	devoe => ww_devoe,
	o => \dOut[3]~output_o\);

-- Location: IOOBUF_X33_Y22_N9
\dOut[4]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult0|or0|y~2_combout\,
	devoe => ww_devoe,
	o => \dOut[4]~output_o\);

-- Location: IOOBUF_X33_Y12_N9
\dOut[5]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult1|or0|y~2_combout\,
	devoe => ww_devoe,
	o => \dOut[5]~output_o\);

-- Location: IOOBUF_X33_Y22_N2
\dOut[6]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult2|or0|y~0_combout\,
	devoe => ww_devoe,
	o => \dOut[6]~output_o\);

-- Location: IOOBUF_X33_Y10_N9
\dOut[7]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \blk1|mult3|or0|y~0_combout\,
	devoe => ww_devoe,
	o => \dOut[7]~output_o\);

-- Location: IOIBUF_X24_Y0_N8
\sel[1]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_sel(1),
	o => \sel[1]~input_o\);

-- Location: IOIBUF_X14_Y0_N1
\dIn[7]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(7),
	o => \dIn[7]~input_o\);

-- Location: IOIBUF_X33_Y24_N8
\dIn[3]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(3),
	o => \dIn[3]~input_o\);

-- Location: LCCOMB_X32_Y14_N10
\blk1|mult4|or0|y~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult4|or0|y~1_combout\ = (\sel[1]~input_o\ & ((\dIn[3]~input_o\))) # (!\sel[1]~input_o\ & (\dIn[7]~input_o\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111110000110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \sel[1]~input_o\,
	datac => \dIn[7]~input_o\,
	datad => \dIn[3]~input_o\,
	combout => \blk1|mult4|or0|y~1_combout\);

-- Location: IOIBUF_X33_Y25_N8
\dIn[5]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(5),
	o => \dIn[5]~input_o\);

-- Location: IOIBUF_X33_Y16_N1
\dIn[1]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(1),
	o => \dIn[1]~input_o\);

-- Location: LCCOMB_X32_Y14_N16
\blk1|mult4|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult4|or0|y~0_combout\ = (\sel[1]~input_o\ & ((\dIn[1]~input_o\))) # (!\sel[1]~input_o\ & (\dIn[5]~input_o\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111110000110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \sel[1]~input_o\,
	datac => \dIn[5]~input_o\,
	datad => \dIn[1]~input_o\,
	combout => \blk1|mult4|or0|y~0_combout\);

-- Location: IOIBUF_X33_Y11_N1
\sel[0]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_sel(0),
	o => \sel[0]~input_o\);

-- Location: LCCOMB_X32_Y14_N4
\blk1|mult4|or0|y~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult4|or0|y~2_combout\ = (\sel[0]~input_o\ & ((\blk1|mult4|or0|y~0_combout\))) # (!\sel[0]~input_o\ & (\blk1|mult4|or0|y~1_combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100101011001010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \blk1|mult4|or0|y~1_combout\,
	datab => \blk1|mult4|or0|y~0_combout\,
	datac => \sel[0]~input_o\,
	combout => \blk1|mult4|or0|y~2_combout\);

-- Location: IOIBUF_X33_Y11_N8
\dIn[6]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(6),
	o => \dIn[6]~input_o\);

-- Location: IOIBUF_X33_Y14_N1
\dIn[2]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(2),
	o => \dIn[2]~input_o\);

-- Location: LCCOMB_X32_Y14_N30
\blk1|mult5|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult5|or0|y~0_combout\ = (\sel[1]~input_o\ & ((\dIn[2]~input_o\))) # (!\sel[1]~input_o\ & (\dIn[6]~input_o\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1110111000100010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \dIn[6]~input_o\,
	datab => \sel[1]~input_o\,
	datad => \dIn[2]~input_o\,
	combout => \blk1|mult5|or0|y~0_combout\);

-- Location: IOIBUF_X26_Y0_N8
\dIn[0]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(0),
	o => \dIn[0]~input_o\);

-- Location: IOIBUF_X33_Y14_N8
\dIn[4]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_dIn(4),
	o => \dIn[4]~input_o\);

-- Location: LCCOMB_X32_Y14_N8
\blk1|mult5|or0|y~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult5|or0|y~1_combout\ = (\sel[1]~input_o\ & ((\dIn[4]~input_o\))) # (!\sel[1]~input_o\ & (\dIn[0]~input_o\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1110111000100010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \dIn[0]~input_o\,
	datab => \sel[1]~input_o\,
	datad => \dIn[4]~input_o\,
	combout => \blk1|mult5|or0|y~1_combout\);

-- Location: LCCOMB_X32_Y14_N2
\blk1|mult5|or0|y~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult5|or0|y~2_combout\ = (\sel[0]~input_o\ & (\blk1|mult5|or0|y~0_combout\)) # (!\sel[0]~input_o\ & ((\blk1|mult5|or0|y~1_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010110010101100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \blk1|mult5|or0|y~0_combout\,
	datab => \blk1|mult5|or0|y~1_combout\,
	datac => \sel[0]~input_o\,
	combout => \blk1|mult5|or0|y~2_combout\);

-- Location: LCCOMB_X32_Y14_N20
\blk1|mult0|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult0|or0|y~0_combout\ = (\sel[1]~input_o\ & (\dIn[5]~input_o\)) # (!\sel[1]~input_o\ & ((\dIn[1]~input_o\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111001111000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \sel[1]~input_o\,
	datac => \dIn[5]~input_o\,
	datad => \dIn[1]~input_o\,
	combout => \blk1|mult0|or0|y~0_combout\);

-- Location: LCCOMB_X32_Y14_N6
\blk1|mult6|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult6|or0|y~0_combout\ = (\sel[0]~input_o\ & (\blk1|mult4|or0|y~1_combout\)) # (!\sel[0]~input_o\ & ((\blk1|mult0|or0|y~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010110010101100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \blk1|mult4|or0|y~1_combout\,
	datab => \blk1|mult0|or0|y~0_combout\,
	datac => \sel[0]~input_o\,
	combout => \blk1|mult6|or0|y~0_combout\);

-- Location: LCCOMB_X32_Y14_N0
\blk1|mult1|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult1|or0|y~0_combout\ = (\sel[1]~input_o\ & (\dIn[6]~input_o\)) # (!\sel[1]~input_o\ & ((\dIn[2]~input_o\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1011101110001000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \dIn[6]~input_o\,
	datab => \sel[1]~input_o\,
	datad => \dIn[2]~input_o\,
	combout => \blk1|mult1|or0|y~0_combout\);

-- Location: LCCOMB_X32_Y14_N18
\blk1|mult7|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult7|or0|y~0_combout\ = (\sel[0]~input_o\ & (\blk1|mult5|or0|y~1_combout\)) # (!\sel[0]~input_o\ & ((\blk1|mult1|or0|y~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100111111000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \blk1|mult5|or0|y~1_combout\,
	datac => \sel[0]~input_o\,
	datad => \blk1|mult1|or0|y~0_combout\,
	combout => \blk1|mult7|or0|y~0_combout\);

-- Location: LCCOMB_X32_Y14_N12
\blk1|mult0|or0|y~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult0|or0|y~1_combout\ = (\sel[1]~input_o\ & (\dIn[7]~input_o\)) # (!\sel[1]~input_o\ & ((\dIn[3]~input_o\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111001111000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \sel[1]~input_o\,
	datac => \dIn[7]~input_o\,
	datad => \dIn[3]~input_o\,
	combout => \blk1|mult0|or0|y~1_combout\);

-- Location: LCCOMB_X32_Y14_N22
\blk1|mult0|or0|y~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult0|or0|y~2_combout\ = (\sel[0]~input_o\ & ((\blk1|mult0|or0|y~0_combout\))) # (!\sel[0]~input_o\ & (\blk1|mult0|or0|y~1_combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100101011001010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \blk1|mult0|or0|y~1_combout\,
	datab => \blk1|mult0|or0|y~0_combout\,
	datac => \sel[0]~input_o\,
	combout => \blk1|mult0|or0|y~2_combout\);

-- Location: LCCOMB_X32_Y14_N24
\blk1|mult1|or0|y~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult1|or0|y~1_combout\ = (\sel[1]~input_o\ & (\dIn[0]~input_o\)) # (!\sel[1]~input_o\ & ((\dIn[4]~input_o\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1011101110001000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \dIn[0]~input_o\,
	datab => \sel[1]~input_o\,
	datad => \dIn[4]~input_o\,
	combout => \blk1|mult1|or0|y~1_combout\);

-- Location: LCCOMB_X32_Y14_N26
\blk1|mult1|or0|y~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult1|or0|y~2_combout\ = (\sel[0]~input_o\ & (\blk1|mult1|or0|y~0_combout\)) # (!\sel[0]~input_o\ & ((\blk1|mult1|or0|y~1_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100111111000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \blk1|mult1|or0|y~0_combout\,
	datac => \sel[0]~input_o\,
	datad => \blk1|mult1|or0|y~1_combout\,
	combout => \blk1|mult1|or0|y~2_combout\);

-- Location: LCCOMB_X32_Y14_N28
\blk1|mult2|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult2|or0|y~0_combout\ = (\sel[0]~input_o\ & (\blk1|mult0|or0|y~1_combout\)) # (!\sel[0]~input_o\ & ((\blk1|mult4|or0|y~0_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1010110010101100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \blk1|mult0|or0|y~1_combout\,
	datab => \blk1|mult4|or0|y~0_combout\,
	datac => \sel[0]~input_o\,
	combout => \blk1|mult2|or0|y~0_combout\);

-- Location: LCCOMB_X32_Y14_N14
\blk1|mult3|or0|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \blk1|mult3|or0|y~0_combout\ = (\sel[0]~input_o\ & ((\blk1|mult1|or0|y~1_combout\))) # (!\sel[0]~input_o\ & (\blk1|mult5|or0|y~0_combout\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1100101011001010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \blk1|mult5|or0|y~0_combout\,
	datab => \blk1|mult1|or0|y~1_combout\,
	datac => \sel[0]~input_o\,
	combout => \blk1|mult3|or0|y~0_combout\);

-- Location: IOIBUF_X33_Y16_N8
\sel[2]~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_sel(2),
	o => \sel[2]~input_o\);

ww_dOut(0) <= \dOut[0]~output_o\;

ww_dOut(1) <= \dOut[1]~output_o\;

ww_dOut(2) <= \dOut[2]~output_o\;

ww_dOut(3) <= \dOut[3]~output_o\;

ww_dOut(4) <= \dOut[4]~output_o\;

ww_dOut(5) <= \dOut[5]~output_o\;

ww_dOut(6) <= \dOut[6]~output_o\;

ww_dOut(7) <= \dOut[7]~output_o\;
END structure;


