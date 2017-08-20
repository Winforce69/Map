package reader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import java.awt.*;


public class imageReader {
private BufferedImage img, imageOut;
private int imageHeight, imageWidth;
private int Sea_color;
public imageReader() {

        initializeSet();
        readImage();
        ProcessImage();
        createOutImage();
        saveProcFile(); 
}


public static void main(String[] args) {
    @SuppressWarnings("unused")
    imageReader iR= new imageReader();
}
public void initializeSet() {

    Color cold = new Color(17, 20, 50);
    Sea_color = cold.getRGB();
    }
public  void readImage(){
    try{
        img =
            ImageIO.read(new File("C:\\Users\\David_tmp\\Desktop\\us_dem.jpg"));
    }
    catch (IOException e) {         
    }
}
public void ProcessImage(){
    imageHeight = img.getHeight();
    imageWidth = img.getWidth();
    System.out.println(imageHeight+ "  "+imageWidth );
    }
    public void createOutImage(){



        imageOut = new BufferedImage(imageWidth, imageHeight, 1);
        for (int imageX = 0; imageX < imageWidth; imageX++) {
            for (int imageY = 0; imageY < imageHeight; imageY++){
                int redbluevalue = img.getRGB(imageX, imageY);
                double height = getHeight(redbluevalue);
                // *****IMAGE HEIGHT****
                if(height > 5000){//meters//
                //***END OF HEIGHT****  

                    imageOut.setRGB(imageX, imageY, redbluevalue);
                }
                else{
                	System.out.println("!!! " +height);
                    imageOut.setRGB(imageX, imageY, Sea_color);   
                }
            }
        }
    }

public void saveProcFile(){
    try{
    	File outputfile = new File("C:\\Users\\David_tmp\\Desktop\\All Folders\\Project Images\\US_DEM.PNG" + imageHeight);
        ImageIO.write(imageOut, "jpg", outputfile);
    }
    catch(IOException e) {
 }
 }  
 	public double getHeight(int RGB){
 		double heightX = 10000.;
 		Color tcol = new Color(RGB);
 		int Red = tcol.getRed();
 		int Blue = tcol.getBlue();
 		int Green = tcol.getGreen();
 		if(Green >= 240 ){
 			if( Red >= 190 && Red < 255 ){	
 			if( Math.abs(Blue - Red) < 2 ){
			heightX = 2. + 2.0*(255.00 - (double)Red);
		//}
		
	              //using green to calculate height
		
	}
}
 		}  		
/*public double getHeight(int RGB){
		double heightX = 0.;
Color tcol = new Color(RGB);
int Red = tcol.getRed();
int Blue = tcol.getBlue();
int Green = tcol.getGreen();
if( Red >248) {
heightX = 81.+ 99 * ((double)Red/250.);
}	
if( Red <= 7 ){
if(Green >= 249 ) // using blue  value to calculate height
//range 23 -81
{
heightX = 23. + 58. *((double)255 - Blue)/255.;
}
else               //using green to calculate height
{  
heightX =   24.* ((double)Green-20.)/230.;  
} 
}*/
     				return heightX;
 	}
}