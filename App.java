/**
 * App
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class App {

    
    public static void main(String[] args) {
        JFrame fenetre = new JFrame();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(800, 800);
        fenetre.setLocation(500, 100);

        ButtonFile btn = new ButtonFile();




        fenetre.add(btn);
        fenetre.setVisible(true);

    }



}