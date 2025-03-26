package UI.Button;

import java.awt.Color;

import javax.swing.ImageIcon;

import mode.*;
public class ClassButton extends ButtonI{
    public ClassButton(String ImagePath) {
        ImageIcon icon = new ImageIcon(ImagePath);
        setIcon(icon);
        setBackground(Color.WHITE);   
        mode = new ClassMode(); 
        name="class";
    }

}
