package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCanvas extends JPanel implements MouseListener, ComponentListener{
    private int width;
    private int height;
    private int x;
    private int y;
    private Image image;
    private boolean isDrawing;

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
        if(image!=null){
            g.drawImage(image, x, y, null);
        }
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
            x=e.getX();
            y=e.getY();

            image = Toolkit.getDefaultToolkit().getImage("./picture/class.png");
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
