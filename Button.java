import javax.swing.*;
import java.awt.*;

public class Button {

    public static JButton createButton(String text, JPanel panel, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(39, 83, 128));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setBounds(x, y, 200, 50);
        panel.add(button);
        return button;
    }
}