
import java.awt.*;
import javax.swing.*;

public class Bouton extends JButton {

    public Bouton (String text, JPanel panel, int x, int y){
        super(text);
        this.setFont(new Font(this.getFont().getName(), Font.BOLD, 16));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(39, 83, 128));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBounds(x, y, 200, 50);
        panel.add(this);
    }



}
