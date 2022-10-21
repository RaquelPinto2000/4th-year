//g++ ex3.cpp -o ex3 -lsndfile

#include <iostream>
#include <string>
#include <fstream>
#include <sndfile.h>

using namespace std;

int main(int argc, char** argv){

    string filename;

    cout << "input filename: ";
    cin >> filename;

    const char* path = "/home/raquel/Desktop/IC/Pratica/Projeto1/ex3/Wav files-20211025/";
    //const char* path = "../../Wav files-20211025/";
    filename = path + filename;
    path = filename.c_str();

    printf("caminho= %s\n",path);
    //printf("\n");

    SF_INFO sfinfo;
    SNDFILE* snd_file;

    FILE *out;

    sfinfo.format = 0;
    snd_file = sf_open(path,SFM_READ,&sfinfo);

    if(snd_file == NULL)
    {
        printf("Failed to open the file\n");
    }    

    int num_channels, num, num_items, *buf, f, sr,c, i , j;

    f = sfinfo.frames;
    sr = sfinfo.samplerate;
    c = sfinfo.channels;

    num_items = f*c;

    printf("frames=%d\n",f);
    printf("samplerate=%d\n",sr);
    printf("channels=%d\n",c);

    buf = (int *) malloc(num_items*sizeof(int));
    num = sf_read_int(snd_file,buf,num_items);
    
    sf_close(snd_file);
    printf("Read %d items\n",num);

    /* Write the data to filedata.out. */
    out = fopen("/home/raquel/Desktop/IC/Pratica/Projeto1/ex3/wave_copy.txt","w");
    for (i = 0; i < num; i += c)
    {
        for (j = 0; j < c; ++j)
            fprintf(out,"%d ",buf[i+j]);
        fprintf(out,"\n");
    }

    fclose(out);
    return 0;
}