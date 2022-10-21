#include <iostream>
//contaners -> ve isto
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int main (){
    vector<int> v1; // ter de ter um espaco
    v1.push_back(10);
    v1.push_back(20);
    v1.push_back(15);

    for(int i=0;i<v1.size();i++)
        cout<< v1[i] << endl;
    
    sort(v1.begin(),v1.end()); //ordenar um vetor de objetos (funciona com tudo)

    for (auto i :v1)
        cout << "**" << i << endl;

    vector<int>::iterator it = v1.begin(); 
    //begin e o apontador para o 1 elemento e o end e o apontador para depois do ultimo
    // acrescentar no fim é por um elemento no end
    while(it!=v1.end()){
        cout << "***" << *it << endl; //*it -> aceder ao conteudo da variavel it
        it++; 
    }

    map<char, int> m; // importante para o projeto-> contar todas as letras num ficheiro e quantas vezes e que ocorrem
    m['a'] =5;
    m['b'] = 10;
    
    for (pair<char, int> i:m)
        cout << "map " << i.first << ";"<< i.second<<endl;



    // declaracoes de um array e percorre lo!!!!!!!!!!!!
    /*
    int a[] = new int[5];
    for (int i : a)
        cout <<i << endl;
    */
    return 0;
}

//2 programas
// ler 1 ficheiro de texto e contar o n de letras que tem la
// ler um fihciero para um array e depois ordenalo e escreve lo num fiheiro