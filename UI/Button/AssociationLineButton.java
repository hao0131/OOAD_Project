package UI.Button;
import java.awt.Color;

import javax.swing.ImageIcon;

import mode.*;
public class AssociationLineButton extends ButtonI{
    
    public AssociationLineButton(String ImagePath) {
        ImageIcon icon = new ImageIcon(ImagePath);
        setIcon(icon);
        setBackground(Color.WHITE);   
        mode = new AssociationLineMode(); 
        name="associaiton";
    }


}
