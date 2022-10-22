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

-- DATE "12/08/2021 15:31:15"

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


LIBRARY ALTERA;
LIBRARY CYCLONEIV;
LIBRARY IEEE;
USE ALTERA.ALTERA_PRIMITIVES_COMPONENTS.ALL;
USE CYCLONEIV.CYCLONEIV_COMPONENTS.ALL;
USE IEEE.STD_LOGIC_1164.ALL;

ENTITY 	BitSerialEnc IS
    PORT (
	m : IN std_logic;
	clk : IN std_logic;
	nGRst : IN std_logic;
	x : OUT std_logic;
	saida : OUT std_logic_vector(4 DOWNTO 0)
	);
END BitSerialEnc;

-- Design Ports Information
-- x	=>  Location: PIN_C13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- saida[0]	=>  Location: PIN_D13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- saida[1]	=>  Location: PIN_E10,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- saida[2]	=>  Location: PIN_A13,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- saida[3]	=>  Location: PIN_D11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- saida[4]	=>  Location: PIN_D12,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- m	=>  Location: PIN_C11,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- clk	=>  Location: PIN_J7,	 I/O Standard: 2.5 V,	 Current Strength: Default
-- nGRst	=>  Location: PIN_C12,	 I/O Standard: 2.5 V,	 Current Strength: Default


ARCHITECTURE structure OF BitSerialEnc IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_m : std_logic;
SIGNAL ww_clk : std_logic;
SIGNAL ww_nGRst : std_logic;
SIGNAL ww_x : std_logic;
SIGNAL ww_saida : std_logic_vector(4 DOWNTO 0);
SIGNAL \clk~inputclkctrl_INCLK_bus\ : std_logic_vector(3 DOWNTO 0);
SIGNAL \x~output_o\ : std_logic;
SIGNAL \saida[0]~output_o\ : std_logic;
SIGNAL \saida[1]~output_o\ : std_logic;
SIGNAL \saida[2]~output_o\ : std_logic;
SIGNAL \saida[3]~output_o\ : std_logic;
SIGNAL \saida[4]~output_o\ : std_logic;
SIGNAL \clk~input_o\ : std_logic;
SIGNAL \clk~inputclkctrl_outclk\ : std_logic;
SIGNAL \m~input_o\ : std_logic;
SIGNAL \count|ff0|Q~0_combout\ : std_logic;
SIGNAL \nGRst~input_o\ : std_logic;
SIGNAL \count|ff1|Q~0_combout\ : std_logic;
SIGNAL \count|ff1|Q~q\ : std_logic;
SIGNAL \count|ff2|Q~0_combout\ : std_logic;
SIGNAL \count|ff2|Q~q\ : std_logic;
SIGNAL \count|ff3|Q~0_combout\ : std_logic;
SIGNAL \count|ff3|Q~q\ : std_logic;
SIGNAL \count|ad3|y~combout\ : std_logic;
SIGNAL \count|ff4|Q~0_combout\ : std_logic;
SIGNAL \count|ff4|Q~q\ : std_logic;
SIGNAL \cont|rst~combout\ : std_logic;
SIGNAL \count|ff0|Q~q\ : std_logic;
SIGNAL \cont|cMem|prog~2_combout\ : std_logic;
SIGNAL \cont|cMem|prog~0_combout\ : std_logic;
SIGNAL \cont|cMem|prog~3_combout\ : std_logic;
SIGNAL \flip2|Q~0_combout\ : std_logic;
SIGNAL \flip2|Q~q\ : std_logic;
SIGNAL \cont|cMem|prog~6_combout\ : std_logic;
SIGNAL \flip3|Q~0_combout\ : std_logic;
SIGNAL \flip3|Q~q\ : std_logic;
SIGNAL \cont|cMem|prog~5_combout\ : std_logic;
SIGNAL \flip0|Q~0_combout\ : std_logic;
SIGNAL \flip0|Q~q\ : std_logic;
SIGNAL \cont|cMem|prog~4_combout\ : std_logic;
SIGNAL \flip1|Q~0_combout\ : std_logic;
SIGNAL \flip1|Q~q\ : std_logic;
SIGNAL \cont|cMem|prog~1_combout\ : std_logic;
SIGNAL \m4_1|orMux|y~0_combout\ : std_logic;
SIGNAL \m4_1|orMux|y~1_combout\ : std_logic;
SIGNAL \m2_1|orMux|y~0_combout\ : std_logic;
SIGNAL \flip4|Q~q\ : std_logic;
SIGNAL \cont|ALT_INV_rst~combout\ : std_logic;

