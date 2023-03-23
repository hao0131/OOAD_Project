package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Object.*;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener, ComponentListener{
    private int width;
    private int height;
    private int lastMouseX;
    private int lastMouseY;
    private Point startPoint;
    private Point endPoint;
    private BasicObject selectedObject;
    private BasicObject startObject;
    private BasicObject endObject;
    private ConnectionLine draggingLine;
    private Select draggingArea;
    public static ArrayList<BasicObject> groupSelectedObject;
    private ArrayList<BasicObject> basicObject;
    private ArrayList<ConnectionLine> connectionLine;
    public static ArrayList<MyComposite> composites;

    public MyCanvas(){
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        addComponentListener(this);

        groupSelectedObject = new ArrayList<BasicObject>();
        basicObject = new ArrayList<BasicObject>();
        connectionLine = new ArrayList<ConnectionLine>();
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

        if(selectedObject != null && MyButton.TypeisSelect){
            selectedObject.draw_beSelected(g);
        }
        
        if(groupSelectedObject != null && MyButton.TypeisSelect){
            for(BasicObject obj:groupSelectedObject)
                obj.draw_beSelected(g);
        }

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
            selectedObject = null;
            groupSelectedObject.clear();

            if (MyButton.selectedButton.equals("select")) {
                for(BasicObject obj:basicObject){
                    if(obj.isContain(e.getX(), e.getY())){
                        selectedObject = obj;
                        lastMouseX = e.getX();
                        lastMouseY = e.getY();
                    }
                }
                if(selectedObject != null){                 // means the mouse is on the object
                    basicObject.remove(selectedObject);     // let the selected obj move to the last,    
                    basicObject.add(selectedObject);        // the last means the depth is the lowest
                }
                else{                                       //dragging 
                    startPoint = new Point(e.getX(), e.getY());
                    endPoint = new Point(e.getX(), e.getY());
                    draggingArea = new Select(startPoint, endPoint);
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
                    draggingLine = new AssociationLine(startPoint, endPoint);
                    connectionLine.add(draggingLine);
                }
            }
            else if(MyButton.selectedButton.equals("generationLine")){
                for(BasicObject obj:basicObject){
                    if(obj.isContain(e.getX(), e.getY())){
                        startObject = obj;
                    }
                }
                if(startObject != null){
                    startPoint = startObject.findClosestPoint(e.getX(), e.getY());
                    endPoint = new Point(e.getX(), e.getY());
                    draggingLine = new GenerationLine(startPoint, endPoint);
                    connectionLine.add(draggingLine);
                }
            }
            else if(MyButton.selectedButton.equals("compositionLine")){
                for(BasicObject obj:basicObject){
                    if(obj.isContain(e.getX(), e.getY())){
                        startObject = obj;
                    }
                }
                if(startObject != null){
                    startPoint = startObject.findClosestPoint(e.getX(), e.getY());
                    endPoint = new Point(e.getX(), e.getY());
                    draggingLine = new CompositionLine(startPoint, endPoint);
                    connectionLine.add(draggingLine);
                }
            }
            else if (MyButton.selectedButton.equals("myClass")) {
                BasicObject myClass = new MyClass(e.getX(), e.getY());
                basicObject.add(myClass);
            } 
            else if (MyButton.selectedButton.equals("useCase")) {
                BasicObject useCase = new UseCase(e.getX(), e.getY());
                basicObject.add(useCase);
            }
        
            repaint();
        }
        //System.out.println(selectedObject);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(MyButton.selectedButton.equals("select")){
            for(BasicObject obj:basicObject){
                if(draggingArea.isContain(obj)){
                    groupSelectedObject.add(obj);
                }
            }

            draggingArea = null;
            startPoint = null;
            endPoint = null;
        }
        else if(MyButton.selectedButton.equals("associationLine") || MyButton.selectedButton.equals("generationLine") || MyButton.selectedButton.equals("compositionLine")){
            if(startObject != null){
                for(BasicObject obj:basicObject){
                    if(obj.isContain(e.getX(), e.getY()) && obj != startObject){
                        endObject = obj;
                    }
                }
                if(endObject != null){
                    endPoint = endObject.findClosestPoint(e.getX(), e.getY());
                    draggingLine.updateEndPoint(endPoint);
                    draggingLine = null;
                }
                else{
                    connectionLine.remove(draggingLine);
                }
                startObject = null;
                endObject = null;
                startPoint = null;
                endPoint = null;
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
        if (MyButton.selectedButton.equals("select")){
            if(selectedObject != null){
                selectedObject.updatePosition(selectedObject.getX() + (e.getX() - lastMouseX), selectedObject.getY() + (e.getY() - lastMouseY));

                lastMouseX = e.getX();
                lastMouseY = e.getY();  
            }
            else{
                endPoint = new Point(e.getX(), e.getY());
                draggingArea.updateEndPoint(endPoint);
            }
        }
        else if(MyButton.selectedButton.equals("associationLine") || MyButton.selectedButton.equals("generationLine") || MyButton.selectedButton.equals("compositionLine")){
            if(startObject != null){
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
                draggingLine.updateEndPoint(endPoint);
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
