import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;

public class OuvertureFichierAction implements ActionListener {
    

    private ButtonFile bouton;

    public OuvertureFichierAction(ButtonFile bouton){
		this.bouton = bouton;
	}


    public void actionPerformed(ActionEvent e){
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Grille", "gri");
        file.setFileFilter(filter);

        int returnVal = file.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Vous avez ouvert le fichier suivant " +
            file.getSelectedFile().getName());
        }
	
	}




}
