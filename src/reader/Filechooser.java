package reader;
 
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
public class Filechooser {
    
	public static ImageIcon imageIcon;
	public static File imageFile;
	
    public static void Filepick() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
       
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
	           try {
	        	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        	   int windowWidth = (int) screenSize.getWidth() / 2;
	        	   int windowHeight = (int) screenSize.getHeight() / 2;
	        	   JButton Confirm = new JButton("Confirm");
	               JFrame imageWindow = new JFrame("Confirm Image");
	               
	               imageWindow.setSize(windowWidth, windowHeight);
	               
	               imageFile = (chooser.getSelectedFile());
	               
	               System.out.println("image file selected: " + imageFile.getAbsolutePath());

	               Confirm.addActionListener(new ActionListener() {
	                   public void actionPerformed(ActionEvent e)
	                   {
	                       System.exit(0);
	                   }
	               });

	               imageIcon = new ImageIcon(ImageIO.read(imageFile).getScaledInstance(windowWidth, windowHeight, Image.SCALE_SMOOTH));
	               
	        	   JLabel image = new JLabel();
				   image.setIcon(imageIcon);
				   
				   imageWindow.add(image);
				   
				   imageWindow.setVisible(true);
			} catch (IOException fileError) {
				fileError.printStackTrace();
			}
        }
   
    }
 
    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Filepick();
            }
        });
    }
}