//fazer um (7) shitf para a direita e depois um para a esquerda
#include "opencv2/highgui.hpp"
#include "opencv2/imgcodecs.hpp"
#include "opencv2/imgproc.hpp"
#include <iostream>
using namespace std;
using namespace cv;


int main(int argc, char** argv) 
{
    if(argc < 3){
        cout << "Error: Should write <input filename> <output filename>" << endl;
        return 0; 
    }
    string filename = argv[1];
    const char* path = "./imagensPPM/";
    filename = path + filename;
    path = filename.c_str();

    Mat image = imread(filename ,IMREAD_COLOR);
    //create final image
    Mat Final_image = Mat::zeros(image.size(),image.type()); 
    imshow("Initial image",image);

    if(! image.data ) { //if you did not find the image
        std::cout <<  "Image not found or unable to open" << std::endl ;
        return -1;
    }
    
    //read the image pixel by pixel
    uint8_t* pixelPtr = (uint8_t*)image.data;

    int cn = image.channels(); //gives us the colour channels (which colours they are)
    
    for(int i=0; i<image.rows; i++){
        for(int j=0; j<image.cols; j++){
            //get pixel
            Vec3b & val = Final_image.at<Vec3b>(i,j);
            //color
            val[0] = (((pixelPtr[i*image.cols*cn + j*cn + 0])>>8)<<8);     //B
            val[1] = (((pixelPtr[i*image.cols*cn + j*cn + 1])>>8)<<8);     //G
            val[2] = (((pixelPtr[i*image.cols*cn + j*cn + 2])>>8)<<8);     //R
            // set pixel (Can now access the pixel value with cv::Vec3b)
            Final_image.at<Vec3b>((i,j)) = val;
        }
    }

    imwrite(argv[2],Final_image); //save image
    imshow("Final image",Final_image); // show image
    waitKey();


    return 0;
}