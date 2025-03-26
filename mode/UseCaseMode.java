package mode;

import java.awt.event.MouseEvent;

import Object.*;

public class UseCaseMode extends Mode {
    @Override
    public void mousePressed(MouseEvent e) {
        BasicObject useCase = new UseCase(e.getX(), e.getY());
        canvas.basicObject.add(useCase);
    }
}
