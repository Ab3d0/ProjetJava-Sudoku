import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonFile extends JPanel {
    
    public ButtonFile() {
        
        /* Hérite du constructeur */
	    super();
	
	    JButton fichier = new JButton("Fichier");
		
        OuvertureFichierAction openFile = new OuvertureFichierAction(this);
        fichier.addActionListener(openFile);

        this.add(fichier);
	}




}
