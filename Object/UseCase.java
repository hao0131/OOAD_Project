package Object;

import java.awt.Graphics;

public class useCase {
    
    public int mouseClicked_X;
    public int mouseClicked_Y;
    private int width = 100;
    private int height = 80;

    public useCase(int mouseClicked_X, int mouseClicked_Y){
        this.mouseClicked_X = mouseClicked_X;
        this.mouseClicked_Y = mouseClicked_Y;
    }

    public void draw(Graphics g){
        g.drawOval(mouseClicked_X, mouseClicked_Y, width, height);
    }

}
