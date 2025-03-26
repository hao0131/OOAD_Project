package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import Object.*;

public class AssociationLineMode extends Mode{
    @Override
    public void mousePressed(MouseEvent e) {
        for(BasicObject obj:canvas.basicObject){
            if(obj.isContain(e.getX(), e.getY())){
                canvas.startObject = obj;
            }
        }
        if(canvas.startObject != null){
            canvas.startPoint = canvas.startObject.findClosestPoint(e.getX(), e.getY());
            canvas.endPoint = new Point(e.getX(), e.getY());
            canvas.draggingLine = new AssociationLine(canvas.startPoint, canvas.endPoint);
            canvas.connectionLine.add(canvas.draggingLine);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(canvas.startObject != null){
            for(BasicObject obj:canvas.basicObject){
                if(obj.isContain(e.getX(), e.getY()) && obj != canvas.startObject){
                    canvas.endObject = obj;
                }
            }
            if(canvas.endObject != null){
                canvas.endPoint = canvas.endObject.findClosestPoint(e.getX(), e.getY());
                canvas.draggingLine.updateEndPoint(canvas.endPoint);
                canvas.draggingLine = null;
            }
            else{
                canvas.connectionLine.remove(canvas.draggingLine);
            }
            canvas.startObject = null;
            canvas.endObject = null;
            canvas.startPoint = null;
            canvas.endPoint = null;
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        canvas.endObject = null;
        if(canvas.startObject != null){
            for(BasicObject obj:canvas.basicObject){
                if(obj.isContain(e.getX(), e.getY()) && obj != canvas.startObject){
                    canvas.endObject = obj;
                }
            }
            if(canvas.endObject != null){
                canvas.endPoint = canvas.endObject.findClosestPoint(e.getX(), e.getY());
            }
            else{
                canvas.endPoint = new Point(e.getX(), e.getY());
            }
            canvas.draggingLine.updateEndPoint(canvas.endPoint);
        }
    }
}
