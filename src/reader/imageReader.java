package reader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;


public class imageReader {
private BufferedImage img, imageOut;
private int imageHeight, imageWidth;
private int Sea_color;

		//Main Method Blah blah
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
            ImageIO.read(new File("us_dem.jpg"));
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


                     //For loop to fill each pixel Vertically and Horizontally
        imageOut = new BufferedImage(imageWidth, imageHeight, 1);
        for (int imageX = 0; imageX < imageWidth; imageX++) {
            for (int imageY = 0; imageY < imageHeight; imageY++){
                int redbluevalue = img.getRGB(imageX, imageY);
                double height = getHeight(redbluevalue);
                // *****IMAGE HEIGHT****
                if(height > 25){//meters//
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
    try{																		//Gets doxxed //Also change this where you want this Image because DOh!
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
 		
 			//This is where the magic begins Change this to values the scale thing outputs, forgot what changes what but try it out
 		if(Green >= 240 ){
 			if( Red >= 190 && Red < 255 ){	
 			if( Math.abs(Blue - Red) < 2 ){
			heightX = 2. + 2.0*(255.00 - (double)Red);
		
	              //using green to calculate height
		
	}
}
 		}  		
 		//old Method from last year
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