import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextField;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;


public class ChargerGrilleVersFichier {
    public static void chargerGrilleDepuisFichier(TableauSudoku tableauSudoku) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisir un fichier de grille à charger");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille Sudoku (*.gri)", "gri"));
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
	    
	    
	    
	    
            /*File fileToLoad = fileChooser.getSelectedFile(); */
            try {
		FileInputStream file = new FileInputStream(fileChooser.getSelectedFile());
		DataInputStream fichier = new DataInputStream(file);
		
	        String chaine; 
		JTextField[][] listeTxt = tableauSudoku.getListeTxt();
		
		for(int ligne = 0; ligne < 9; ligne++){
		    int num = fichier.readInt();
		    String str = Integer.toString(num);


		    while(str.length() < 9){
			StringBuilder sb = new StringBuilder(str);
			sb.insert(0, '0');
			str = sb.toString();
		    }

		    for(int i = 0; i < 9; i++){
			if(str.charAt(i) == '0'){
			    listeTxt[ligne][i].setText("");
			} else {
			    char c = str.charAt(i);
			    String chiffre = Character.toString(c);
			    listeTxt[ligne][i].setText(chiffre);
			}
		    }

		    
		}

		


		
		try {
		    file.close();
		    
		    
		} catch (IOException e){
		    System.out.println("Erreur de fermeture du fichier");
		}
            } catch (IOException e) {
		System.out.println("Erreur d'ouverture du fichier");
	    }
        }
    }
}
