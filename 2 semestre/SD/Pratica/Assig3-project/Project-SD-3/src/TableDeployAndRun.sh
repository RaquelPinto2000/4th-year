source config
echo "Transfering data to the table node."
sshpass -f password ssh $table_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $table_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirTable.zip $table_fname:test/TheRestaurant
echo "Decompressing data sent to the table node."
sshpass -f password ssh $table_fname 'cd test/TheRestaurant ; unzip -uq dirTable.zip'
sshpass -f password scp genclass.zip $table_fname:test/TheRestaurant/dirTable
sshpass -f password ssh $table_fname 'cd test/TheRestaurant/dirTable ; unzip -uq genclass.zip'
sshpass -f password scp config $table_fname:test/TheRestaurant/dirTable
echo "Executing program at the table node."
sshpass -f password ssh $table_fname "cd test/TheRestaurant/dirTable ; ./table_com_d.sh sd201"
