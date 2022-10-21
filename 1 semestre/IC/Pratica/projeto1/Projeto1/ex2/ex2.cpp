#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main(int argc,char **argv){
    char x; // le linha a linha -> getline()

    if(argc != 3){
        cout << "Error: Should write <input filename> <output filename>" << endl;
        return 0; 
    }
   // string inputfile = argv[1];
    //string outputfile = argv[2];

    // podemos usar o get(x) le tudo de caracter a caracter influindo o /n
    for(int cont=0; cont < argc; cont++){
        printf("%d Parametro: %s\n", cont,argv[cont]);
    }
    //0 argumento -> ./a.out
    //1 argumento -> ficheiro para ler
    //2 argumento -> ficheiro para escrever
    
    ifstream ifs(argv[1]); //ler de um ficheiro
    ofstream ofs(argv[2]); //escrever de um ficheiro

    //while(getline(ifs,x)){ // da nos uma linha, le do ficheiro e da entao nao e preciso  //ifs>>x;
    while(ifs.get(x)){
        //ifs>>x;
        ofs<<x;
    }

    ofs.close();
    return 0;
}
