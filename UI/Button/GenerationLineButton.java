package UI.Button;
import java.awt.Color;

import javax.swing.ImageIcon;

import mode.*;

public class GenerationLineButton extends ButtonI {
    public GenerationLineButton(String ImagePath) {
        ImageIcon icon = new ImageIcon(ImagePath);
        setIcon(icon);
        setBackground(Color.WHITE);    
        mode = new GenerationLineMode();
        name="generation";
    }

}
