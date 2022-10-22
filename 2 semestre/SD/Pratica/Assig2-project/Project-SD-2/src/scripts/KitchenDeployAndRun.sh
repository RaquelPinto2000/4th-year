echo "Transfering data to the kitchen node."
sshpass -f password ssh sd201@l040101-ws02.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws02.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirKitchen.zip sd201@l040101-ws02.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the kitchen node."
sshpass -f password ssh sd201@l040101-ws02.ua.pt 'cd test/TheRestaurant ; unzip -uq dirKitchen.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws02.ua.pt:test/TheRestaurant/dirKitchen
sshpass -f password ssh sd201@l040101-ws02.ua.pt 'cd test/TheRestaurant/dirKitchen ; unzip -uq genclass.zip'
echo "Executing program at the kitchen node."
sshpass -f password ssh sd201@l040101-ws02.ua.pt 'cd test/TheRestaurant/dirKitchen ; java serverSide.main.ServerKitchen 22303 l040101-ws01.ua.pt 22302'