COMPONENT hard_block
    PORT (
	devoe : IN std_logic;
	devclrn : IN std_logic;
	devpor : IN std_logic);
END COMPONENT;

BEGIN

ww_m <= m;
ww_clk <= clk;
ww_nGRst <= nGRst;
x <= ww_x;
saida <= ww_saida;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;

\clk~inputclkctrl_INCLK_bus\ <= (vcc & vcc & vcc & \clk~input_o\);
\cont|ALT_INV_rst~combout\ <= NOT \cont|rst~combout\;
auto_generated_inst : hard_block
PORT MAP (
	devoe => ww_devoe,
	devclrn => ww_devclrn,
	devpor => ww_devpor);

-- Location: IOOBUF_X29_Y31_N2
\x~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \flip4|Q~q\,
	devoe => ww_devoe,
	o => \x~output_o\);

-- Location: IOOBUF_X29_Y31_N9
\saida[0]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \count|ff0|Q~q\,
	devoe => ww_devoe,
	o => \saida[0]~output_o\);

-- Location: IOOBUF_X33_Y27_N2
\saida[1]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \count|ff1|Q~q\,
	devoe => ww_devoe,
	o => \saida[1]~output_o\);

-- Location: IOOBUF_X26_Y31_N2
\saida[2]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \count|ff2|Q~q\,
	devoe => ww_devoe,
	o => \saida[2]~output_o\);

-- Location: IOOBUF_X33_Y28_N2
\saida[3]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \count|ff3|Q~q\,
	devoe => ww_devoe,
	o => \saida[3]~output_o\);

-- Location: IOOBUF_X33_Y28_N9
\saida[4]~output\ : cycloneiv_io_obuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false")
-- pragma translate_on
PORT MAP (
	i => \count|ff4|Q~q\,
	devoe => ww_devoe,
	o => \saida[4]~output_o\);

-- Location: IOIBUF_X16_Y0_N15
\clk~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_clk,
	o => \clk~input_o\);

-- Location: CLKCTRL_G17
\clk~inputclkctrl\ : cycloneiv_clkctrl
-- pragma translate_off
GENERIC MAP (
	clock_type => "global clock",
	ena_register_mode => "none")
-- pragma translate_on
PORT MAP (
	inclk => \clk~inputclkctrl_INCLK_bus\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	outclk => \clk~inputclkctrl_outclk\);

-- Location: IOIBUF_X31_Y31_N1
\m~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_m,
	o => \m~input_o\);

-- Location: LCCOMB_X30_Y29_N26
\count|ff0|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \count|ff0|Q~0_combout\ = !\count|ff0|Q~q\

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000111100001111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \count|ff0|Q~q\,
	combout => \count|ff0|Q~0_combout\);

-- Location: IOIBUF_X31_Y31_N8
\nGRst~input\ : cycloneiv_io_ibuf
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	simulate_z_as => "z")
-- pragma translate_on
PORT MAP (
	i => ww_nGRst,
	o => \nGRst~input_o\);

-- Location: LCCOMB_X30_Y29_N20
\count|ff1|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \count|ff1|Q~0_combout\ = \count|ff0|Q~q\ $ (\count|ff1|Q~q\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0101101001011010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datac => \count|ff1|Q~q\,
	combout => \count|ff1|Q~0_combout\);

-- Location: FF_X30_Y29_N21
\count|ff1|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \count|ff1|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \count|ff1|Q~q\);

