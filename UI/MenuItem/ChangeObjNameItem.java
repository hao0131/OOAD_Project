package UI.MenuItem;

import MenuAction.ChangeObjNameAction;

public class ChangeObjNameItem extends MenuItemI {
    public ChangeObjNameItem(){
        setText("Change Object Name");
        action = new ChangeObjNameAction();
    }
}
