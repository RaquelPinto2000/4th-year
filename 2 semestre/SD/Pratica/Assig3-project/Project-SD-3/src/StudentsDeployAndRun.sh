source config
echo "Transfering data to the Students node."
sshpass -f password ssh $student_fname 'mkdir -p test/TheRestaurant'
sshpass -f password ssh $student_fname 'rm -rf test/TheRestaurant/*'
sshpass -f password scp dirStudents.zip $student_fname:test/TheRestaurant
echo "Decompressing data sent to the Students node."
sshpass -f password ssh $student_fname 'cd test/TheRestaurant ; unzip -uq dirStudents.zip'
sshpass -f password scp genclass.zip $student_fname:test/TheRestaurant/dirStudents
sshpass -f password ssh $student_fname 'cd test/TheRestaurant/dirStudents ; unzip -uq genclass.zip'
sshpass -f password scp config $student_fname:test/TheRestaurant/dirStudents
echo "Executing program at the Students node."
sshpass -f password ssh $student_fname "cd test/TheRestaurant/dirStudents ; ./students_com_d.sh"
