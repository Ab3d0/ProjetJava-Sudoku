import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class NouveauAction implements MouseListener {

    private FenetreJeux fenetre;

    public NouveauAction(FenetreJeux fenetre){
        this.fenetre = fenetre;
    }

    public void mouseEntered(MouseEvent e){
        Niveau niveau = new Niveau(fenetre.getTableauSudoku());
        niveau.afficherFenetreNiveau();
    }


    public void mouseClicked(MouseEvent e){
        return;
    }

    public void mouseExited(MouseEvent e){
        return;
    }
    public void mousePressed(MouseEvent e){
        return;
    }
    public void mouseReleased(MouseEvent e){
        return;
    }
}
