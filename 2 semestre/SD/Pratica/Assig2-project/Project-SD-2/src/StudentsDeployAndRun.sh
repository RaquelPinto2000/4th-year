source config
echo "Transfering data to the Students node."
sshpass -f password ssh $student_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $student_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirStudents.zip $student_fname:test/TheRestaurant
echo "Decompressing data sent to the Students node."
sshpass -f password ssh $student_fname 'cd test/TheRestaurant ; unzip -uq dirStudents.zip'
sshpass -f password scp genclass.zip $student_fname:test/TheRestaurant/dirStudents
sshpass -f password ssh $student_fname 'cd test/TheRestaurant/dirStudents ; unzip -uq genclass.zip'
echo "Executing program at the Students node."
sshpass -f password ssh $student_fname "cd test/TheRestaurant/dirStudents ; java clientSide.main.ClientTheRestaurantStudent $table_name $bar_name $table_port $bar_port $generalRepos_name $generalRepos_port"
