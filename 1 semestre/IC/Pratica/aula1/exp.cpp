#include <iostream>
using namespace std; // biblioteca do cout (se nao std::cout)

// correr g++ nome -o nome do fichiero de saida
// correr o nome do fichiero de saida
void func(int x){}
void funt(double x){}
void f(int x){}
void f(double x){}

int main(){
    string s;
    cout << "texto? ";
    
    cin >> s;
    cout << s << endl; //mudanca de linha endl -> fica dinamico e de acordo com o sistema operativo

    f(10);
    f(5);

    func(static_cast<char>(64));
    func('x');
    func(1000);
    func(5.5);

    int k = 64;

    cout <<k << " depois do cast " << static_cast<char>(k) <<endl;

    return 0;

}

