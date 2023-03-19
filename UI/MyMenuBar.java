package UI;

import javax.swing.*;

public class MyMenuBar extends JMenuBar{

    public MyMenuBar(){

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem group = new JMenuItem("Group");
        JMenuItem ungroup = new JMenuItem("Ungroup");
        JMenuItem changeObjectName = new JMenuItem("change object name");
        
        file.add(exit);
        edit.add(group);
        edit.add(ungroup);
        edit.add(changeObjectName);
        
        add(file);
        add(edit);

    }
}