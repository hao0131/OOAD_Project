package mode;

import java.awt.event.MouseEvent;

import Object.*;

public class ClassMode extends Mode {
    @Override
    public void mousePressed(MouseEvent e) {
        BasicObject myClass = new MyClass(e.getX(), e.getY());
        canvas.basicObject.add(myClass);
    }
}
