import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Niveau {

    private TableauSudoku tableauSudoku;

    public Niveau(TableauSudoku tableauSudoku) {
        this.tableauSudoku = tableauSudoku;
    }

    // Méthode pour afficher la fenêtre de sélection de la difficulté
    public void afficherFenetreNiveau() {
        JFrame difficultyFrame = new JFrame("Sélection de la difficulté");
        difficultyFrame.setSize(300, 200);
        difficultyFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(39, 83, 128));
        panel.setLayout(new GridLayout(3, 1));
        JButton facileButton = new JButton("Facile");
        facileButton.setForeground(Color.WHITE);
        facileButton.setBackground(new Color(39, 83, 128));
        facileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lorsque le bouton "Facile" est cliqué, appeler la méthode genererSudoku sur l'instance de TableauSudoku
                GenererSudoku genererSudoku = new GenererSudoku(tableauSudoku.getListeTxt(), tableauSudoku.getListeTxtGeneres(),
                        tableauSudoku.getTxtBackground4(), tableauSudoku.getTxtForeground4(), tableauSudoku.getSudoku());
                genererSudoku.genererSudoku(1);
                difficultyFrame.dispose(); // Fermer la fenêtre de sélection de la difficulté après avoir cliqué sur le bouton "Facile"
            }
        });
        JButton moyenButton = new JButton("Moyen");
        moyenButton.setForeground(Color.WHITE);
        moyenButton.setBackground(new Color(39, 83, 128));
        moyenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lorsque le bouton "Moyen" est cliqué, appeler la méthode genererSudoku sur l'instance de TableauSudoku
                GenererSudoku genererSudoku = new GenererSudoku(tableauSudoku.getListeTxt(), tableauSudoku.getListeTxtGeneres(),
                        tableauSudoku.getTxtBackground4(), tableauSudoku.getTxtForeground4(), tableauSudoku.getSudoku());
                genererSudoku.genererSudoku(2);
                difficultyFrame.dispose(); // Fermer la fenêtre de sélection de la difficulté après avoir cliqué sur le bouton "Moyen"
            }
        });
        JButton difficileButton = new JButton("Difficile");
        difficileButton.setForeground(Color.WHITE);
        difficileButton.setBackground(new Color(39, 83, 128));
        difficileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lorsque le bouton "Difficile" est cliqué, appeler la méthode genererSudoku sur l'instance de TableauSudoku
                GenererSudoku genererSudoku = new GenererSudoku(tableauSudoku.getListeTxt(), tableauSudoku.getListeTxtGeneres(),
                        tableauSudoku.getTxtBackground4(), tableauSudoku.getTxtForeground4(), tableauSudoku.getSudoku());
                genererSudoku.genererSudoku(3);
                difficultyFrame.dispose(); // Fermer la fenêtre de sélection de la difficulté après avoir cliqué sur le bouton "Difficile"
            }
        });
        panel.add(facileButton);
        panel.add(moyenButton);
        panel.add(difficileButton);
        difficultyFrame.add(panel);
        difficultyFrame.setVisible(true);
    }
}
