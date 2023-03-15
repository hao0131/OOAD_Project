import javax.swing.*;
import UI.*;

public class UMLEditor {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                JFrame frame = new JFrame("UML Editor");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600,500);
                
                frame.getContentPane().add(new Button());
                frame.setJMenuBar(new MenuBar());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}