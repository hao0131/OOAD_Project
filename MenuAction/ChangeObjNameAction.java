package MenuAction;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Object.*;

public class ChangeObjNameAction extends MyAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(canvas.selectedObject.size() == 0){         
            JOptionPane.showMessageDialog(null, "請至少選取一個Basic Object","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            String input = JOptionPane.showInputDialog("Enter Name:");
            if (input != null && !input.isEmpty()) {
                for(BasicObject obj:canvas.selectedObject){
                    obj.setName(input);
                }
            }
        }
    }
}
