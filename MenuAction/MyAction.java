package MenuAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI.MyCanvas;

public abstract class MyAction implements ActionListener{
    MyCanvas canvas;
    public MyAction(){
        canvas = MyCanvas.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
    
}
