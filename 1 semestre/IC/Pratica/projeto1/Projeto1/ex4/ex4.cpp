//g++ ex4.cpp -o ex4 -std=c++11 `pkg-config --cflags --libs opencv`
//https://agostinhobritojr.github.io/tutorial/pdi/ -> tem coisas dos histogramas de cores
//https://stackoverflow.com/questions/7899108/opencv-get-pixel-channel-value-from-mat-image
//https://newbedev.com/c-and-opencv-get-and-set-pixel-color-to-mat
//#include </usr/lib/x86_64-linux-gnu/pkgconfig/opencv.pc>
#include <opencv2/highgui.hpp>
#include <iostream>
using namespace cv;
using namespace std;

int main( int argc, char** argv ) {
    
    if(argc != 3){
        cout << "Error: Should write <input filename> <output filename>" << endl;
        return 0; 
    }

    cv::Mat image;
    cv::Vec3b val;

    image = cv::imread(argv[1] ,cv::IMREAD_COLOR); //le a imagem
    if(! image.data ) { //se nao encontrou a imagem
        std::cout <<  "Image not found or unable to open" << std::endl ;
        return -1;
    }
    
    
    //ler a imagem pixel a pixel
    uint8_t* pixelPtr = (uint8_t*)image.data;

    int cn = image.channels(); //da nos os canais das cores... da para sabermos que cores e que sao

    for(int i=0; i<image.rows; i++){
        for(int j=0; j<image.cols; j++){
            //image.at<uchar>(i,j)=0;
            //get pixel
            Vec3b & val = image.at<Vec3b>(i,j);
            //color
            val[0] = pixelPtr[i*image.cols*cn + j*cn + 0];   //B
            val[1] = pixelPtr[i*image.cols*cn + j*cn + 1];   //G
            val[2] = pixelPtr[i*image.cols*cn + j*cn + 2];   //R


            // set pixel
            image.at<Vec3b>(Point(j,i)) = val;
            // You can now access the pixel value with cv::Vec3b
           // cv::imwrite(w,img.at<cv::Vec3b>(i,j)[0] + img.at<cv::Vec3b>(i,j)[1] + img.at<cv::Vec3b>(i,j)[2]); 
        }
    }
    
    //cv::imshow(w, image); //mostra a imagem -> mas nao copia pixel a pixel
    //cv::waitKey();

    //image=cv::imread(r,cv::IMREAD_COLOR);
    
    /*for(int i=200;i<210;i++){
        for(int j=10;j<200;j++){
            image.at<Vec3b>(i,j)=val;
        }
    }
    */
    
    cv::namedWindow(argv[2], cv::WINDOW_AUTOSIZE); //dar o nome da janela igual ao nome do ficheiro
    cv::imshow(argv[2], image); //mostra a imagem
    cv::imwrite(argv[2],image); //guarda a imagem
    
    cv::waitKey();


    imshow("Source image", src );
    imshow("Colour histogram", histImage);
    imshow("Source image gray", image1_gray);
    imshow("Grayscale histogram", hist_image);
    waitKey();



    //cv::Mat img = cv::imread(r); // le a imagem
    //cv::waitKey(0);
    return 0;

   
}
