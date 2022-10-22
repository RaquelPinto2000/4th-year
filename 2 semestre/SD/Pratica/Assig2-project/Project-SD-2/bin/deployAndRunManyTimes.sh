for i in $(seq 1 10000)
do
    echo -e "\nRun n.o " $i
    xterm  -T "General Repository" -e "./GeneralReposDeployAndRun.sh" &
    xterm  -T "Table" -e "./TableDeployAndRun.sh" &
    xterm  -T "Bar" -e "./BarDeployAndRun.sh" &
    xterm  -T "Kitchen" -e "./KitchenDeployAndRun.sh" &
    sleep 1
    xterm  -T "Students" -e "./StudentsDeployAndRun.sh" &
    xterm  -T "Waiter" -e "./WaiterDeployAndRun.sh" &
    xterm  -T "Chef" -e "./ChefDeployAndRun.sh" 

    sleep 2
done
