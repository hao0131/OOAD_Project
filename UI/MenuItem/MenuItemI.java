package UI.MenuItem;

import MenuAction.MyAction;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import mode.Mode;

public class MenuItemI extends JMenuItem{
    public MyAction action;
    public String name;
    public MyAction myGetAction(){
        return action;
    }
}
