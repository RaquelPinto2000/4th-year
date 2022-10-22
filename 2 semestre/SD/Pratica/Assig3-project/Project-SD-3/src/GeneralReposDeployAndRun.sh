source config
echo "Transfering data to the general repository node."
sshpass -f password ssh $generalRepos_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $generalRepos_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirGeneralRepos.zip $generalRepos_fname:test/TheRestaurant
echo "Decompressing data sent to the general repository node."
sshpass -f password ssh $generalRepos_fname 'cd test/TheRestaurant ; unzip -uq dirGeneralRepos.zip'
sshpass -f password scp genclass.zip $generalRepos_fname:test/TheRestaurant/dirGeneralRepos
sshpass -f password ssh $generalRepos_fname 'cd test/TheRestaurant/dirGeneralRepos ; unzip -uq genclass.zip'
sshpass -f password scp config $generalRepos_fname:test/TheRestaurant/dirGeneralRepos
echo "Executing program at the server general repository."
sshpass -f password ssh $generalRepos_fname "cd test/TheRestaurant/dirGeneralRepos ; ./repos_com_d.sh sd201"
echo "Server shutdown."
sshpass -f password ssh $generalRepos_fname 'cd test/TheRestaurant/dirGeneralRepos ; less logger'
