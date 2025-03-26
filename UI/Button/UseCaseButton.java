package UI.Button;

import java.awt.Color;

import javax.swing.ImageIcon;

import mode.*;
public class UseCaseButton extends ButtonI{
    public UseCaseButton(String ImagePath) {
        ImageIcon icon = new ImageIcon(ImagePath);
        setIcon(icon);
        setBackground(Color.WHITE);   
        mode = new UseCaseMode(); 
        name="Usecase";
    }

}
