import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class creerAction implements ActionListener{
    
    private FenetrePrincipale1 fenetre;

    public creerAction(FenetrePrincipale1 fenetre) {
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
        if(fenetre.getEstadocrear()){
            fenetre.setEstadocrearFalse();
            NettoyerTxt nettoyeurTxt = new NettoyerTxt(fenetre.getListeTxt(), fenetre.getlisteTxtGenerés(), fenetre.gettxtBackground1(), fenetre.gettxtForeground1(), fenetre.getpanelBackground());
            nettoyeurTxt.NettoyerTxt();
        } else {
            if (fenetre.getTableauSudoku().CreerPartieSudoku()) {
                fenetre.setEstadocrearTrue();
                fenetre.sauvegarderGrille();
            }
        }
    }


}
