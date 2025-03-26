package UI.MenuItem;

import MenuAction.GroupAction;

public class GroupItem extends MenuItemI {
    public GroupItem() {
        setText("Group");
        action = new GroupAction();
    }
}
