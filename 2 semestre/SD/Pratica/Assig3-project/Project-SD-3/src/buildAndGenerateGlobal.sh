rm -rf */*.class */*/*.class
rm -rf *.zip
echo "Compiling source code."
javac -cp ".:./genclass.jar" */*.java */*/*.java
echo "Distributing intermediate code to the different execution environments."
echo "  RMI registry"
rm -rf dirRMIRegistry/interfaces
mkdir -p dirRMIRegistry/interfaces
cp interfaces/*.class dirRMIRegistry/interfaces
echo "  Register Remote Objects"
rm -rf dirRegistry/serverSide dirRegistry/interfaces
mkdir -p dirRegistry/serverSide dirRegistry/serverSide/main dirRegistry/serverSide/objects dirRegistry/interfaces
cp serverSide/main/ServerRegisterRemoteObject.class dirRegistry/serverSide/main
cp serverSide/objects/RegisterRemoteObject.class dirRegistry/serverSide/objects
cp interfaces/Register.class dirRegistry/interfaces
echo "  General Repository of Information"
rm -rf dirGeneralRepos/serverSide dirGeneralRepos/clientSide dirGeneralRepos/interfaces
mkdir -p dirGeneralRepos/serverSide dirGeneralRepos/serverSide/main dirGeneralRepos/serverSide/objects dirGeneralRepos/interfaces \
         dirGeneralRepos/clientSide dirGeneralRepos/clientSide/entities
cp serverSide/main/SimulPar.class serverSide/main/ServerGeneralRepos.class dirGeneralRepos/serverSide/main
cp serverSide/objects/GeneralRepos.class dirGeneralRepos/serverSide/objects
cp interfaces/Register.class interfaces/GeneralReposInterface.class dirGeneralRepos/interfaces
cp clientSide/entities/StudentStates.class clientSide/entities/WaiterStates.class clientSide/entities/ChefStates.class dirGeneralRepos/clientSide/entities
echo "  Table"
rm -rf dirTable/serverSide dirTable/clientSide dirTable/interfaces dirTable/commInfra
mkdir -p dirTable dirTable/serverSide dirTable/serverSide/main dirTable/serverSide/objects dirTable/interfaces \
         dirTable/clientSide dirTable/clientSide/entities dirTable/commInfra
cp serverSide/main/SimulPar.class serverSide/main/ServerTable.class dirTable/serverSide/main
cp serverSide/objects/Table.class dirTable/serverSide/objects
cp interfaces/*.class dirTable/interfaces
cp clientSide/entities/StudentStates.class clientSide/entities/Student.class clientSide/entities/WaiterStates.class clientSide/entities/ChefStates.class \
   dirTable/clientSide/entities
cp commInfra/*.class dirTable/commInfra
echo "  Bar"
rm -rf dirBar/serverSide dirBar/clientSide dirBar/interfaces dirBar/commInfra
mkdir -p dirBar dirBar/serverSide dirBar/serverSide/main dirBar/serverSide/objects dirBar/interfaces \
         dirBar/clientSide dirBar/clientSide/entities dirBar/commInfra
cp serverSide/main/SimulPar.class serverSide/main/ServerBar.class dirBar/serverSide/main
cp serverSide/objects/Bar.class dirBar/serverSide/objects
cp interfaces/*.class dirBar/interfaces
cp clientSide/entities/StudentStates.class clientSide/entities/WaiterStates.class clientSide/entities/ChefStates.class \
   dirBar/clientSide/entities
cp commInfra/*.class dirBar/commInfra
echo "  Kitchen"
rm -rf dirKitchen/serverSide dirKitchen/clientSide dirKitchen/interfaces dirKitchen/commInfra
mkdir -p dirKitchen dirKitchen/serverSide dirKitchen/serverSide/main dirKitchen/serverSide/objects dirKitchen/interfaces \
         dirKitchen/clientSide dirKitchen/clientSide/entities dirKitchen/commInfra
cp serverSide/main/SimulPar.class serverSide/main/ServerKitchen.class dirKitchen/serverSide/main
cp serverSide/objects/Kitchen.class dirKitchen/serverSide/objects
cp interfaces/*.class dirKitchen/interfaces
cp clientSide/entities/StudentStates.class clientSide/entities/WaiterStates.class clientSide/entities/Chef.class clientSide/entities/ChefStates.class \
   dirKitchen/clientSide/entities
cp commInfra/*.class dirKitchen/commInfra
echo "  Students"
rm -rf dirStudents/serverSide dirStudents/clientSide dirStudents/interfaces
mkdir -p dirStudents/serverSide dirStudents/serverSide/main dirStudents/clientSide dirStudents/clientSide/main dirStudents/clientSide/entities \
         dirStudents/interfaces
cp serverSide/main/SimulPar.class dirStudents/serverSide/main
cp clientSide/main/ClientTheRestaurantStudent.class dirStudents/clientSide/main
cp clientSide/entities/Student.class clientSide/entities/StudentStates.class dirStudents/clientSide/entities
cp interfaces/TableInterface.class interfaces/BarInterface.class interfaces/GeneralReposInterface.class interfaces/ReturnInt.class dirStudents/interfaces
echo "  Waiter"
rm -rf dirWaiter/serverSide dirWaiter/clientSide dirWaiter/interfaces
mkdir -p dirWaiter/serverSide dirWaiter/serverSide/main dirWaiter/clientSide dirWaiter/clientSide/main dirWaiter/clientSide/entities \
         dirWaiter/interfaces
cp serverSide/main/SimulPar.class dirWaiter/serverSide/main
cp clientSide/main/ClientTheRestaurantWaiter.class dirWaiter/clientSide/main
cp clientSide/entities/Waiter.class clientSide/entities/WaiterStates.class dirWaiter/clientSide/entities
cp interfaces/TableInterface.class interfaces/BarInterface.class interfaces/KitchenInterface.class interfaces/GeneralReposInterface.class interfaces/ReturnInt.class dirWaiter/interfaces
echo "  Chef"
rm -rf dirChef/serverSide dirChef/clientSide dirChef/interfaces
mkdir -p dirChef dirChef/serverSide dirChef/serverSide/main dirChef/clientSide dirChef/clientSide/main dirChef/clientSide/entities \
         dirChef/interfaces
cp serverSide/main/SimulPar.class dirChef/serverSide/main
cp clientSide/main/ClientTheRestaurantChef.class dirChef/clientSide/main
cp clientSide/entities/Chef.class clientSide/entities/ChefStates.class dirChef/clientSide/entities
cp interfaces/BarInterface.class interfaces/KitchenInterface.class interfaces/GeneralReposInterface.class dirChef/interfaces
echo "Compressing execution environments."
echo "  RMI registry"
rm -f  dirRMIRegistry.zip
zip -rq dirRMIRegistry.zip dirRMIRegistry
echo "  Register Remote Objects"
rm -f  dirRegistry.zip
zip -rq dirRegistry.zip dirRegistry
echo "  General Repository of Information"
rm -f  dirGeneralRepos.zip
zip -rq dirGeneralRepos.zip dirGeneralRepos
echo "  Table"
rm -f  dirTable.zip
zip -rq dirTable.zip dirTable
echo "  Bar"
rm -f  dirBar.zip
zip -rq dirBar.zip dirBar
echo "  Kitchen"
rm -f  dirKitchen.zip
zip -rq dirKitchen.zip dirKitchen
echo "  Student"
rm -f  dirStudents.zip
zip -rq dirStudents.zip dirStudents
echo "  Waiter"
rm -f  dirWaiter.zip
zip -rq dirWaiter.zip dirWaiter
echo "  Chef"
rm -f  dirChef.zip
zip -rq dirChef.zip dirChef
echo "  Genclass"
rm -f  genclass.zip
zip -rq genclass.zip genclass
