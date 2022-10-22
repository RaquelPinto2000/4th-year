source config
xterm  -T "RMI registry" -hold -e "source config & ./RMIRegistryDeployAndRun.sh" &
sleep 10
xterm  -T "Registry" -hold -e "source config & ./RegistryDeployAndRun.sh" &
sleep 4
xterm  -T "General Repository" -hold -e "source config & ./GeneralReposDeployAndRun.sh" &
sleep 2
xterm  -T "Bar" -hold -e "source config & ./BarDeployAndRun.sh" &
sleep 2
xterm  -T "Table" -hold -e "source config & ./TableDeployAndRun.sh" &
sleep 2
xterm  -T "Kitchen" -hold -e "source config & ./KitchenDeployAndRun.sh" &
sleep 5
xterm  -T "Waiter" -hold -e "source config & ./WaiterDeployAndRun.sh" &
xterm  -T "Chef" -hold -e "source config & ./ChefDeployAndRun.sh" &
xterm  -T "Students" -hold -e "source config & ./StudentsDeployAndRun.sh" &
