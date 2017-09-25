/**
 * Klasa obsługuje okno dla szyforowania
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SzyfrujGUI extends JPanel
                             implements ActionListener {
   
    JButton openButton;///<Otwórz dialog z wyobrem pliku

    JFileChooser fc;///<Dialog z wyborem plików

    ///Konstruktor
    public SzyfrujGUI() {
        super();
        //super.setBounds(0, 0, 500, 500);
        
        fc = new JFileChooser();

        openButton = new JButton("Wczytaj obraz");
        openButton.addActionListener(this);

        //Trzymaj w jednym miejscu
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(openButton);
        
        ///Miejsce na wyswietlenie zaszyfrowanych obrazkow
      //  JPanel pics = new JPanel(); 

        add(buttonPanel, BorderLayout.PAGE_START);
       // add(buttonPanel, BorderLayout.PAGE_END);
    }

    
    ///Obsługa zdarzeń
    public void actionPerformed(ActionEvent e) {

    	//Kliknięto button do otwierania plików
        if (e.getSource() == openButton) {
            fc.showOpenDialog(SzyfrujGUI.this);
            File file = fc.getSelectedFile();
            String[] pics;
            Obraz pic= new Obraz(file);
            if(pic.error!=true)
            {
            	pics =Szyfr.szyfruj(pic);
            	ShowPics.pop(pics,false);
            }
        }
    }

  
   ///Wyświetl okno
    public void pop() {
 
        JFrame frame = new JFrame("Szyfrator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new SzyfrujGUI());

    
        frame.pack();
        frame.setVisible(true);
    }

   
}
