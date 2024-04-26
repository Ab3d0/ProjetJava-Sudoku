import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;


public class SauvegarderGrilleVersFichier {
    public static void sauvegarderGrilleVersFichier(TableauSudoku tableauSudoku) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir un emplacement de sauvegarde");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille Sudoku (*.sudoku)", "sudoku"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave)) {
                JTextField[][] listeTxt = tableauSudoku.getListeTxt();
                for (int i = 0; i < listeTxt.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < listeTxt[0].length; j++) {
                        String text = listeTxt[i][j].getText();
                        if (!text.isEmpty()) {
                            sb.append(text);
                        } else {
                            sb.append("0");
                        }
                    }
                    writer.write(sb.toString() + System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
