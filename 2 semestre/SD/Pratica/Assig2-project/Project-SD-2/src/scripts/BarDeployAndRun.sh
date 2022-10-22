echo "Transfering data to the bar node."
sshpass -f password ssh sd201@l040101-ws07.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws07.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirBar.zip sd201@l040101-ws07.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the bar node."
sshpass -f password ssh sd201@l040101-ws07.ua.pt 'cd test/TheRestaurant ; unzip -uq dirBar.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws07.ua.pt:test/TheRestaurant/dirBar
sshpass -f password ssh sd201@l040101-ws07.ua.pt 'cd test/TheRestaurant/dirBar ; unzip -uq genclass.zip'
echo "Executing program at the bar node."
sshpass -f password ssh sd201@l040101-ws07.ua.pt 'cd test/TheRestaurant/dirBar ; java serverSide.main.ServerBar 22307 l040101-ws01.ua.pt 22302'
