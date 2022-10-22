echo "Transfering data to the waiter node."
sshpass -f password ssh sd201@l040101-ws04.ua.pt 'mkdir -p test/TheRestaurant'
sshpass -f password ssh sd201@l040101-ws04.ua.pt 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirWaiter.zip sd201@l040101-ws04.ua.pt:test/TheRestaurant
echo "Decompressing data sent to the waiter node."
sshpass -f password ssh sd201@l040101-ws04.ua.pt 'cd test/TheRestaurant ; unzip -uq dirWaiter.zip'
sshpass -f password scp genclass.zip sd201@l040101-ws04.ua.pt:test/TheRestaurant/dirWaiter
sshpass -f password ssh sd201@l040101-ws04.ua.pt 'cd test/TheRestaurant/dirWaiter ; unzip -uq genclass.zip'
echo "Executing program at the waiter node."
sshpass -f password ssh sd201@l040101-ws04.ua.pt 'cd test/TheRestaurant/dirWaiter ; java clientSide.main.ClientTheRestaurantWaiter l040101-ws06.ua.pt l040101-ws07.ua.pt l040101-ws02.ua.pt 22300 22307 22303 l040101-ws01.ua.pt 22302'
