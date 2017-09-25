/**
 * Klasa oferuje metode szyfrujacą
 * dany obraz
 */

import java.awt.image.BufferedImage;
import java.util.Random;


public class Szyfr {
	
	///Szyfrator
	public static String[] szyfruj( Obraz obraz)
	{
		String [] pics=new String[3];
		pics[0]=new String(obraz.getFileName());
			if(obraz.error!=true)
			{
				int [][] pic=obraz.pixels();
				Random rand= new Random();
				BufferedImage random, drugi;
				int w=2*pic.length;
				int h=2*pic[0].length;
				random=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
				drugi=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
				
				for(int x=0;x<w/2;x++)
				{
					for(int y=0;y<h/2;y++)
					{
						int los= rand.nextInt(6);
						Obraz.paint(x*2,y*2,random,drugi,los,pic[x][y]);
					}
					
				}
				obraz.save(random,drugi,pics);	
			}
			return pics;
	}

}
