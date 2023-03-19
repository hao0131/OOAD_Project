package UI;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JPanel{

    public MyButton(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;

        JButton select = new JButton(new ImageIcon("./picture/select.png"));
        JButton associationLine = new JButton(new ImageIcon("./picture/associationLine.png"));
        JButton generationLine = new JButton(new ImageIcon("./picture/generationLine.png"));
        JButton compositionLine = new JButton(new ImageIcon("./picture/compositionLine.png"));
        JButton myClass = new JButton(new ImageIcon("./picture/class.png"));
        JButton useCase = new JButton(new ImageIcon("./picture/useCase.png"));

        select.setBackground(Color.GRAY);
        associationLine.setBackground(Color.GRAY);
        generationLine.setBackground(Color.GRAY);
        compositionLine.setBackground(Color.GRAY);
        myClass.setBackground(Color.GRAY);
        useCase.setBackground(Color.GRAY);

        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(select, c);    
        c.gridy = 1;
        add(associationLine, c);
        c.gridy = 2;
        add(generationLine, c);
        c.gridy = 3;
        add(compositionLine, c);
        c.gridy = 4;
        add(myClass, c);
        c.gridy = 5;
        add(useCase, c);

    }
}