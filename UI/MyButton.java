package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JPanel implements ActionListener{
    
    public static boolean selectType;
    public static String selectedButton;
    private JButton lastClickedButton;
    
    public MyButton(){

    
        setLayout(new GridLayout(6,0));

        JButton select = new JButton(new ImageIcon("./picture/select.png"));
        JButton associationLine = new JButton(new ImageIcon("./picture/associationLine.png"));
        JButton generationLine = new JButton(new ImageIcon("./picture/generationLine.png"));
        JButton compositionLine = new JButton(new ImageIcon("./picture/compositionLine.png"));
        JButton myClass = new JButton(new ImageIcon("./picture/class.png"));
        JButton useCase = new JButton(new ImageIcon("./picture/useCase.png"));

        select.setName("select");
        associationLine.setName("associationLine");
        generationLine.setName("generationLine");
        compositionLine.setName("compositionLine");
        myClass.setName("myClass");
        useCase.setName("useCase");

        select.setBackground(Color.DARK_GRAY);
        associationLine.setBackground(Color.WHITE);
        generationLine.setBackground(Color.WHITE);
        compositionLine.setBackground(Color.WHITE);
        myClass.setBackground(Color.WHITE);
        useCase.setBackground(Color.WHITE);

        select.addActionListener(this);
        associationLine.addActionListener(this);
        generationLine.addActionListener(this);
        compositionLine.addActionListener(this);
        myClass.addActionListener(this);
        useCase.addActionListener(this);

        add(select);    
        add(associationLine);
        add(generationLine);
        add(compositionLine);
        add(myClass);
        add(useCase);

        selectType = true;
        lastClickedButton = select;
        selectedButton = "select";
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (lastClickedButton != null) {
            lastClickedButton.setBackground(Color.WHITE);
        }
        clickedButton.setBackground(Color.DARK_GRAY);
        lastClickedButton = clickedButton;

        selectedButton = clickedButton.getName();
        if(selectedButton == "select"){
            selectType = true;
        }
        else{
            selectType = false;
        }
    }
}