

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Niveau extends FenetrePrincipale {
    
    public Niveau(){
        JFrame difficultyFrame = new JFrame("Sélection de la difficulté");
        difficultyFrame.setSize(300, 200);
        difficultyFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(39, 83, 128));
        panel.setLayout(new GridLayout(3, 1));
        JButton facileButton = new JButton("Facile");
        facileButton.setForeground(Color.WHITE);
        facileButton.setBackground(new Color(39, 83, 128));
        facileButton.addActionListener(e -> {

            

            // Lorsque le bouton "Facile" est cliqué, appeler la méthode genererSudoku sur l'instance de TableauSudoku
            getTableauSudoku().genererSudoku(1);
            System.out.println("ok");
            difficultyFrame.dispose(); // Fermer la fenêtre de sélection de la difficulté après avoir cliqué sur le bouton "Facile"
        });
        JButton moyenButton = new JButton("Moyen");
        moyenButton.setForeground(Color.WHITE);
        moyenButton.setBackground(new Color(39, 83, 128));
        moyenButton.addActionListener(e -> {
            // Lorsque le bouton "Facile" est cliqué, appeler la méthode genererSudoku sur l'instance de TableauSudoku
            getTableauSudoku().genererSudoku(2);
            difficultyFrame.dispose(); // Fermer la fenêtre de sélection de la difficulté après avoir cliqué sur le bouton "Facile"
        });
        JButton difficileButton = new JButton("Difficile");
        difficileButton.setForeground(Color.WHITE);
        difficileButton.setBackground(new Color(39, 83, 128));
        difficileButton.addActionListener(e -> {
            // Lorsque le bouton "Facile" est cliqué, appeler la méthode genererSudoku sur l'instance de TableauSudoku
            getTableauSudoku().genererSudoku(3);
            difficultyFrame.dispose(); // Fermer la fenêtre de sélection de la difficulté après avoir cliqué sur le bouton "Facile"
        });
        panel.add(facileButton);
        panel.add(moyenButton);
        panel.add(difficileButton);
        difficultyFrame.add(panel);
        difficultyFrame.setVisible(true);
    }

    



}
