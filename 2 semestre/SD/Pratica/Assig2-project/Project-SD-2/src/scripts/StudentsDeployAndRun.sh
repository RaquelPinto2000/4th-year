echo "Transfering data to the Students node."
sshpass -f password ssh sd201@l040101-ws03.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws03.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirStudents.zip sd201@l040101-ws03.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the Students node."
sshpass -f password ssh sd201@l040101-ws03.ua.pt 'cd test/TheRestaurant ; unzip -uq dirStudents.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws03.ua.pt:test/TheRestaurant/dirStudents
sshpass -f password ssh sd201@l040101-ws03.ua.pt 'cd test/TheRestaurant/dirStudents ; unzip -uq genclass.zip'
echo "Executing program at the Students node."
sshpass -f password ssh sd201@l040101-ws03.ua.pt 'cd test/TheRestaurant/dirStudents ; java clientSide.main.ClientTheRestaurantStudent l040101-ws06.ua.pt l040101-ws07.ua.pt 22300 22307 l040101-ws01.ua.pt 22302'
