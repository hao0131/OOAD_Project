package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AssociationLine extends ConnectionLine{
  
    public AssociationLine(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
        //g.drawLine(endPoint.getX(), endPoint.getY(), endPoint.getX())
    }
}