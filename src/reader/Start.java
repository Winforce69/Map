package reader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Start {
   
    private static void createAndShowGUI() {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        JFrame frame = new JFrame("Mapper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel background = new JLabel(); 
		try {
            BufferedImage icon = (ImageIO.read(new File("C:\\Users\\David_tmp\\Downloads\\download.jpg")));
            Image scaledIcon = icon.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            background.setIcon(new ImageIcon(scaledIcon));
		} catch (IOException e) {e.printStackTrace();}
		
		frame.getContentPane().add(background);
        frame.getContentPane().setPreferredSize(new Dimension(800, 600));
        
        JButton btnSettings = new JButton("Settings");
        frame.getContentPane().add(btnSettings, BorderLayout.NORTH);
        
        JButton btnNewButton_1 = new JButton("Read Image");
        frame.getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        btnNewButton_1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent ev) 
                {
                  new ReaderGUI();
                }
        });
    
   
    
    }

    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}