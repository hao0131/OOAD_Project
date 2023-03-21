package Object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class UseCase extends BasicObject{

    private Ellipse2D oval;
    
    public UseCase(int x, int y){
        super(x,y);
        width = 100;
        height = 80;
        pNorth = new Point(x + (width / 2), y);
        pEast = new Point(x + width, y + (height / 2));
        pSouth = new Point(x + (width / 2), y + height);
        pWest = new Point(x, y + (height / 2));
        oval = new Ellipse2D.Double(x, y, width, height);
    }

    @Override
    public void updatePosition(int x, int y){
        super.updatePosition(x, y);
        oval.setFrame(x, y, width, height);
    }

    @Override
    public boolean isContain(int mouseX, int mouseY){
        if (oval.contains(mouseX, mouseY)) {
            isDraggable = true;
            return true;
        }
        else{
            isDraggable = false;
            return false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x, y, width, height);
        
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
    }

    

}
