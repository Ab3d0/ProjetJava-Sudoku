import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChargerActionCreation implements ActionListener {
    
    private FenetrePrincipale1 fenetre;

    public ChargerActionCreation(FenetrePrincipale1 fenetre) {
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
        fenetre.chargerGrille();
    }


}


