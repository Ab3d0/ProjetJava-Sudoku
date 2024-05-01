import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VerifierAction implements ActionListener {
    
    private FenetreJeux fenetre;

    public VerifierAction(FenetreJeux fenetre) {
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
        VerifierBouton verifierBouton = new VerifierBouton(fenetre.getTableauSudoku().getListeTxt(), fenetre.getTableauSudoku().getListeTxtGeneres(), fenetre.getTableauSudoku().getSudoku());
        verifierBouton.verifierBouton();
    }


}


