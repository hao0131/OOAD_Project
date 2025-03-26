package UI.Button;

import java.awt.Color;

import javax.swing.ImageIcon;

import mode.*;
public class SelectButton extends ButtonI {
    public SelectButton(String ImagePath) {
        ImageIcon icon = new ImageIcon(ImagePath);
        setIcon(icon);
        setBackground(Color.DARK_GRAY);
        mode = new SelectMode();
        name="select";
    }
}
