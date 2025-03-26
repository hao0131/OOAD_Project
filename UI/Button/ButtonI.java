package UI.Button;

import javax.swing.JButton;

import mode.Mode;

public class ButtonI extends JButton{
    public Mode mode;
    public String name;
    public Mode getMode(){
        System.out.println("mode is "+name);
        return mode;
    }
}
