import javax.swing.*;
import java.awt.*;

public class UMLEditor {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UMLEditor().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("UML Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);

        JMenuBar menuBar = new JMenuBar();

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
        
        menuBar.add(file);
        menuBar.add(edit);

        frame.setJMenuBar(menuBar);

        
        JPanel panel = new JPanel(new GridBagLayout());
        
        //panel.setLayout(new GridBagLayout());

        JButton select = new JButton(new ImageIcon("select.png"));
        JButton associationLine = new JButton(new ImageIcon("associationLine.png"));
        JButton generalizationLine = new JButton(new ImageIcon("generalizationLine.png"));
        JButton compositionLine = new JButton(new ImageIcon("compositionLine.png"));
        JButton _class = new JButton(new ImageIcon("class.png"));
        JButton useCase = new JButton(new ImageIcon("useCase.png"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(select, gbc);    
        gbc.gridy = 1;
        panel.add(associationLine, gbc);
        gbc.gridy = 2;
        panel.add(generalizationLine, gbc);
        gbc.gridy = 3;
        panel.add(compositionLine, gbc);
        gbc.gridy = 4;
        panel.add(_class, gbc);
        gbc.gridy = 5;
        panel.add(useCase, gbc);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}