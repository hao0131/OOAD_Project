package Object;

import java.awt.*;
import java.util.ArrayList;

public class MyComposite {

    private Point startPoint;
    private Point endPoint;
    private ArrayList<MyComposite> composites;
    private ArrayList<BasicObject> basicObjects;

    public MyComposite(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        composites = new ArrayList<>();
        basicObjects = new ArrayList<>();
    }
    
    public void add(MyComposite composite){
        composites.add(composite);
    }
    
    public void add(BasicObject basicObject){
        basicObjects.add(basicObject);
    }

    // public void drawArea(Graphics g){
    //     Graphics2D g2d = (Graphics2D) g;
    //     g2d.setStroke(new BasicStroke(3));
    //     g.setColor(Color.BLACK);
    //     g.drawRect((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());    

    //     g2d.setStroke(new BasicStroke());
    //     g.setColor(Color.LIGHT_GRAY);
    //     g.fillRect((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
    // }
}
