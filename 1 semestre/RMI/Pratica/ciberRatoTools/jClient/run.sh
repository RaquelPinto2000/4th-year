#!/bin/bash

challenge="4"
host="localhost"
robname="theAgent"
pos="0"
outfile="solution"

while getopts "c:h:r:p:f:" op
do
    case $op in
        "c")
            challenge=$OPTARG
            ;;
        "h")
            host=$OPTARG
            ;;
        "r")
            robname=$OPTARG
            ;;
        "p")
            pos=$OPTARG
            ;;
        "f")
            outfile=$OPTARG
            ;;
        default)
            echo "ERROR in parameters"
            ;;
    esac
done

shift $(($OPTIND-1))

case $challenge in
    4)
        # how to call agent for challenge 4
        java jClientC4  --host "$host" --pos "$pos" --robname "$robname" -f "$outfile" # assuming -f is the option for the map
        mv mapa.txt $outfile.map
        mv caminho.txt $outfile.path
        ;;
        # how to call agent for challenge 4
        #java mainC4 -h "$host" -p "$pos" -r "$robname" 
        #mv your_mapfile $outfile.map
        #mv your_pathfile $outfile.path
        #;;

esac



