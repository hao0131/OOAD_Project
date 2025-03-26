package UI.Button;
import java.awt.Color;

import javax.swing.ImageIcon;

import mode.*;
public class CompositionLineButton extends ButtonI{
    public CompositionLineButton(String ImagePath) {
        ImageIcon icon = new ImageIcon(ImagePath);
        setIcon(icon);
        setBackground(Color.WHITE); 
        mode = new CompostionLineMode();
        name="composition";
    }

}