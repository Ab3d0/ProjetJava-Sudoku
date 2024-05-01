import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResoudreAction implements ActionListener {
    
    private FenetreJeux fenetre;

    public ResoudreAction(FenetreJeux fenetre) {
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
        ResoudreBouton resoudreButton = new ResoudreBouton(fenetre.getTableauSudoku().getListeTxt(), fenetre.getTableauSudoku().getListeTxtGeneres(), fenetre.getTableauSudoku().getSudoku());
        resoudreButton.boutonrésoudre();

        fenetre.setTime(resoudreButton);
    }


}


