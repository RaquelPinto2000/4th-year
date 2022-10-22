#include "bit_stream.h"
using namespace std;
/*
*   bit stream to read/write bits from/to file
*   methods -> write,read one bit
*   write/read nbits
*   writes to bin file
*   read/write strings in binary
*   
*
*/
    bool bit_stream::end_of_file()
    {   
        return inputfile.peek()==EOF;
    }

    void bit_stream::open_file_write()
    {
        outputfile.open(filename);
    }

    void bit_stream::close_file_write()
    {
        outputfile.close();
    }

    void bit_stream::open_file_read()
    {
        inputfile.open(filename);

    }

    void bit_stream::close_file_read()
    {
        inputfile.close();
    }
    
    // usado para escrever os bits restantes antes de fechar o ficheiro
    // apenas escreve se tiver informação no byte
    void bit_stream::write_byte()
    {
        if(pointer_write < 7){
            outputfile.write((char*)&wbyte,1);
            pointer_write = 0;
        }
        outputfile.close();
    }

    void bit_stream::writeBit(uint8_t val)
    {
        wbyte |= (val & 0x01) << pointer_write;
        if (pointer_write > 0) {
            pointer_write--;                    
            return;       
        }           
        outputfile.write((char*)&wbyte,1);
        pointer_write = 7;
        wbyte = 0;
    }
    
    void bit_stream::writeBits(int val, uint n)
    {   
        char bit;
        for(int i=n-1 ; i>=0 ; i--)
        {  
            bit = (val >> i%64) & 0x01;
            writeBit(bit);
        }
    }

    void bit_stream::writeBits(char* val, uint n)
    {   
        int i;
        for(int j=(int)(n/8) ; j>=0 ; j--)
        {
            for(i=7; i>=0; i--)
                if(8*j+i<n)    
                    writeBit((val[j] >> i) & 0x01);
        }
    }
    
    uint8_t bit_stream::readBit()
    {
        uint8_t val_byte=0;
        if (pointer_read < 0) {
            inputfile.read((char*)&rbyte, 1); 
            pointer_read = 7;
        }
        val_byte = ((rbyte >> pointer_read) & 0x01); 
        pointer_read--;
        return val_byte;
    }

    void bit_stream::readBit(uint8_t* val)
    {
        if(pointer_read < 0)
        {
            inputfile.read((char*)&rbyte,1);
            pointer_read = 7;
        }
        *val = ((rbyte >> pointer_read) & 0x01);
        pointer_read --;
    }
    
    char* bit_stream::readBits(uint n)
    {
        int i,j;
        char* bits = (char*)malloc((uint)(n/8) + 1);
        for(j=n/8; j>=0; j--){
            bits[j] = 0x00;
            for (i=7; i>=0; i--) {
                if(i+8*j < n){
                    bits[j] |= (readBit()<<i); 
                }
            }
        }
        return bits;
    }

    void bit_stream::readBits(char* bits, uint n)
    {
        int i,j;
        for(j=n/8; j>=0; j--){
            bits[j] = 0x00;
            for (i=7; i>=0; i--) {
                if(i+8*j < n){
                    bits[j] |= (readBit()<<i); 
                }
            }
        }
    }