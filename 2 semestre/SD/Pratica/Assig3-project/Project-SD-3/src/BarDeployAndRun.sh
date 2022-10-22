source config
echo "Transfering data to the bar node."
sshpass -f password ssh $bar_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $bar_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirBar.zip $bar_fname:test/TheRestaurant
echo "Decompressing data sent to the bar node."
sshpass -f password ssh $bar_fname 'cd test/TheRestaurant ; unzip -uq dirBar.zip'
sshpass -f password scp genclass.zip $bar_fname:test/TheRestaurant/dirBar
sshpass -f password ssh $bar_fname 'cd test/TheRestaurant/dirBar ; unzip -uq genclass.zip'
sshpass -f password scp config $bar_fname:test/TheRestaurant/dirBar
echo "Executing program at the bar node."
sshpass -f password ssh $bar_fname "cd test/TheRestaurant/dirBar ; ./bar_com_d.sh sd201"
