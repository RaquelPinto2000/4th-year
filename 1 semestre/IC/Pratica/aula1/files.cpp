#include <iostream>
#include <fstream>

using namespace std; // biblioteca do cout (se nao std::cout)

int main(){
    ifstream ifs( "nums.txt"); //criar um ficheiro com esse nom -> ler de um ficheiro
    ofstream ofs( "out.txt"); // escrever num ficheiro, ele cria o ficheiro out e depois escreve
    
    int x;
    while(ifs.good()){ // isto so falha na ultima linha,
    //ele tenta ler o 4 elemento mas ele nao existe por isso ele duplica o ultimo elemento 
    //(isto acontece se tiver algum espaco no final do ficheiro)
        ifs>>x;
        ofs<<x<<endl; // mete uma linha no final do ficheiro
    }
    
    ofs.close(); // fechar sempre o ficheiro de escrita
    return 0;
}
