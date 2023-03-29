package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Object.*;

public class MyCanvas extends JPanel implements MouseListener, MouseMotionListener, ComponentListener{
    public static MyCanvas canvas;
    private int width;
    private int height;
    private int lastMouseX;
    private int lastMouseY;
    private Point startPoint;
    private Point endPoint;
    private BasicObject startObject;
    private BasicObject endObject;
    private ConnectionLine draggingLine;
    private Select draggingArea;
    public ArrayList<BasicObject> selectedObject;
    public ArrayList<BasicObject> basicObject;
    public ArrayList<ConnectionLine> connectionLine;
    public ArrayList<MyComposite> composites;
    public ArrayList<MyComposite> selectedComposites;

    public MyCanvas(){
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
        g.drawRect(0, 0, width-1, height-1);
        
        
       

        for(BasicObject obj: basicObject){
            obj.draw(g);
            obj.drawName(g);
            if(selectedObject.contains(obj))
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
        
        /*if(selectedObject != null){
            for(BasicObject obj:selectedObject)
                obj.draw_beSelected(g);
        }*/

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
            int mode = 0;
            System.out.println("selectedComposites:"+selectedComposites);
            for(MyComposite com:selectedComposites){
                if(com.isContain(e.getX(), e.getY())){
                    mode = 1;
                }
            }
            for(BasicObject obj:selectedObject){
                if(obj.isContain(e.getX(), e.getY())){
                    mode = 1;
                }
            }
            System.out.println("mode " + mode);
            if(mode == 0){
                selectedObject.clear();
                selectedComposites.clear();
            }
            if (MyButton.selectedButton.equals("select")) {
                lastMouseX = e.getX();
                lastMouseY = e.getY();

                if(mode == 0){
                    for(BasicObject obj:basicObject)
                        if(obj.isContain(e.getX(), e.getY())){  //選最上面的obj
                            selectedObject.clear();
                            selectedObject.add(obj);
                        }
                            
                    if(selectedObject.size() != 0){                         //有選到東西(只會有一個obj)
                        if(selectedObject.get(0).isComposite){        //檢查obj是不是composite
                            System.out.println("1:"+selectedObject);
                            for(MyComposite com:composites){                //是composite，則找obj是屬於哪一個composite
                                if(com.objectisInComposite(selectedObject.get(0))){
                                    selectedComposites.add(com);            //找到了，加入composite加入selected
                                    System.out.println("2:"+selectedObject);
                                }
                                System.out.println("3:"+selectedObject);
                                    
                            }
                            for(MyComposite com:selectedComposites){
                                selectedObject = com.addAllObject();
                                System.out.println("4:"+selectedObject);
                            }
                        }
                        System.out.println("5:"+selectedObject);
                        for(BasicObject obj:selectedObject){
                            basicObject.remove(obj);     // let the selected obj move to the last,    
                            basicObject.add(obj);        // means the mouse is on the object
                        }                                // the last means the depth is the lowest              
                    }
                    else{                                       //dragging 
                        startPoint = new Point(e.getX(), e.getY());
                        endPoint = new Point(e.getX(), e.getY());
                        draggingArea = new Select(startPoint, endPoint);
                    }
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
            for(MyComposite com:composites)
                if(draggingArea != null && draggingArea.isContain(com)){
                    selectedComposites.add(com);
                    selectedObject.addAll(com.addAllObject());
                    System.out.println("Release1:"+ selectedObject);
                }
                    
            for(BasicObject obj:basicObject)
                if(draggingArea != null && draggingArea.isContain(obj) && !obj.isComposite)
                    selectedObject.add(obj);
            
            
            for(BasicObject obj:selectedObject){    //被選到的物件移到最上層
                basicObject.remove(obj);     
                basicObject.add(obj);        
            } 

            System.out.println("Release2:"+ selectedObject);

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
            if(selectedObject.size() > 0){
                for(BasicObject obj:selectedObject){
                    obj.updatePosition(obj.getX() + (e.getX() - lastMouseX), obj.getY() + (e.getY() - lastMouseY));
                }
                for(MyComposite com:selectedComposites){
                    com.updatePosition(com.getX() + (e.getX() - lastMouseX), com.getY() + (e.getY() - lastMouseY));
                } 
                /*if(selectedComposites.size() == 1){
                    selectedComposites.get(0).updatePosition(selectedComposites.get(0).getX() + (e.getX() - lastMouseX), selectedComposites.get(0).getY() + (e.getY() - lastMouseY));
                }*/

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
