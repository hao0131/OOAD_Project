package UI;

import javax.swing.*;

import UI.Button.*;
import mode.Mode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JPanel implements ActionListener{
    
    private ButtonI lastClickedButton;
    public Mode mode;
    MyCanvas canvas;

    public MyButton(){

        setLayout(new GridLayout(6,0));

        ButtonI select = new SelectButton("./picture/select.png");
        ButtonI associationLine = new AssociationLineButton("./picture/associationLine.png");
        ButtonI generationLine = new GenerationLineButton("./picture/generationLine.png");
        ButtonI compositionLine = new CompositionLineButton("./picture/compositionLine.png");
        ButtonI myClass = new ClassButton("./picture/class.png");
        ButtonI useCase = new UseCaseButton("./picture/useCase.png");   
        
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

        canvas = MyCanvas.getInstance();
        lastClickedButton = select;
        canvas.mode = select.getMode();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        ButtonI clickedButton = (ButtonI) e.getSource();
        

        if (lastClickedButton != null) {
            lastClickedButton.setBackground(Color.WHITE);
        }
        clickedButton.setBackground(Color.DARK_GRAY);
        lastClickedButton = clickedButton;

        canvas.mode = clickedButton.getMode();
        canvas.selectedComposites.clear();
        canvas.selectedObject.clear();
        canvas.repaint();
    }

}