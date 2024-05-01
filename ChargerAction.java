import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChargerAction implements ActionListener {
    
    private FenetreJeux fenetre;

    public ChargerAction(FenetreJeux fenetre) {
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
        fenetre.chargerGrille();
    }


}

