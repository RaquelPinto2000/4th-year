source config
xterm  -T "General Repository" -hold -e "source config & ./GeneralReposDeployAndRun.sh" &
xterm  -T "Table" -hold -e "source config & ./TableDeployAndRun.sh" &
xterm  -T "Bar" -hold -e "source config & ./BarDeployAndRun.sh" &
xterm  -T "Kitchen" -hold -e "source config & ./KitchenDeployAndRun.sh" &
sleep 1
xterm  -T "Students" -hold -e "source config & ./StudentsDeployAndRun.sh" &
xterm  -T "Waiter" -hold -e "source config & ./WaiterDeployAndRun.sh" &
xterm  -T "Chef" -hold -e "source config & ./ChefDeployAndRun.sh" &
