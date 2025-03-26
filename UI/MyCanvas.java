package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Object.*;
import mode.Mode;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener, ComponentListener{
    private static MyCanvas canvas;
    public int width;                               // 畫布寬度和高度
    public int height;
    public int lastMouseX;                          // 滑鼠上一個座標
    public int lastMouseY;
    public Point startPoint;                        // 畫line時的起始與結束點
    public Point endPoint;
    public BasicObject startObject;                 // 畫line時的起始與結束物件
    public BasicObject endObject;
    public ConnectionLine draggingLine;             // 正在設置的line
    public Select draggingArea;
    public ArrayList<BasicObject> selectedObject;
    public ArrayList<BasicObject> basicObject;
    public ArrayList<ConnectionLine> connectionLine;
    public ArrayList<MyComposite> composites;
    public ArrayList<MyComposite> selectedComposites;
    public Mode mode;

    private MyCanvas(){
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        addComponentListener(this);

        selectedObject = new ArrayList<BasicObject>();
        basicObject = new ArrayList<BasicObject>();
        connectionLine = new ArrayList<ConnectionLine>();
        composites = new ArrayList<MyComposite>();
        selectedComposites = new ArrayList<MyComposite>();
    }

    public static MyCanvas getInstance(){
        if(canvas == null){
            canvas = new MyCanvas();
        }
        return canvas;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width-1, height-1);    //畫canvas的邊界
        
        for(BasicObject obj: basicObject){          //畫 class, usecase, composition等物件
            obj.draw(g);
            obj.drawName(g);
            if(selectedObject.contains(obj))        //物件被選到畫四個點
                obj.draw_beSelected(g);
        }

        for(ConnectionLine line:connectionLine){
            line.draw(g);
        }
        
        if(startObject != null){
            startObject.drawPoint(g, startPoint);
        }

        if(endObject != null){
            endObject.drawPoint(g, endPoint);
        }

        if(selectedComposites != null)
            for(MyComposite com:selectedComposites)
                com.draw_beSelected(g);

        if(draggingArea != null){
            draggingArea.drawArea(g);
        }
        

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            mode.mousePressed(e);
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mode.mouseReleased(e);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mode.mouseDragged(e);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void componentResized(ComponentEvent e) {        //更改視窗大小同步更新畫布大小
        this.width = getWidth();
        this.height = getHeight();
        setPreferredSize(new Dimension(width, height));
        repaint();
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