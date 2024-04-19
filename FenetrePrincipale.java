import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * FenetrePrincipale
 */

public class FenetrePrincipale {

    private TableauSudoku tableauSudoku;
    private boolean estadoCrear = false;
    private Bouton verifierButton;
    private Bouton resoudreButton;
    private Bouton sauvegarderButton;
    private Bouton chargerButton;

    public FenetrePrincipale(){
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Sudoku");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1200, 800); // Taille de la fenêtre
        fenetre.setLocationRelativeTo(null); // Centrer la fenêtre

        /* Panneau pour dessiner le contenu */
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dessiner le fond bleu ciel
                g.setColor(new Color(39, 83, 128)); // Bleu ciel
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null); // Désactiver la disposition automatique
        fenetre.setContentPane(panel);

        // Définir le texte "Sudoku" en gras en haut à gauche
        JLabel label = new JLabel("Sudoku");
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 24));
        label.setForeground(Color.WHITE); // Texte en blanc pour contraster avec le fond
        label.setBounds(10, 10, 200, 30); // Position et taille du label
        panel.add(label);

        Bouton nouveauButton = new Bouton("Nouvelle Partie", panel, 700, 100);
        nouveauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Niveau n = new Niveau();        
            }
        });




        Bouton effacerButton = new Bouton("Effacer", panel, 700, 150);
        effacerButton.addActionListener(e -> {
            // Lorsque le bouton "Effacer" est cliqué, appeler la méthode BoutonEffacer sur l'instance de TableauSudoku
            getTableauSudoku().BoutonEffacer();
        });

        Bouton verifierButton = new Bouton("Vérifier", panel, 700, 250);
        verifierButton.addActionListener(e -> {
            // Appeler la méthode VerifierBouton sur l'instance de TableauSudoku lorsque le bouton "Vérifier" est cliqué
            getTableauSudoku().VerifierBouton();
        });

        Bouton resoudreButton = new Bouton("Résoudre", panel, 700, 300);
        resoudreButton.addActionListener(e -> {
            // Lorsque le bouton "Effacer" est cliqué, appeler la méthode BoutonEffacer sur l'instance de TableauSudoku
            getTableauSudoku().Boutonrésoudre();
        });

        Bouton sauvegarderButton = new Bouton("Sauvegarder", panel, 700, 450);
        sauvegarderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sauvegarderGrille();
            }
        });
        sauvegarderButton.setVisible(false);

        Bouton chargerButton = new Bouton("Charger", panel, 700, 500);
        chargerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chargerGrille();
            }
        });
        chargerButton.setVisible(false);

        Bouton creerButton = new Bouton("Créer", panel, 700, 200);
        creerButton.addActionListener(e -> {
            if (estadoCrear) {
                // Si estadoCrear est true, alors masquer les boutons
                nouveauButton.setVisible(false);
                effacerButton.setVisible(false);
                verifierButton.setVisible(false);
                resoudreButton.setVisible(false);
                sauvegarderButton.setVisible(true);
                chargerButton.setVisible(true);
                estadoCrear = false;
                tableauSudoku.NettoyerTxt();
                creerButton.setText("Commencer");
                
            } else {
                
                if (tableauSudoku.CreerPartieSudoku()) {
                    nouveauButton.setVisible(true);
                    effacerButton.setVisible(true);
                    resoudreButton.setVisible(true);
                    verifierButton.setVisible(true); /* Crash ici */
                    sauvegarderButton.setVisible(false);
                    chargerButton.setVisible(false);
                    estadoCrear = true;
                    creerButton.setText("Créer");
                }
            }
        });

        



        tableauSudoku = new TableauSudoku();
        tableauSudoku.setHauteurTxt(36);
        tableauSudoku.setLargeurTxt(36);
        tableauSudoku.setMargeTxt(4);
        tableauSudoku.setTaillePoliceTxt(27);

        tableauSudoku.setPanelBackground(new Color(0, 0, 0));

        tableauSudoku.setTxtBackground1(Color.WHITE);
        tableauSudoku.setTxtForeground1(Color.BLACK);
        tableauSudoku.setTxtBackground2(new Color(102,178,255));
        tableauSudoku.setTxtForeground2(Color.BLACK);
        tableauSudoku.setTxtBackground3(new Color(0, 128, 255));
        tableauSudoku.setTxtForeground3(Color.WHITE);
        tableauSudoku.setTxtBackground4(new Color(212, 230, 241));
        tableauSudoku.setTxtForeground4(Color.BLACK);
        panel.add(tableauSudoku);
        tableauSudoku.setBounds(20, 60, 610, 610); // Position et taille du TableroSudoku // Changer la dimension du panneau
        tableauSudoku.setVisible(true);











        fenetre.setVisible(true);
 
 
    }

    public TableauSudoku getTableauSudoku() {
        return tableauSudoku;
    }

    private void sauvegarderGrille() {
        tableauSudoku.sauvegarderGrilleVersFichier();
        // Ajoutez ici le code pour informer l'utilisateur que la sauvegarde est terminée, si nécessaire
    }

    // Méthode pour charger la grille
    private void chargerGrille() {
        tableauSudoku.chargerGrilleDepuisFichier();
        // Ajoutez ici le code pour informer l'utilisateur que le chargement est terminé, si nécessaire
    }



}