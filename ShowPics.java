/**
 * Klasa obsługuje okno wyświetlające efekt szyfrowania
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowPics  {
   

   
   ///Wyświetl okno
    public static void pop(final String[] picsPaths, final boolean b) {
 
    	JPanel pics = new JPanel()
		{
			@Override
			public void paint(Graphics g)
			{
				super.paint(g);
				
				BufferedImage img1 = null ;
				BufferedImage img2 = null;
				BufferedImage img3 = null;
				
				if(b!=true)
				{
				    try {
				    	
						img1 = ImageIO.read(new File(picsPaths[0]));
	
					} catch (IOException e) {
		
						e.printStackTrace();
					}
				}
				    try {
						img2 = ImageIO.read(new File(picsPaths[1]));
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				    
				    try {
				    	
						img3 = ImageIO.read(new File(picsPaths[2]));
	
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				    
				    if(b!=true)
				    {
					    g.drawImage(img1,0,0,300,300,null);
					    g.drawImage(img2,400,0,300,300,null);
					    g.drawImage(img3,750,0,300,300,null);
				    }
				    else
				    {
				    	g.drawImage(img2,0,0,500,500,null);
					    g.drawImage(img3,0,0,500,500,null);
				    	
				    }
				  
			}
			
		};
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
    
        JFrame frame = new JFrame("Zaszyfrowane obrazy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pics);
		//pane.setLocation(200, 200);
        frame.pack();
        frame.setBounds(0, 0,(int)(width*0.8), (int)(height*0.8));
        frame.setVisible(true);
    }

	
   
}
