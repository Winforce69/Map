package reader;
 
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
@SuppressWarnings("serial")
public class ReaderGUI extends JFrame {
 
   private JButton changeColor;
   public Color color = Color.lightGray;
   private Container c;
 
   
   @SuppressWarnings("deprecation")
public ReaderGUI()
   {
   
       super( "Fill" );
       try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
      c = getContentPane();
               GridBagLayout gridBagLayout = new GridBagLayout();
               gridBagLayout.columnWidths = new int[]{284, 0};
               gridBagLayout.rowHeights = new int[]{82, 23, 23, 23, 0, 0};
               gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
               gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
               getContentPane().setLayout(gridBagLayout);
               
               JButton btnNewButton = new JButton("Process Image");
               btnNewButton.addActionListener(new ActionListener() {
                @Override
                   public void actionPerformed(ActionEvent ev)
                       {
                         new imageReader();
                       }
               });
               
                    changeColor = new JButton( "Change Color" );
                    changeColor.setBounds(40,100,100,60);
                    changeColor.setBackground(Color.RED);
                   
                    changeColor.addActionListener(
                       new ActionListener() {
                          public void actionPerformed( ActionEvent e )
                          {
                             color =
                                JColorChooser.showDialog( ReaderGUI.this,
                                   "Choose a color", color );
 
                             if ( color == null )
                                color = Color.lightGray;
 
                             c.setBackground( color );
                             c.repaint();
                          }
                       }
                    );
                   
                        JSlider slider = new JSlider();
                        slider.setMaximum(4328);
                        slider.setPaintTicks(true);
                        slider.setPaintLabels(true);
                        slider.setMajorTickSpacing(700);
                        slider.setMinorTickSpacing(700);
                        GridBagConstraints gbc_slider = new GridBagConstraints();
                        gbc_slider.fill = GridBagConstraints.BOTH;
                        gbc_slider.insets = new Insets(0, 0, 5, 0);
                        gbc_slider.gridx = 0;
                        gbc_slider.gridy = 0;
                        getContentPane().add(slider, gbc_slider);
                    GridBagConstraints gbc_changeColor = new GridBagConstraints();
                    gbc_changeColor.anchor = GridBagConstraints.NORTH;
                    gbc_changeColor.insets = new Insets(0, 0, 5, 0);
                    gbc_changeColor.gridx = 0;
                    gbc_changeColor.gridy = 1;
                    c.add( changeColor, gbc_changeColor );
               
               JButton btnPickImage = new JButton("Pick Image");
               GridBagConstraints gbc_btnPickImage = new GridBagConstraints();
               gbc_btnPickImage.anchor = GridBagConstraints.NORTH;
               gbc_btnPickImage.insets = new Insets(0, 0, 5, 0);
               gbc_btnPickImage.gridx = 0;
               gbc_btnPickImage.gridy = 2;
               getContentPane().add(btnPickImage, gbc_btnPickImage);
               
               btnPickImage.addActionListener(new ActionListener() {
                    @Override
                      public void actionPerformed(ActionEvent ev)
                          {
                            Filechooser.Filepick();
                          }
                  });
               GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
               gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
               gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
               gbc_btnNewButton.gridx = 0;
               gbc_btnNewButton.gridy = 3;
               getContentPane().add(btnNewButton, gbc_btnNewButton);
               
               JButton btnScale = new JButton("Scale");
               GridBagConstraints gbc_btnScale = new GridBagConstraints();
               gbc_btnScale.gridx = 0;
               gbc_btnScale.gridy = 4;
               getContentPane().add(btnScale, gbc_btnScale);
     
               btnScale.addActionListener(new ActionListener() {
                   @Override
                     public void actionPerformed(ActionEvent ev)
                         {
                           new Scale();
                         }
                 });
     
     
     
      setSize( 300, 300 );
      show();
   }
 
   public static void main( String args[] )
   {
      ReaderGUI app = new ReaderGUI();
 
      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   }
}