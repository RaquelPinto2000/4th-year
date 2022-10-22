#include "golomb.h"
#include <string>

using namespace std;

int main(int argc, char* argv[])
{
    if(argc != 3)
    {
        cout << "./golomb_output <M> <max_n>" << endl;
        return 0;
    }
    
    int n;
    int max_n = atoi(argv[2]);
    int m = atoi(argv[1]);
    int i,j;
    char*code;
    golomb g(m);
    int out =0;
    
    for(n=-max_n ; n<=max_n ; n++){
        cout << "encode val -> " << n << endl;
        code = g.signed_encode(n);
        for(j=0 ; j< floor((g.get_unarySize()+g.get_remSize()+1)/8)+1 ; j++)
        {
            for(i=0 ; i<8 ; i++){
                if(i+8*j < g.get_unarySize()+g.get_remSize()+1) {
                    cout<< ((code[j]>>(i)) &0x01);
                }
            }
        }   
        cout<< endl;
        cout << endl;
        out = g.signed_decode(code,g.get_remSize(),g.get_unarySize());
        cout << "decode val: "<< out <<endl;
    }
    
   
    string file = "golomb_file.bin";
    int test[] = {17629184,6,15,70,60,50,0,-10,-20,-7,0,0,0,5,6,6,8,6,3,10,0,0,-10,-100,100,200,500,10,50,60,70,-100,-800,1000,100000,-100000,1000000,200000,500000,-100000,-1095958528,17629184,-118685696};
    m = 40;
    
    golomb golomb_encoder(m,(char*)file.data());
    for(int i=0 ; i<43 ; i++){
        golomb_encoder.signed_stream_encode(test[i]);
    }
    
    golomb_encoder.close_stream_write();
    
    golomb golomb_decoder(m,(char*)file.data());
    for(int i=0 ; i<43 ; i++){
        cout << endl;
        cout << "I: " << i << endl;
        out = golomb_decoder.signed_stream_decode();
        cout << "decode: "<< out << endl;
    }
    golomb_decoder.close_stream_read();

    return 0;
}