import javax.swing.BorderFactory;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.ArrayList;


public class NettoyerTxt {

    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtGenerés;
    private Color txtBackground1;
    private Color txtForeground1;
    private Color panelBackground;

    // Constructeur de la classe, si nécessaire
    public NettoyerTxt(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtGenerés, Color txtBackground1, Color txtForeground1, Color panelBackground) {
        this.listeTxt = listeTxt;
        this.listeTxtGenerés = listeTxtGenerés;
        this.txtBackground1 = txtBackground1;
        this.txtForeground1 = txtForeground1;
        this.panelBackground = panelBackground;
    }

    // Méthode pour nettoyer les textes dans les cases
    public void NettoyerTxt() {
        for (int i = 0; i < listeTxt.length; i++) {
            for (int j = 0; j < listeTxt[0].length; j++) {
                listeTxt[i][j].setText("");
                listeTxt[i][j].setBackground(txtBackground1);
                listeTxt[i][j].setForeground(txtForeground1);
                listeTxt[i][j].setBorder(BorderFactory.createLineBorder(panelBackground, 1));
            }
        }
        listeTxtGenerés.clear();
    }
}
