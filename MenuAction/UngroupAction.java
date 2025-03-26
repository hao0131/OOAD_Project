package MenuAction;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Object.*;

public class UngroupAction extends MyAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(canvas.selectedComposites.size() == 1){
            for(MyComposite com:canvas.selectedComposites){
                for(BasicObject obj:com.getMemberObjects()){
                    obj.setComposite(false);
                }
                canvas.composites.remove(com);
                canvas.composites.addAll(com.getMemberComposites());
            }
            canvas.selectedComposites.clear();
            canvas.selectedObject.clear();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "請選取一個Composite Object","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}

