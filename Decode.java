/**
 * Klasa obsługuje okno dla "odszyfrowania" obrazu
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Decode extends JPanel
                             implements ActionListener {
   
    JButton openButton1,openButton2;///<Otwórz dialog z wyobrem pliku

    JFileChooser fc1,fc2;///<Dialog z wyborem plików
    
    static String[] paths= new String[3];
    static int push=0;
    ///Konstruktor
    public Decode() {
        super();
        //super.setBounds(0, 0, 500, 500);
        
        fc1 = new JFileChooser();
        fc2 = new JFileChooser();
        
        openButton1 = new JButton("Wczytaj obraz pierwszy");
        openButton1.addActionListener(this);
        
        openButton2 = new JButton("Wczytaj obraz drugi");
        openButton2.addActionListener(this);

        //Trzymaj w jednym miejscu
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(openButton1);
        buttonPanel.add(openButton2);
        ///Miejsce na wyswietlenie zaszyfrowanych obrazkow
      //  JPanel pics = new JPanel(); 

        add(buttonPanel, BorderLayout.PAGE_START);
       // add(buttonPanel, BorderLayout.PAGE_END);
    }

    
    ///Obsługa zdarzeń

	public void actionPerformed(ActionEvent e) {

    	//Kliknięto button do otwierania plików
        if (e.getSource() == openButton1) {
            fc1.showOpenDialog(Decode.this);
            File file = fc1.getSelectedFile();
            push++;
            paths[push]=new String(file.getAbsolutePath().toString());
            openButton1.setEnabled(false);
            
        }
        else if (e.getSource() == openButton2)
        {
        	fc2.showOpenDialog(Decode.this);
            File file = fc2.getSelectedFile();
            push++;
            paths[push]=new String(file.getAbsolutePath().toString());
            openButton2.setEnabled(false);
        }
        
        if(push==2)
        {
        	ShowPics.pop(paths,true);
        }
    }

  
   ///Wyświetl okno
    public void pop() {
 
        JFrame frame = new JFrame("Szyfrator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Decode());

    
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	Decode run=new Decode();
    	run.pop();
    	
    }
    
   
}
