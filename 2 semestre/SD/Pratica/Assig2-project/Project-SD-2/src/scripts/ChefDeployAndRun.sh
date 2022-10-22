echo "Transfering data to the chef node."
sshpass -f password ssh sd201@l040101-ws05.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws05.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirChef.zip sd201@l040101-ws05.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the chef node."
sshpass -f password ssh sd201@l040101-ws05.ua.pt 'cd test/TheRestaurant ; unzip -uq dirChef.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws05.ua.pt:test/TheRestaurant/dirChef
sshpass -f password ssh sd201@l040101-ws05.ua.pt 'cd test/TheRestaurant/dirChef ; unzip -uq genclass.zip'
echo "Executing program at the chef node."
sshpass -f password ssh sd201@l040101-ws05.ua.pt 'cd test/TheRestaurant/dirChef ; java clientSide.main.ClientTheRestaurantChef l040101-ws02.ua.pt l040101-ws07.ua.pt 22303 22307 l040101-ws01.ua.pt 22302'
