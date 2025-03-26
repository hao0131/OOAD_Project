package MenuAction;

import java.awt.event.ActionEvent;

public class ClearAction extends MyAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        canvas.basicObject.clear();
        canvas.composites.clear();
        canvas.selectedObject.clear();
        canvas.selectedComposites.clear();
        canvas.connectionLine.clear();
    }
}
