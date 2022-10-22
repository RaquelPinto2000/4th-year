xterm  -T "General Repository" -hold -e "./GeneralReposDeployAndRun.sh" &
xterm  -T "Table" -hold -e "./TableDeployAndRun.sh" &
xterm  -T "Bar" -hold -e "./BarDeployAndRun.sh" &
xterm  -T "Kitchen" -hold -e "./KitchenDeployAndRun.sh" &
sleep 1
xterm  -T "Students" -hold -e "./StudentsDeployAndRun.sh" &
xterm  -T "Waiter" -hold -e "./WaiterDeployAndRun.sh" &
xterm  -T "Chef" -hold -e "./ChefDeployAndRun.sh" &
