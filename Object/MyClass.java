package Object;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class MyClass extends BasicObject {
    
    
    private Rectangle rect;

    
    public MyClass(int x, int y){
        super(x,y);
        width = 80;
        height = 90;
        pNorth = new Point(x + (width / 2), y);
        pEast = new Point(x + width, y + (height / 2));
        pSouth = new Point(x + (width / 2), y + height);
        pWest = new Point(x, y + (height / 2));
        rect = new Rectangle(x, y, width, height);      // 建立矩形物件管理邊界
    }

    @Override
    public void updatePosition(int x, int y){
        super.updatePosition(x, y);
        rect.setLocation(x, y);                         // 更新矩形範圍大小

    }

    @Override
    public boolean isContain(int mouseX, int mouseY){
        if (rect.contains(mouseX, mouseY)) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, width, height);

        g.setColor(Color.BLACK);                            //畫出三個格子
        g.drawRect(x, y, width, height/3);
        g.drawRect(x, y + height / 3, width, height/3);
        g.drawRect(x, y + 2*(height / 3), width, height/3);

    }
    
    public void drawName(Graphics g){
        g.setColor(Color.BLACK);
        FontMetrics metrics = g.getFontMetrics();
        int stringWidth = metrics.stringWidth(name);        //name置中
        int stringX = (width - stringWidth) / 2;
        g.drawString(name, x + stringX, y+ (height / 6));
    }
}
