package UI.MenuItem;

import MenuAction.ClearAction;

public class ClearItem extends MenuItemI {
    public ClearItem() {
        setText("Clear");
        action = new ClearAction();
    }
}
