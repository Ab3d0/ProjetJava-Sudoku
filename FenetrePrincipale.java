import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetrePrincipale extends JFrame {

    private TableauSudoku tableauSudoku;
    private boolean estadoCrear = false;
    private JButton sauvegarderButton; // Déclaration en tant que membre de classe

    public FenetrePrincipale() {
        setTitle("Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800); // Taille de la fenêtre
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Panneau pour dessiner le contenu
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
        setContentPane(panel);

        // Définir le texte "Sudoku" en gras en haut à gauche
        JLabel label = new JLabel("Sudoku");
        label.setFont(new Font(label.getFont().getName(), Font.BOLD, 24));
        label.setForeground(Color.WHITE); // Texte en blanc pour contraster avec le fond
        label.setBounds(10, 10, 200, 30); // Position et taille du label
        panel.add(label);

        JButton creerButton = Button.createButton("Créer", panel, 700, 200);
        creerButton.addActionListener(e -> {
            if (estadoCrear) {
                // Si estadoCrear est true, alors masquer les boutons
               
                sauvegarderButton.setVisible(true);
                estadoCrear = false;
                tableauSudoku.NettoyerTxt();
                creerButton.setText("Commencer");
                
            } else {
                if (tableauSudoku.CreerPartieSudoku()) {
                    sauvegarderButton.setVisible(false);
                    estadoCrear = true;
                    creerButton.setText("Créer");
                }
            }
        });

        // Initialiser le bouton verifierButton avant d'ajouter l'action listener
      
     
        sauvegarderButton = Button.createButton("Sauvegarder", panel, 700, 450);
        sauvegarderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sauvegarderGrille();
            }
        });
        sauvegarderButton.setVisible(false);
    
        // Bouton pour charger la grille
      

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
    
        setVisible(true); // Rendre la fenêtre visible
    }

    public TableauSudoku getTableauSudoku() {
        return tableauSudoku;
    }

    private void sauvegarderGrille() {
        tableauSudoku.sauvegarderGrilleVersFichier();
        // Ajoutez ici le code pour informer l'utilisateur que la sauvegarde est terminée, si nécessaire
    }

  
}
