import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EffacerAction implements ActionListener {
    
    private FenetreJeux fenetre;

    public EffacerAction(FenetreJeux fenetre) {
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
        EffacerBouton éffacerButton = new EffacerBouton(fenetre.getTableauSudoku().getListeTxt(), fenetre.getTableauSudoku().getListeTxtGeneres());
        éffacerButton.BoutonEffacer();
    }


}

