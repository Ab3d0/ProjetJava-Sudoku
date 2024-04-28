import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;


public class SauvegarderGrilleVersFichier {
    public static void sauvegarderGrilleVersFichier(TableauSudoku tableauSudoku) {
        System.out.println("ok");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir un emplacement de sauvegarde");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille Sudoku (*.gri)", "gri"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave)) {
                JTextField[][] listeTxt = tableauSudoku.getListeTxt();
                boolean debut = false;
                for (int i = 0; i < listeTxt.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < listeTxt[0].length; j++) {
                        String text = listeTxt[i][j].getText();
                        System.out.println(text);
                        if(debut == false){
                            if(text.isEmpty()){
                                sb.append(" ");
                            } else {
                                sb.append(text);
                                debut = true;
                            }
                        } else {
                            if (text.isEmpty()) {
                                sb.append("0");
                            } else {
                                sb.append(text);
                            }
                        }


                        
                    }
                    debut = false;
                    writer.write(sb.toString() + System.lineSeparator());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}