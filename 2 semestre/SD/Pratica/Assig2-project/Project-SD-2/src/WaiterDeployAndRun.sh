source config
echo "Transfering data to the waiter node."
sshpass -f password ssh $waiter_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $waiter_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirWaiter.zip $waiter_fname:test/TheRestaurant
echo "Decompressing data sent to the waiter node."
sshpass -f password ssh $waiter_fname 'cd test/TheRestaurant ; unzip -uq dirWaiter.zip'
sshpass -f password scp genclass.zip $waiter_fname:test/TheRestaurant/dirWaiter
sshpass -f password ssh $waiter_fname 'cd test/TheRestaurant/dirWaiter ; unzip -uq genclass.zip'
echo "Executing program at the waiter node."
sshpass -f password ssh $waiter_fname "cd test/TheRestaurant/dirWaiter ; java clientSide.main.ClientTheRestaurantWaiter $table_name $bar_name $kitchen_name $table_port $bar_port $kitchen_port $generalRepos_name $generalRepos_port"
