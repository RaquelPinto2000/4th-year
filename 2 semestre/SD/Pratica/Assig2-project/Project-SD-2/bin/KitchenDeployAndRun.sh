source config
echo "Transfering data to the kitchen node."
sshpass -f password ssh $kitchen_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $kitchen_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirKitchen.zip $kitchen_fname:test/TheRestaurant
echo "Decompressing data sent to the kitchen node."
sshpass -f password ssh $kitchen_fname 'cd test/TheRestaurant ; unzip -uq dirKitchen.zip'
sshpass -f password scp genclass.zip $kitchen_fname:test/TheRestaurant/dirKitchen
sshpass -f password ssh $kitchen_fname 'cd test/TheRestaurant/dirKitchen ; unzip -uq genclass.zip'
echo "Executing program at the kitchen node."
sshpass -f password ssh $kitchen_fname "cd test/TheRestaurant/dirKitchen ; java serverSide.main.ServerKitchen $kitchen_port $generalRepos_name $generalRepos_port"
