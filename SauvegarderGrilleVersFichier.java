import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class SauvegarderGrilleVersFichier {
    public static void sauvegarderGrilleVersFichier(TableauSudoku tableauSudoku) {
        System.out.println("ok");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir un emplacement de sauvegarde");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille Sudoku (*.gri)", "gri"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
	    try {
		FileOutputStream file = new FileOutputStream(fileChooser.getSelectedFile());
		DataOutputStream fichier = new DataOutputStream(file);

		JTextField[][] listeTxt = tableauSudoku.getListeTxt();
		for(int ligne = 0; ligne < 9; ligne++){
		    StringBuilder sb = new StringBuilder();
		    for(int colonne = 0; colonne < 9; colonne++){
				String text = listeTxt[ligne][colonne].getText();
                if(text.isEmpty()){
                	sb.append("0");
                } else {
                    sb.append(text);
                }
		    }
		    String numChaine = sb.toString();
			System.out.println(numChaine);
		    int n = Integer.parseInt(numChaine);
			System.out.println(n);
		    fichier.writeInt(n);
		}


		
		try {
		    file.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
        }
    }
}
