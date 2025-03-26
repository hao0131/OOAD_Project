package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import MenuAction.MyAction;
import Object.*;
import UI.MenuItem.ChangeObjNameItem;
import UI.MenuItem.ClearItem;
import UI.MenuItem.GroupItem;
import UI.MenuItem.MenuItemI;
import UI.MenuItem.UngroupItem;

public class MyMenuBar extends JMenuBar implements ActionListener{
    
    public static String selectedItem;
    Action action;

    public MyMenuBar(){

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        MenuItemI clear = new ClearItem();
        MenuItemI group = new GroupItem();
        MenuItemI ungroup = new UngroupItem();
        MenuItemI changeObjectName = new ChangeObjNameItem();
        
        /*clear.setName("clear");
        group.setName("group");
        ungroup.setName("ungroup");
        changeObjectName.setName("changeObjectName");*/
        
        clear.addActionListener(this);
        group.addActionListener(this);
        ungroup.addActionListener(this);
        changeObjectName.addActionListener(this);

        file.add(clear);
        edit.add(group);
        edit.add(ungroup);
        edit.add(changeObjectName);
        
        add(file);
        add(edit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyCanvas canvas = MyCanvas.getInstance();
        
        MenuItemI clickedItem = (MenuItemI) e.getSource();
        MyAction action = clickedItem.myGetAction();
        action.actionPerformed(e);
        /*selectedItem = clickedItem.getName();
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
            else{
                JOptionPane.showMessageDialog(null, "請至少選取兩個Object","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(selectedItem == "ungroup"){
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
        else if(selectedItem == "changeObjectName"){
            if(canvas.selectedObject.size() == 0){         
                JOptionPane.showMessageDialog(null, "請至少選取一個Basic Object","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                String input = JOptionPane.showInputDialog("Enter Name:");
                if (input != null && !input.isEmpty()) {
                    for(BasicObject obj:canvas.selectedObject){
                        obj.setName(input);
                    }
                }
            }
        }
        else if(selectedItem == "clear"){
            canvas.basicObject.clear();
            canvas.composites.clear();
            canvas.selectedObject.clear();
            canvas.selectedComposites.clear();
            canvas.connectionLine.clear();
        }*/
        canvas.repaint();
    }

}