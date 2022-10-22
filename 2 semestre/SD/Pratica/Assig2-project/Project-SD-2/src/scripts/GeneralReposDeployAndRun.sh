echo "Transfering data to the general repository node."
sshpass -f password ssh sd201@l040101-ws01.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws01.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirGeneralRepos.zip sd201@l040101-ws01.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the general repository node."
sshpass -f password ssh sd201@l040101-ws01.ua.pt 'cd test/TheRestaurant ; unzip -uq dirGeneralRepos.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws01.ua.pt:test/TheRestaurant/dirGeneralRepos
sshpass -f password ssh sd201@l040101-ws01.ua.pt 'cd test/TheRestaurant/dirGeneralRepos ; unzip -uq genclass.zip'
echo "Executing program at the server general repository."
sshpass -f password ssh sd201@l040101-ws01.ua.pt 'cd test/TheRestaurant/dirGeneralRepos ; java serverSide.main.ServerGeneralRepos 22302'
echo "Server shutdown."
sshpass -f password ssh sd201@l040101-ws01.ua.pt 'cd test/TheRestaurant/dirGeneralRepos ; less logger'
