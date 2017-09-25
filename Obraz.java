/**
 * Funkcja reprezentuje pojedynczy obraz
 */


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Obraz {
	
	private BufferedImage pic;///<Obraz już w pożądanym formacie
	private String name;///<Nazwa obrazu
	private File file;///<Ścieżka do pliku
	public boolean error=false;
	
	///Konstruktor
	public Obraz (File file)
	{	
		String name = file.getName().toString();
		this.name=name.substring(0,name.lastIndexOf("."));
		this.file=file;
		BufferedImage pic = null; 
		 try{
			 File plik = new File(file.getAbsolutePath().toString());
			 this.pic = ImageIO.read(plik);
		 }catch(Exception e)
		 {
			 error=true;
			 e.printStackTrace();		 
		 }
	}

	/**
	 * Maska na obraz
	 * @return int[][] tablica 01, [x][y]=0 jeżeli x,y pixel biały, 1 w p.p.
	 */
	public int[][] pixels()
	{
		//Rozpoznaj czy dany pixel jest czarny
		int [][]pixels = new int[this.pic.getWidth()][this.pic.getHeight()];
		int i=0;
		
		while(i<this.pic.getWidth())
		{
			for(int y=0;y<this.pic.getHeight();y++)
			{
				int rgb=this.pic.getRGB(i, y);;
				//int alpha = (rgb >> 24) & 0xFF;
				int red =   (rgb >> 16) & 0xFF;
				//int green = (rgb >>  8) & 0xFF;
				//int blue =  (rgb      ) & 0xFF;
				//Dosyć uproszczone rozpoznawanie czy kolor czarny :)
				if(red<20)
					pixels[i][y]=1;
				else pixels[i][y]=0;
			}
			i++;
			
		}
		
		return pixels;
	
	}
	
	public BufferedImage getPic() {
		return pic;
	}

	public void setPic(BufferedImage pic) {
		this.pic = pic;
	}

	/**
	 * Koloruje w odpowiedni sposób dany przez x,y pixel i do niego przyległe
	 * @param x współrzedna x-owa
	 * @param y współrzedna y-owa
	 * @param random obraz pierwszy do kolorowania
	 * @param drugi obraz drugi do kolorowania
	 * @param r wylosowana opcja zapełnienia "czwórki"
	 * @param kolor 1 - czarny,0 -bialy
	 * @param pics 
	 */
	public static void paint(int x, int y, BufferedImage random,  BufferedImage drugi ,int r,int kolor) {
		Color color[]=new Color[2];

		color[0]=new Color(0,0,0,0);
		color[1]=Color.BLACK;
		int xx,xy,yx,yy;

		xx=Cell.xx(r);
		xy=Cell.xy(r);
		yx=Cell.yx(r);
		yy=Cell.yy(r);
		

		random.setRGB(x, y,color[xx].getRGB());
		random.setRGB(x+1, y,color[xy].getRGB());
		random.setRGB(x, y+1, color[yx].getRGB());
		random.setRGB(x+1, y+1, color[yy].getRGB());
				
		//Teraz algorym visual crypto, 
		//sprawdz czy dany pixel czarny, jesli tak to 
		//drugi plik wypelnij odwrotnym ksztaltem
		if(kolor==1)
		{
			xx=Cell.inverse(xx);
			xy=Cell.inverse(xy);
			yx=Cell.inverse(yx);
			yy=Cell.inverse(yy);
				
		}
		
		drugi.setRGB(x, y,color[xx].getRGB());
		drugi.setRGB(x+1, y,color[xy].getRGB());
		drugi.setRGB(x, y+1, color[yx].getRGB());
		drugi.setRGB(x+1, y+1, color[yy].getRGB());
			
	}

	
	/**
	 * Zapisz dane pliki
	 * @param pic1 obraz losowy
	 * @param pic2 obraz potrzebny do rozszyfrowania
	 * @param pics 
	 */
	public void save(BufferedImage pic1,BufferedImage pic2, String[] pics) {
		String path1,path2;
		path1= new String(this.file.getParent());
		path2= new String(this.file.getParent());
		path1+="/"+this.name+"1.png";
		path2+="/"+this.name+"2.png";
		
		try {
			ImageIO.write(pic1, "png", new File (path1));
			pics[1]=path1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ImageIO.write(pic2, "png", new File (path2));
			pics[2]=path2;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public String getFileName() {
		return this.file.toString();
	}

	
	

}
