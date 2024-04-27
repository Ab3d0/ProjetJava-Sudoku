import javax.swing.JTextField;
import java.util.ArrayList;

public class EffacerBouton {

    private JTextField[][] listeTxt;
    private ArrayList<JTextField> listeTxtGenerés;

    // Constructeur de la classe, si nécessaire
    public EffacerBouton(JTextField[][] listeTxt, ArrayList<JTextField> listeTxtGenerés) {
        this.listeTxt = listeTxt;
        this.listeTxtGenerés = listeTxtGenerés;
    }

    // Méthode pour effacer les valeurs des cases non générées
    public void BoutonEffacer() {
        for (int i = 0; i < listeTxt.length; i++) {
            for (int j = 0; j < listeTxt[0].length; j++) {
                boolean estGenere = false;
                for (JTextField txt : listeTxtGenerés) {
                    if (listeTxt[i][j] == txt) {
                        estGenere = true;
                        break;
                    }
                }
                if (!estGenere) {
                    listeTxt[i][j].setText("");
                }
            }
        }
    }
}
