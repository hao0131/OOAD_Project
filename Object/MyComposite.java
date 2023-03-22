package Object;

import java.awt.*;

public class MyComposite {

    private Point startPoint;
    private Point endPoint;
    private MyComposite composite;
    private BasicObject basicObject;

    public MyComposite(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    public void addMember(MyComposite composite){

    }
    
    public void addMember(BasicObject basicObject){

    }

    public void drawArea(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.drawRect((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());    

        g2d.setStroke(new BasicStroke());
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
    }
}
