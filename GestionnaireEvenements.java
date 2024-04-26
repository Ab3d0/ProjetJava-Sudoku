import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionnaireEvenements {
    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtAux;
    private ArrayList<JTextField> listeTxtGenerés;
    private Sudoku sudoku;
    private Color txtBackground1;
    private Color txtForeground1;
    private Color txtBackground2;
    private Color txtForeground2;
    private Color txtBackground3;
    private Color txtForeground3;
    private Color txtForeground4;
    private Color txtBackground4;
    private Color panelBackground;

    public GestionnaireEvenements(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtAux, ArrayList<JTextField> listeTxtGenerés, Sudoku sudoku, Color txtBackground1, Color txtForeground1, Color txtBackground2, Color txtForeground2, Color txtBackground3, Color txtForeground3, Color txtForeground4, Color txtBackground4, Color panelBackground) {
        this.listeTxt = listeTxt;
        this.listeTxtAux = listeTxtAux;
        this.listeTxtGenerés = listeTxtGenerés;
        this.sudoku = sudoku;
        this.txtBackground1 = txtBackground1;
        this.txtForeground1 = txtForeground1;
        this.txtBackground2 = txtBackground2;
        this.txtForeground2 = txtForeground2;
        this.txtBackground3 = txtBackground3;
        this.txtForeground3 = txtForeground3;
        this.txtForeground4 = txtForeground4;
        this.txtBackground4 = txtBackground4;
        this.panelBackground = panelBackground;
    }

    public void genereEvents(JTextField txt){
        MouseListener evento = new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    // Votre code pour la logique lorsque la souris est cliquée
                }
            
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Votre code pour la logique lorsque la souris entre dans le composant
                }
            
                @Override
                public void mouseExited(MouseEvent e) {
                    // Votre code pour la logique lorsque la souris sort du composant
                }
            
                @Override
                public void mousePressed(MouseEvent e) {
                    // Votre code pour la logique lorsque le bouton de la souris est enfoncé
                    pressed(txt);
                }
            
                @Override
                public void mouseReleased(MouseEvent e) {
                    // Votre code pour la logique lorsque le bouton de la souris est relâché
                }
            };
            KeyListener eventoTecla = new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                  
                }

                @Override
                public void keyPressed(KeyEvent e) {

                    if(PasModifiable(txt)){
                        return;
                    }
                    char keyPressed = e.getKeyChar();
                    String currentText = txt.getText().trim(); // Récupérer le texte actuel dans la case et supprimer les espaces
                    
                    // Si le caractère est un chiffre de 1 à 9
                    if (keyPressed >= '1' && keyPressed <= '9') {
                        // Si la longueur actuelle est inférieure à 7 (pour permettre jusqu'à quatre chiffres et trois espaces)
                        if (currentText.length() < 7) {
                            // Si le texte est vide, ajouter simplement le chiffre
                            if (currentText.isEmpty()) {
                                txt.setText(String.valueOf(keyPressed));
                            } else if (currentText.endsWith(" ")) {
                                // Si le texte se termine par un espace, ajouter le chiffre après un espace
                                txt.setText(currentText + keyPressed);
                            } else {
                                // Si le texte contient déjà des chiffres, ajouter le chiffre après un espace
                                txt.setText(currentText + " " + keyPressed);
                            }
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        // Si la touche de suppression est enfoncée et le texte n'est pas vide
                        if (!currentText.isEmpty()) {
                            // Supprimer le dernier caractère
                            txt.setText(currentText.substring(0, currentText.length() - 1));
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                   
                }
                
            };
            txt.addMouseListener(evento);
            txt.addKeyListener(eventoTecla);

    }
    public boolean PasModifiable(JTextField txt){
        for(JTextField jTxt : listeTxtGenerés){
            if(txt == jTxt){
                return true;
            }
        }
        return false;

    }
    
    public void pressed(JTextField txt){

            for(JTextField jTxt : listeTxtAux){
                jTxt.setBackground(txtBackground1);
                jTxt.setForeground(txtForeground1);
                jTxt.setBorder(BorderFactory.createLineBorder(panelBackground, 1));
        
            }
            listeTxtAux.clear();

            for(JTextField jTxt : listeTxtGenerés){
                jTxt.setBackground(txtBackground4);
                jTxt.setForeground(txtForeground4);
            }


            for(int i = 0; i < listeTxt.length; i++){
                for(int j = 0; j < listeTxt[0].length; j++){
                    if(listeTxt[i][j] == txt){
                        // Mettre à jour la couleur de fond et la couleur du texte de la ligne sélectionnée
                        for(int k = 0; k < listeTxt.length; k++){
                            listeTxt[i][k].setBackground(txtBackground2);
                            listeTxt[i][k].setForeground(txtForeground2);
                            listeTxtAux.add(listeTxt[k][j]);
                        }
                        
                        // Mettre à jour la couleur de fond et la couleur du texte de la colonne sélectionnée
                        for(int k = 0; k < listeTxt[0].length; k++){
                            listeTxt[k][j].setBackground(txtBackground2);
                            listeTxt[k][j].setForeground(txtForeground2);
                            listeTxtAux.add(listeTxt[i][k]);
                        }
                        int positionI = sudoku.sousGrilleActuelle(i);
                        int positionJ = sudoku.sousGrilleActuelle(j);
                        for ( int k = positionI-3 ; k < positionI; k++){
                            for(int l = positionJ - 3; l < positionJ; l++){
                                listeTxt[k][l].setBackground(txtBackground2);
                                listeTxt[k][l].setForeground(txtForeground2);
                                listeTxtAux.add(listeTxt[k][l]);
                            }
                        }
                        // Mettre à jour la couleur de fond et la couleur du texte de la case sélectionnée
                        txt.setBackground(txtBackground3);
                        txt.setForeground(txtForeground3);
                        txt.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
                        return;
                    }
                }
            }
        }
    }