package Object;

import java.awt.*;
import java.util.ArrayList;

public class Select {

    private Point startPoint;
    private Point endPoint;
    private Rectangle rect;

    public Select(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        rect = new Rectangle((int)startPoint.getX(), (int)startPoint.getY(), (int)(endPoint.getX() - startPoint.getX()), (int)(endPoint.getY() - startPoint.getY()));
    }

    public void updateEndPoint(Point endPoint){
        this.endPoint = endPoint;
        rect.setRect((int)startPoint.getX(), (int)startPoint.getY(), (int)(endPoint.getX() - startPoint.getX()), (int)(endPoint.getY() - startPoint.getY()));
    }

    public void drawArea(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawRect((int)startPoint.getX(), (int)startPoint.getY(), (int)(endPoint.getX() - startPoint.getX()), (int)(endPoint.getY() - startPoint.getY()));    

        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alpha);

        g2d.setStroke(new BasicStroke());
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int)startPoint.getX(), (int)startPoint.getY(), (int)(endPoint.getX() - startPoint.getX()), (int)(endPoint.getY() - startPoint.getY()));
    }

    public boolean isContain(BasicObject basicObject){
        int x = basicObject.getX();
        int y = basicObject.getY();
        int w = basicObject.getWidth();
        int h = basicObject.getHeight();
        
        return rect.contains(x, y, w, h);
    }
    public boolean isContain(MyComposite composite){
        int x = composite.getX();
        int y = composite.getY();
        int w = composite.getWidth();
        int h = composite.getHeight();
        
        return rect.contains(x, y, w, h);
    }
}
