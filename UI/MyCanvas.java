package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import Object.*;

public class MyCanvas extends JPanel implements MouseListener, ComponentListener{
    private int width;
    private int height;
    private int mouseClicked_X;
    private int mouseClicked_Y;
    private Image selectedImage;
    private boolean isDrawing;
    private ArrayList<BasicObject> basicObject = new ArrayList<BasicObject>();
    
    public MyCanvas(){
        setBackground(Color.WHITE);
        addMouseListener(this);
        addComponentListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width-1, height-1);

        Graphics2D g2d = (Graphics2D) g;
        if(selectedImage!=null){
            double scaleX = 5;
            double scaleY = 6;
            int w = selectedImage.getWidth(null);
            int h = selectedImage.getHeight(null);
            AffineTransform at = AffineTransform.getTranslateInstance(mouseClicked_X, mouseClicked_Y);
            at.scale(scaleX, scaleY);
            g2d.drawImage(selectedImage, at, null);

            
        }
        //g.drawImage(selectedImage, x, y, null);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.width = getWidth();
        this.height = getHeight();
        setPreferredSize(new Dimension(width, height));
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            mouseClicked_X=e.getX();
            mouseClicked_Y=e.getY();

            if (MyButton.selectedButton.equals("myClass")) {
                selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/class.png");
            } 
            else if (MyButton.selectedButton.equals("useCase")) {
                selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/useCase.png");
            }
            // else if (MyButton.selectedButton.equals("associationLine")) {
            //     selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/associationLine.png");
            // }
            // else if (MyButton.selectedButton.equals("generationLine")) {
            //     selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/generationLine.png");
            // }
            // else if (MyButton.selectedButton.equals("compositionLine")) {
            //     selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/compostionLine.png");
            // }

            isDrawing = true;
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
