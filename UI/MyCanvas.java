package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import Object.*;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener, ComponentListener{
    private int width;
    private int height;
    private int mouseX;
    private int mouseY;
    private int lastMouseX;
    private int lastMouseY;
    private Point startPoint;
    private Point endPoint;
    private BasicObject selectedObject;
    private BasicObject startObject;
    private BasicObject endObject;
    private ConnectionLine drawingLine;
    private ArrayList<BasicObject> basicObject = new ArrayList<BasicObject>();
    private ArrayList<ConnectionLine> connectionLine = new ArrayList<ConnectionLine>();

    public MyCanvas(){
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        addComponentListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width-1, height-1);

        for(ConnectionLine line:connectionLine){
            line.draw(g);
        }

        for(BasicObject obj: basicObject){
            obj.draw(g);
        }
        
        if(startObject != null){
            startObject.drawPoint(g, startPoint);
        }

        if(endObject != null){
            endObject.drawPoint(g, endPoint);
        }

        if(selectedObject != null && MyButton.selectType){
            selectedObject.draw_beSelected(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            mouseX=e.getX();
            mouseY=e.getY();
            if (MyButton.selectedButton.equals("select")) {
            }
            else if (MyButton.selectedButton.equals("myClass")) {
                //selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/class.png");
                BasicObject myClass = new MyClass(mouseX, mouseY);
                basicObject.add(myClass);
            } 
            else if (MyButton.selectedButton.equals("useCase")) {
                // selectedImage = Toolkit.getDefaultToolkit().getImage("./picture/useCase.png");
                BasicObject useCase = new UseCase(mouseX, mouseY);
                basicObject.add(useCase);
            }
                   
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (MyButton.selectedButton.equals("select")){ 
            BasicObject obj = null;
            for(BasicObject o:basicObject){
                if(o.isContain(e.getX(), e.getY())){
                    selectedObject = o;
                    lastMouseX = e.getX();
                    lastMouseY = e.getY();
                    obj = o;
                }
            }
            if(obj != null){                            // means the mouse is on the object
                basicObject.remove(selectedObject);     // let the selected obj move to the last,    
                basicObject.add(selectedObject);        // the last means the depth is the lowest
            }
            else{
                selectedObject = null;
            }
        }
        else if(MyButton.selectedButton.equals("associationLine")){
            for(BasicObject obj:basicObject){
                if(obj.isContain(e.getX(), e.getY())){
                    startObject = obj;
                }
            }
            if(startObject != null){
                startPoint = startObject.findClosestPoint(e.getX(), e.getY());
                endPoint = new Point(e.getX(), e.getY());
                drawingLine = new AssociationLine(startPoint, endPoint);
                connectionLine.add(drawingLine);
            }
        }
        repaint();

        //System.out.println(selectedObject);
    }

    @Override
    public void mouseReleased(MouseEvent e) {    
        if(MyButton.selectedButton.equals("associationLine")){
            if(startObject != null){
                for(BasicObject obj:basicObject){
                    if(obj.isContain(e.getX(), e.getY()) && obj != startObject){
                        endObject = obj;
                    }
                }
                if(endObject != null){
                    endPoint = endObject.findClosestPoint(e.getX(), e.getY());
                    drawingLine.updateEndPoint(endPoint);
                    drawingLine = null;
                }
                else{
                    connectionLine.remove(drawingLine);
                }
                startObject = null;
                endObject = null;
            }
            
        }
        
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
        //System.out.println(selectedObject);
        if (selectedObject != null &&  MyButton.selectedButton.equals("select")){
            mouseX=e.getX();
            mouseY=e.getY();
            selectedObject.updatePosition(selectedObject.getX() + (mouseX - lastMouseX), selectedObject.getY() + (mouseY - lastMouseY));

            lastMouseX = e.getX();
            lastMouseY = e.getY();   
        }
        else if(MyButton.selectedButton.equals("associationLine")){
            if(startObject != null){
                endObject = null;
                for(BasicObject obj:basicObject){
                    if(obj.isContain(e.getX(), e.getY()) && obj != startObject){
                        endObject = obj;
                    }
                }
                if(endObject != null){
                    endPoint = endObject.findClosestPoint(e.getX(), e.getY());
                }
                else{
                    endPoint = new Point(e.getX(), e.getY());
                    
                }
                drawingLine.updateEndPoint(endPoint);
                
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void componentResized(ComponentEvent e) {
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
