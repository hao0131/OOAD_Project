import javax.swing.*;
import java.awt.*;
import UI.*;

public class UMLEditor {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new JFrame("UML Editor");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800,550);
                frame.setLocation(400, 100);
        
                //frame.getContentPane().setLayout(new BorderLayout());
                
                frame.getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
                frame.getContentPane().add(new MyButton(), BorderLayout.WEST);
                frame.setJMenuBar(new MyMenuBar());
                //frame.pack();
                frame.setVisible(true);
            }
        });
    }
}