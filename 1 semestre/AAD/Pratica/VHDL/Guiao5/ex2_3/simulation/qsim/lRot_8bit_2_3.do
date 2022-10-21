onerror {exit -code 1}
vlib work
vcom -work work lRot_8bit_2_3.vho
vcom -work work lRot_8bit_2_3.vwf.vht
vsim -novopt -c -t 1ps -L cycloneiv -L altera -L altera_mf -L 220model -L sgate -L altera_lnsim work.lRot_8bit_2_3_vhd_vec_tst
vcd file -direction lRot_8bit_2_3.msim.vcd
vcd add -internal lRot_8bit_2_3_vhd_vec_tst/*
vcd add -internal lRot_8bit_2_3_vhd_vec_tst/i1/*
proc simTimestamp {} {
    echo "Simulation time: $::now ps"
    if { [string equal running [runStatus]] } {
        after 2500 simTimestamp
    }
}
after 2500 simTimestamp
run -all
quit -f
