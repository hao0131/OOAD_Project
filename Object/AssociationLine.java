package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class AssociationLine extends ConnectionLine{
  
    public AssociationLine(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.drawLine((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
        
        AffineTransform save = g2d.getTransform();          //保存畫布當前狀態(不要跟著箭頭一起旋轉)

        g2d.translate(endPoint.getX(), endPoint.getY());
        
        double dx = endPoint.getX() - startPoint.getX();
        double dy = endPoint.getY() - startPoint.getY();

        double angle = Math.atan2(dy, dx);
        g2d.rotate(angle);

        GeneralPath line = new GeneralPath();
        line.moveTo(0, 0);
        line.lineTo(-15, -10);
        line.moveTo(0, 0);
        line.lineTo(-15, 10);
        g2d.draw(line);

        g2d.setTransform(save);                             //恢復畫布狀態
    }
}