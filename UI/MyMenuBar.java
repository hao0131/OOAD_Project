package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Object.*;

public class MyMenuBar extends JMenuBar implements ActionListener{
    
    public static String selectedItem;

    public MyMenuBar(){

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem group = new JMenuItem("Group");
        JMenuItem ungroup = new JMenuItem("Ungroup");
        JMenuItem changeObjectName = new JMenuItem("change object name");
        
        group.setName("group");
        ungroup.setName("ungroup");
        changeObjectName.setName("changeObjectName");

        group.addActionListener(this);
        ungroup.addActionListener(this);
        changeObjectName.addActionListener(this);

        file.add(exit);
        edit.add(group);
        edit.add(ungroup);
        edit.add(changeObjectName);
        
        add(file);
        add(edit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem clickedItem = (JMenuItem) e.getSource();
        selectedItem = clickedItem.getName();
        MyCanvas canvas = MyCanvas.getInstance();
        if(selectedItem == "group"){
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
        }
        else if(selectedItem == "ungroup"){

        }
        else if(selectedItem == "changeObjectName"){

        }
        canvas.repaint();
    }

}