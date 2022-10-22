source config
echo "Transfering data to the chef node."
sshpass -f password ssh $chef_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $chef_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirChef.zip $chef_fname:test/TheRestaurant
echo "Decompressing data sent to the chef node."
sshpass -f password ssh $chef_fname 'cd test/TheRestaurant ; unzip -uq dirChef.zip'
sshpass -f password scp genclass.zip $chef_fname:test/TheRestaurant/dirChef
sshpass -f password ssh $chef_fname 'cd test/TheRestaurant/dirChef ; unzip -uq genclass.zip'
echo "Executing program at the chef node."
sshpass -f password ssh $chef_fname "cd test/TheRestaurant/dirChef ; java clientSide.main.ClientTheRestaurantChef $kitchen_name $bar_name $kitchen_port $bar_port $generalRepos_name $generalRepos_port"
