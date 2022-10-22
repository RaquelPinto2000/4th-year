source config
echo "Transfering data to the registry node."
sshpass -f password ssh $rmi_fname 'mkdir -p test/TheRestaurant'
sshpass -f password scp dirRegistry.zip $rmi_fname:test/TheRestaurant
echo "Decompressing data sent to the registry node."
sshpass -f password ssh $rmi_fname 'cd test/TheRestaurant ; unzip -uq dirRegistry.zip'
sshpass -f password scp config $rmi_fname:test/TheRestaurant/dirRegistry/config
echo "Executing program at the registry node."
sshpass -f password ssh $rmi_fname 'cd test/TheRestaurant/dirRegistry ; ./registry_com_d.sh sd201'

