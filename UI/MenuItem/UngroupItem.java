package UI.MenuItem;

import MenuAction.UngroupAction;

public class UngroupItem extends MenuItemI {
    public UngroupItem(){  
        setText("Ungroup");
        action = new UngroupAction();
    }
}
