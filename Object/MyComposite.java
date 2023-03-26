package Object;

import java.awt.*;
import java.util.ArrayList;

public class MyComposite{
    
    private int mostLeft;
    private int mostUp;
    private int mostRight;
    private int mostDown;
    private ArrayList<MyComposite> composites;
    private ArrayList<BasicObject> basicObjects;
    private Rectangle rect;
    public boolean isDraggable;

    public MyComposite(){
        mostLeft = 800;
        mostUp = 550;
        mostRight = 0;
        mostDown = 0;
        composites = new ArrayList<>();
        basicObjects = new ArrayList<>();
        rect = new Rectangle(mostLeft, mostUp, mostRight - mostLeft, mostDown - mostUp);
    }
    
    public int getX(){
        return mostLeft;
    }
    
    public int getY(){
        return mostUp;
    }

    public int getWidth(){
        return mostRight - mostLeft;
    }
    
    public int getHeight(){
        return mostDown - mostUp;
    }

    public void add(MyComposite composite){
        this.composites.add(composite);
        calculatePoint(composite.getX(), composite.getY(), composite.getWidth(), composite.getHeight());
    }
    
    public void add(BasicObject basicObject){
        this.basicObjects.add(basicObject);
        calculatePoint(basicObject.getX(), basicObject.getY(), basicObject.getWidth(), basicObject.getHeight());
    }

    public ArrayList<BasicObject> addAllObject(){
        ArrayList<BasicObject> basicObjects = new ArrayList<>();
        basicObjects.addAll(this.basicObjects);
        System.out.println("com 1:"+basicObjects);
        for(MyComposite com:composites){
            basicObjects.addAll(com.addAllObject());
            System.out.println("com 2:"+basicObjects);
        }
            
        return basicObjects;
    }

    private void calculatePoint(int x, int y, int width, int height){
        if(mostLeft > x)
            mostLeft = x;
        if(mostUp > y)
            mostUp = y;
        if(mostRight < (x + width))
            mostRight = x + width;
        if(mostDown < (y + height))
            mostDown = y + height;
    }

    public boolean objectisInComposite(BasicObject object){
        boolean result = false;
        for(BasicObject obj:basicObjects)
            if(obj == object)
                return true;

        for(MyComposite com:composites){
            result = com.objectisInComposite(object);
            if(result)
                return result;
        }

        return result;
    }

    public void draw_beSelected(Graphics g){
        for(MyComposite com:composites){
            com.draw_beSelected(g);
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawRect(mostLeft, mostUp, mostRight - mostLeft, mostDown - mostUp);    

        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
        g2d.setComposite(alpha);

        g2d.setStroke(new BasicStroke());
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(mostLeft, mostUp, mostRight - mostLeft, mostDown - mostUp);

        alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g2d.setComposite(alpha);
    }

    public boolean isContain(int mouseX, int mouseY) {
        if (rect.contains(mouseX, mouseY)) {
            isDraggable = true;
            return true;
        }
        else{
            isDraggable = false;
            return false;
        }
    }

    public void updatePosition(int x, int y){
        for(MyComposite com:composites){
            com.updatePosition(x - mostLeft + com.mostLeft, y - mostUp + com.mostUp);
        }
        mostRight = x + (mostRight - mostLeft);
        mostDown = y + (mostDown - mostUp); 
        mostLeft = x;
        mostUp = y;
    }
}
