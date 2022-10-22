echo "Transfering data to the table node."
sshpass -f password ssh sd201@l040101-ws06.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws06.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirTable.zip sd201@l040101-ws06.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the table node."
sshpass -f password ssh sd201@l040101-ws06.ua.pt 'cd test/TheRestaurant ; unzip -uq dirTable.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws06.ua.pt:test/TheRestaurant/dirTable
sshpass -f password ssh sd201@l040101-ws06.ua.pt 'cd test/TheRestaurant/dirTable ; unzip -uq genclass.zip'
echo "Executing program at the table node."
sshpass -f password ssh sd201@l040101-ws06.ua.pt 'cd test/TheRestaurant/dirTable ; java serverSide.main.ServerTable 22300 l040101-ws01.ua.pt 22302'