-- Location: LCCOMB_X30_Y29_N18
\count|ff2|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \count|ff2|Q~0_combout\ = \count|ff2|Q~q\ $ (((\count|ff0|Q~q\ & \count|ff1|Q~q\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0111100001111000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff1|Q~q\,
	datac => \count|ff2|Q~q\,
	combout => \count|ff2|Q~0_combout\);

-- Location: FF_X30_Y29_N19
\count|ff2|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \count|ff2|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \count|ff2|Q~q\);

-- Location: LCCOMB_X30_Y29_N8
\count|ff3|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \count|ff3|Q~0_combout\ = \count|ff3|Q~q\ $ (((\count|ff0|Q~q\ & (\count|ff2|Q~q\ & \count|ff1|Q~q\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0111100011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \count|ff3|Q~0_combout\);

-- Location: FF_X30_Y29_N9
\count|ff3|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \count|ff3|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \count|ff3|Q~q\);

-- Location: LCCOMB_X30_Y29_N24
\count|ad3|y\ : cycloneiv_lcell_comb
-- Equation(s):
-- \count|ad3|y~combout\ = (\count|ff0|Q~q\ & (\count|ff2|Q~q\ & (\count|ff3|Q~q\ & \count|ff1|Q~q\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1000000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \count|ad3|y~combout\);

-- Location: LCCOMB_X31_Y29_N24
\count|ff4|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \count|ff4|Q~0_combout\ = (\count|ff4|Q~q\) # (\count|ad3|y~combout\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111111110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \count|ff4|Q~q\,
	datad => \count|ad3|y~combout\,
	combout => \count|ff4|Q~0_combout\);

-- Location: FF_X31_Y29_N25
\count|ff4|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \count|ff4|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \count|ff4|Q~q\);

-- Location: LCCOMB_X31_Y29_N18
\cont|rst\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|rst~combout\ = (\count|ff4|Q~q\) # (!\nGRst~input_o\)

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111111100001111",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datac => \nGRst~input_o\,
	datad => \count|ff4|Q~q\,
	combout => \cont|rst~combout\);

-- Location: FF_X30_Y29_N27
\count|ff0|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \count|ff0|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \count|ff0|Q~q\);

-- Location: LCCOMB_X30_Y29_N30
\cont|cMem|prog~2\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~2_combout\ = (\count|ff3|Q~q\ & (\count|ff2|Q~q\ $ (((\count|ff0|Q~q\ & \count|ff1|Q~q\)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0110000011000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \cont|cMem|prog~2_combout\);

-- Location: LCCOMB_X30_Y29_N22
\cont|cMem|prog~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~0_combout\ = (\count|ff3|Q~q\ & (\count|ff2|Q~q\ & (\count|ff0|Q~q\ $ (\count|ff1|Q~q\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0110000000000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff1|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff2|Q~q\,
	combout => \cont|cMem|prog~0_combout\);

-- Location: LCCOMB_X30_Y29_N14
\cont|cMem|prog~3\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~3_combout\ = (\count|ff3|Q~q\ & (!\count|ff2|Q~q\ & ((!\count|ff1|Q~q\) # (!\count|ff0|Q~q\)))) # (!\count|ff3|Q~q\ & (\count|ff0|Q~q\ $ (((\count|ff2|Q~q\ & \count|ff1|Q~q\)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0001011000111010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \cont|cMem|prog~3_combout\);

-- Location: LCCOMB_X31_Y29_N14
\flip2|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \flip2|Q~0_combout\ = \flip2|Q~q\ $ (((\m~input_o\ & \cont|cMem|prog~3_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011110011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \m~input_o\,
	datac => \flip2|Q~q\,
	datad => \cont|cMem|prog~3_combout\,
	combout => \flip2|Q~0_combout\);

-- Location: FF_X31_Y29_N15
\flip2|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \flip2|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \flip2|Q~q\);

-- Location: LCCOMB_X30_Y29_N12
\cont|cMem|prog~6\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~6_combout\ = (\count|ff2|Q~q\ & (!\count|ff3|Q~q\ & ((\count|ff0|Q~q\) # (!\count|ff1|Q~q\)))) # (!\count|ff2|Q~q\ & ((\count|ff1|Q~q\ & (!\count|ff0|Q~q\)) # (!\count|ff1|Q~q\ & ((\count|ff3|Q~q\)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0001100100111100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \cont|cMem|prog~6_combout\);

-- Location: LCCOMB_X31_Y29_N20
\flip3|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \flip3|Q~0_combout\ = \flip3|Q~q\ $ (((\m~input_o\ & \cont|cMem|prog~6_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0011110011110000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \m~input_o\,
	datac => \flip3|Q~q\,
	datad => \cont|cMem|prog~6_combout\,
	combout => \flip3|Q~0_combout\);

-- Location: FF_X31_Y29_N21
\flip3|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \flip3|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \flip3|Q~q\);

-- Location: LCCOMB_X30_Y29_N10
\cont|cMem|prog~5\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~5_combout\ = (\count|ff2|Q~q\ & (((\count|ff3|Q~q\) # (!\count|ff1|Q~q\)))) # (!\count|ff2|Q~q\ & (\count|ff0|Q~q\ & ((\count|ff3|Q~q\) # (\count|ff1|Q~q\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1110001011101100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \cont|cMem|prog~5_combout\);

-- Location: LCCOMB_X31_Y29_N30
\flip0|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \flip0|Q~0_combout\ = \flip0|Q~q\ $ (((\m~input_o\ & !\cont|cMem|prog~5_combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111000000111100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \m~input_o\,
	datac => \flip0|Q~q\,
	datad => \cont|cMem|prog~5_combout\,
	combout => \flip0|Q~0_combout\);

-- Location: FF_X31_Y29_N31
\flip0|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \flip0|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \flip0|Q~q\);

-- Location: LCCOMB_X30_Y29_N0
\cont|cMem|prog~4\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~4_combout\ = (\count|ff2|Q~q\ & ((\count|ff3|Q~q\) # ((\count|ff0|Q~q\ & !\count|ff1|Q~q\)))) # (!\count|ff2|Q~q\ & (\count|ff0|Q~q\ $ (\count|ff3|Q~q\ $ (\count|ff1|Q~q\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1110000111011010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff1|Q~q\,
	combout => \cont|cMem|prog~4_combout\);

-- Location: LCCOMB_X31_Y29_N28
\flip1|Q~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \flip1|Q~0_combout\ = \flip1|Q~q\ $ (((!\cont|cMem|prog~4_combout\ & \m~input_o\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1011010010110100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \cont|cMem|prog~4_combout\,
	datab => \m~input_o\,
	datac => \flip1|Q~q\,
	combout => \flip1|Q~0_combout\);

-- Location: FF_X31_Y29_N29
\flip1|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \flip1|Q~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \flip1|Q~q\);

-- Location: LCCOMB_X30_Y29_N28
\cont|cMem|prog~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \cont|cMem|prog~1_combout\ = (!\count|ff0|Q~q\ & (\count|ff2|Q~q\ & (\count|ff3|Q~q\ & !\count|ff4|Q~q\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "0000000001000000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \count|ff0|Q~q\,
	datab => \count|ff2|Q~q\,
	datac => \count|ff3|Q~q\,
	datad => \count|ff4|Q~q\,
	combout => \cont|cMem|prog~1_combout\);

-- Location: LCCOMB_X30_Y29_N6
\m4_1|orMux|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \m4_1|orMux|y~0_combout\ = (\cont|cMem|prog~0_combout\ & (((\cont|cMem|prog~1_combout\)))) # (!\cont|cMem|prog~0_combout\ & ((\cont|cMem|prog~1_combout\ & ((\flip1|Q~q\))) # (!\cont|cMem|prog~1_combout\ & (\flip0|Q~q\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111110000001010",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \flip0|Q~q\,
	datab => \flip1|Q~q\,
	datac => \cont|cMem|prog~0_combout\,
	datad => \cont|cMem|prog~1_combout\,
	combout => \m4_1|orMux|y~0_combout\);

-- Location: LCCOMB_X30_Y29_N16
\m4_1|orMux|y~1\ : cycloneiv_lcell_comb
-- Equation(s):
-- \m4_1|orMux|y~1_combout\ = (\cont|cMem|prog~0_combout\ & ((\m4_1|orMux|y~0_combout\ & ((\flip3|Q~q\))) # (!\m4_1|orMux|y~0_combout\ & (\flip2|Q~q\)))) # (!\cont|cMem|prog~0_combout\ & (((\m4_1|orMux|y~0_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111010110001000",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	dataa => \cont|cMem|prog~0_combout\,
	datab => \flip2|Q~q\,
	datac => \flip3|Q~q\,
	datad => \m4_1|orMux|y~0_combout\,
	combout => \m4_1|orMux|y~1_combout\);

-- Location: LCCOMB_X30_Y29_N4
\m2_1|orMux|y~0\ : cycloneiv_lcell_comb
-- Equation(s):
-- \m2_1|orMux|y~0_combout\ = (\cont|cMem|prog~2_combout\ & ((\m4_1|orMux|y~1_combout\))) # (!\cont|cMem|prog~2_combout\ & (\m~input_o\))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "1111110000001100",
	sum_lutc_input => "datac")
-- pragma translate_on
PORT MAP (
	datab => \m~input_o\,
	datac => \cont|cMem|prog~2_combout\,
	datad => \m4_1|orMux|y~1_combout\,
	combout => \m2_1|orMux|y~0_combout\);

-- Location: FF_X30_Y29_N5
\flip4|Q\ : dffeas
-- pragma translate_off
GENERIC MAP (
	is_wysiwyg => "true",
	power_up => "low")
-- pragma translate_on
PORT MAP (
	clk => \clk~inputclkctrl_outclk\,
	d => \m2_1|orMux|y~0_combout\,
	clrn => \cont|ALT_INV_rst~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	q => \flip4|Q~q\);

ww_x <= \x~output_o\;

ww_saida(0) <= \saida[0]~output_o\;

ww_saida(1) <= \saida[1]~output_o\;

ww_saida(2) <= \saida[2]~output_o\;

ww_saida(3) <= \saida[3]~output_o\;

ww_saida(4) <= \saida[4]~output_o\;
END structure;


