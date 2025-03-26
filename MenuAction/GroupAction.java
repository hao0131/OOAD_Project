package MenuAction;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Object.*;

public class GroupAction extends MyAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(canvas.selectedObject.size() >= 2){
            MyComposite temp = new MyComposite();
            
            for(BasicObject obj:canvas.selectedObject){
                if(!obj.isComposite){
                    obj.setComposite(true);
                    temp.add(obj);
                }
                
            }
            for(MyComposite com:canvas.selectedComposites){
                temp.add(com);
                canvas.composites.remove(com);
            }
            canvas.composites.add(temp);
            canvas.selectedComposites.clear();
            canvas.selectedComposites.add(temp);
        }
        else{
            JOptionPane.showMessageDialog(null, "請至少選取兩個Object","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}
