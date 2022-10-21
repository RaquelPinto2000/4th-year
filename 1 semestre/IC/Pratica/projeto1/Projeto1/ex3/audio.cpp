#include <iostream>
#include <cstdio>
#include <cstring>
#define		BUFFER_LEN		1024
#include <sndfile.hh>
using namespace std;

int main(){
    static short buffer [BUFFER_LEN] ;
    string r;
    string w;
    char x; 
    SndfileHandle file;
    SndfileHandle file1;
    int channels = 2 ;
	int srate = 48000 ;



    cout << "Name of the file to read: ";
    cin >> r;

    //read a file
    file = SndfileHandle (r) ;
    //printf ("Opened file '%s'\n", r) ;
    printf (" Sample rate : %d\n", file.samplerate ()) ;
    printf (" Channels : %d\n", file.channels ()) ;
    file.read (buffer, BUFFER_LEN) ;
    puts ("") ;


    cout << "Name of the file to write: ";
    cin >> w;
    
    file1 = SndfileHandle (w, SFM_WRITE, SF_FORMAT_WAV | SF_FORMAT_PCM_16, channels, srate) ;

	memset (buffer, 0, sizeof (buffer)) ;

	file1.write (buffer, BUFFER_LEN) ;
    
    puts ("") ;

    return 0;
}

//read a file


//write a file
void writeFile(float *buf, int startSamp, int endSamp){
    SF_INFO sfinfo ;
    sfinfo.channels = 1;
    sfinfo.samplerate = 44100;
    sfinfo.format = SF_FORMAT_WAV | SF_FORMAT_PCM_16;

    int frameLen = endSamp-startSamp;
    
    const char* path = "./test.wav";
    SNDFILE * outfile = sf_open(path, SFM_WRITE, &sfinfo);

    sf_seek(outfile, startSamp, SEEK_SET);
    sf_count_t count = sf_write_float(outfile, &buf[0], frameLen);
    
    sf_write_sync(outfile);
    //closes file
    sf_close(outfile);

}