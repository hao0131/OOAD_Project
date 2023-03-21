package Object;

import java.awt.*;

public abstract class BasicObject{

    protected int x;
    protected int y;
    protected Point pNorth;
    protected Point pEast;
    protected Point pSouth;
    protected Point pWest;
    protected int width;
    protected int height;
    public boolean isDraggable;
    private int depth;

    public BasicObject(int x, int y){
        this.x = x;
        this.y = y;
        
        isDraggable = false;
    }

    public abstract boolean isContain(int x, int y);
    public abstract void draw(Graphics g);

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void draw_beSelected(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int) pNorth.getX() - 5, (int) pNorth.getY() - 5, 10, 10);
        g.fillRect((int) pEast.getX() - 5, (int) pEast.getY() - 5, 10, 10);
        g.fillRect((int) pSouth.getX() - 5, (int) pSouth.getY() - 5, 10, 10);
        g.fillRect((int) pWest.getX() - 5, (int) pWest.getY() - 5, 10, 10);
    }

    public void drawPoint(Graphics g, Point starPoint){
        g.fillRect((int) starPoint.getX() - 5, (int) starPoint.getY() - 5, 10, 10);
    }
    
    public void updatePosition(int x, int y){
        this.x = x;
        this.y = y;
        pNorth.setLocation(x + (width / 2), y);
        pEast.setLocation(x + width, y + (height / 2));
        pSouth.setLocation(x + (width / 2), y + height);
        pWest.setLocation(x, y + (height / 2));
    }

    public Point findClosestPoint(int x,int y){
        Point[] points = {pNorth, pEast, pSouth, pWest};
        double minDist = Double.MAX_VALUE;
        Point closestPoint = null;
        
        for (Point point : points) {
            double dist = Math.sqrt(Math.pow(x - point.getX(), 2) + Math.pow(y - point.getY(), 2));
            if (dist < minDist) {
                minDist = dist;
                closestPoint = point;
            }
        }
        
        return closestPoint;
    }
    
    
}