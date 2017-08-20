package reader;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;

public class Scale {
	private BufferedImage img;
	private int imheight, imwidth;

	 public Scale(){
		 
		 readImageScale();
		 processImage();
	 }
	
	
	
   
	
	 public void readImageScale(){
		
		
		
	
	
	
	
       setImg(null);
       try {
      // setImg(
    	   img = 
    		 ImageIO.read(new File("captukre.png"));
    	 
   }
    catch (IOException e) {
   }
}   

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage imgn) {
		this.img = imgn;
	}
	
	public void processImage(){
		imheight =  img.getHeight();
		imwidth = img.getWidth();
		 System.out.println(imheight+ "   "+imwidth  );
		printRGBVal();
				
		
		
		
	}
     //check if pixels at the same hight are uniform.
	public void printRGBVal(){
	  //Check if there is difference in line 
	 for (int iy = 3; iy < imheight; iy++){
		// System.out.println(img.g  getRGB(0, iy).+" , "+img.getRGB(1, iy) + " , "+img.getRGB(10, iy) );
		 
		 System.out.println("Height = " +(int) (4328. *( 1.-(double)(iy-0)/1865.)) + "   Red: " + 
				    new Color(img.getRGB(0, iy)).getRed()+
				 "   Green: "+ new Color(img.getRGB(0, iy)).getGreen()+
				 "   Blue: "+ new Color(img.getRGB(0, iy)).getBlue());
		
	  }
	}
		
		
	public double getHight(int rgb){
		double hx =0.; 
		Color tcol = new Color(rgb);
		int ered =  tcol.getRed();
		int eblue =  tcol.getBlue();
		int egreen =  tcol.getGreen(); 
		if( ered > 248){    // range 180 -390 
			hx = 180.+210.*(258-(double)egreen)/255.; 
			return hx;
		}
		if(ered <= 248 && ered > 7){ //range  81 -180
			hx = 81.+ 99 * ((double)ered/250.);
		}
        if( ered <= 7 ){
          if(egreen >= 249 ) // using blue  value to calculate height
        	                 // range 23 -81
          {
             hx = 23. + 58. *((double)255 - eblue)/255.;
          
          
          }
          else               //using green to calculate height
          {
        	  
        	hx =   24.* ((double)egreen-20.)/230.; 
        	  
          }
          
        	
        }
	 
		
		return hx;
	}
}