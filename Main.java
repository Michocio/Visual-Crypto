import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Main {

	public static void main(String[] args) {
		//Obraz test= new Obraz("/home/majki/eclipse/Visual Crypto/src/pic2.jpg");
		/*
		Szyfr.szyfruj(test.pixels());
		 
		
		JFrame frame=new JFrame("Visual Crypto");
		
		
		JPanel pane = new JPanel()
		{
			@Override
			public void paint(Graphics g)
			{
				super.paint(g);
				
				BufferedImage img1 = null ;
				BufferedImage img2 = null;
				BufferedImage img3 = null;
				    try {
				    	
						img1 = ImageIO.read(new File("/home/majki/eclipse/Visual Crypto/src/img1.png"));
	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    try {
						img2 = ImageIO.read(new File("/home/majki/eclipse/Visual Crypto/src/img2.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    try {
				    	
						img3 = ImageIO.read(new File("/home/majki/eclipse/Visual Crypto/src/img3.png"));
	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    
				   // g.drawImage(img1,0,0,500,500,null);
				  //  g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
				    //g.drawImage(img1,0,0,500,500,null);
				    //g.drawImage(img2,0,0,500,500,null);
				    for(int i=0;i<img3.getWidth();i++)
				    {
				    	for(int j=0;j<img3.getHeight();j++)
				    	{
				    		int rgb=img3.getRGB(i, j);;
							int alpha = (rgb >> 24) & 0xFF;
							int red =   (rgb >> 16) & 0xFF;
							int green = (rgb >>  8) & 0xFF;
							
							int blue =  (rgb      ) & 0xFF;
							Color kolor =new Color(255,green,blue,alpha);
							
				    		img3.setRGB(i, j,kolor.getRGB());
				    		
				    	}
				    	
				    }
				  //  g.drawImage(img1,0,0,500,500,null);
				    ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
				    //g.drawImage(img3,0,0,500,500,null);
				   
			}
			
		};
		
		*/
		
		SzyfrujGUI start= new SzyfrujGUI ();
		start.pop();
	        
	
		//frame.add(pane);
		//pane.setLocation(200, 200);
		//frame.pack();
		//frame.setBounds(0, 0, (int)(0.75*width),(int) (0.75*height));
		//JComponent pic= img.getGraphics().drawImage(img,0,0,null);
		//frame.setVisible(true);
	//	frame.paint(img.getGraphics().drawImage(img, 0, 0, null));
		}
}