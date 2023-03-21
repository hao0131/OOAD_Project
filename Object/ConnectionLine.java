package Object;

import java.awt.*;

public abstract class ConnectionLine {
    protected Point startPoint;
    protected Point endPoint;

    public ConnectionLine(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    public abstract void draw(Graphics g);
    
    public void updateEndPoint(Point endPoint){
        this.endPoint = endPoint;
    }
}
