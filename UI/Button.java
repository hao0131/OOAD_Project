package UI;

import javax.swing.*;
import java.awt.*;

public class Button extends JPanel{

    public Button(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;

        JButton select = new JButton(new ImageIcon("./picture/select.png"));
        JButton associationLine = new JButton(new ImageIcon("./picture/associationLine.png"));
        JButton generalizationLine = new JButton(new ImageIcon("./picture/generalizationLine.png"));
        JButton compositionLine = new JButton(new ImageIcon("./picture/compositionLine.png"));
        JButton _class = new JButton(new ImageIcon("./picture/class.png"));
        JButton useCase = new JButton(new ImageIcon("./picture/useCase.png"));

        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(select, c);    
        c.gridy = 1;
        add(associationLine, c);
        c.gridy = 2;
        add(generalizationLine, c);
        c.gridy = 3;
        add(compositionLine, c);
        c.gridy = 4;
        add(_class, c);
        c.gridy = 5;
        add(useCase, c);

    }
}