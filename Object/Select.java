package Object;

import java.awt.*;

public class Select {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Rectangle rect;

    public Select(Point startPoint, Point endPoint){
        startX = (int)startPoint.getX();
        startY = (int)startPoint.getY();
        endX = (int)endPoint.getX();
        endY = (int)endPoint.getY();

        rect = new Rectangle(startX, startY, endX - startX, endY - startY);
    }

    public void updateEndPoint(Point endPoint){
        int x = (int) endPoint.getX();
        int y = (int) endPoint.getY();
        
        if (x < startX && y < startY) { // 左上
            rect.setRect(x, y, startX - x, startY - y);
        } else if (x < startX && y >= startY) { // 左下
            rect.setRect(x, startY, startX - x, y - startY);
        } else if (x >= startX && y < startY) { // 右上
            rect.setRect(startX, y, x - startX, startY - y);
        } else { // 右下
            rect.setRect(startX, startY, x - startX, y - startY);
        }
    }

    public void drawArea(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK); 
        g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());

        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alpha);

        g2d.setStroke(new BasicStroke());
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());

        g.setColor(Color.BLACK);
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
