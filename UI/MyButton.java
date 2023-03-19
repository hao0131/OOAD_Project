package UI;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JPanel{

    public MyButton(){

        setLayout(new GridLayout(10,0));

        JButton select = new JButton(new ImageIcon("./picture/select.png"));
        JButton associationLine = new JButton(new ImageIcon("./picture/associationLine.png"));
        JButton generationLine = new JButton(new ImageIcon("./picture/generationLine.png"));
        JButton compositionLine = new JButton(new ImageIcon("./picture/compositionLine.png"));
        JButton myClass = new JButton(new ImageIcon("./picture/class.png"));
        JButton useCase = new JButton(new ImageIcon("./picture/useCase.png"));

        select.setBackground(Color.WHITE);
        associationLine.setBackground(Color.WHITE);
        generationLine.setBackground(Color.WHITE);
        compositionLine.setBackground(Color.WHITE);
        myClass.setBackground(Color.WHITE);
        useCase.setBackground(Color.WHITE);

        add(select);    
        add(associationLine);
        add(generationLine);
        add(compositionLine);
        add(myClass);
        add(useCase);
    }
}