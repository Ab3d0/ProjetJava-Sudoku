import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextField;

public class ChargerGrilleVersFichier {
    public static void chargerGrilleDepuisFichier(TableauSudoku tableauSudoku) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir un fichier de grille à charger");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille Sudoku (*.gri)", "gri"));
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(fileToLoad))) {
                String line;
                int row = 0;
                JTextField[][] listeTxt = tableauSudoku.getListeTxt();
                while ((line = br.readLine()) != null) {
                    for (int col = 0; col < line.length(); col++) {
                        char c = line.charAt(col);
                        if (Character.isDigit(c)) {
                            // Vérifiez si le caractère est '0'
                            if (c == '0') {
                                // Si c'est le cas, affichez une chaîne vide dans le champ de texte
                                listeTxt[row][col].setText("");
                            } else {
                                // Sinon, affichez le chiffre normal
                                listeTxt[row][col].setText(Character.toString(c));
                            }
                        }
                    }
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
