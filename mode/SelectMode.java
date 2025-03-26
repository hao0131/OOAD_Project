package mode;

import java.awt.Point;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import Object.*;

public class SelectMode extends Mode {

    public SelectMode() {
    }

    @Override
    public void mousePressed(MouseEvent e) {            //檢查是否有物件被點擊並選擇它，否則開始建立選擇區域
        if (SwingUtilities.isLeftMouseButton(e)) {
            canvas.lastMouseX = e.getX();
            canvas.lastMouseY = e.getY();
            boolean pressOnSomething = false;
            
            System.out.println("selectedComposites:" + canvas.selectedComposites);
            for (MyComposite com : canvas.selectedComposites) {     //檢查是否點擊在已經被選擇的物件上
                if (com.isContain(e.getX(), e.getY())) {        
                    pressOnSomething = true;
                }
            }
            for (BasicObject obj : canvas.selectedObject) {
                if (obj.isContain(e.getX(), e.getY())) {
                    pressOnSomething = true;
                }
            }
            // System.out.println("mode " + mode);
            if (!pressOnSomething) {                                //沒有則清空selected
                canvas.selectedObject.clear();
                canvas.selectedComposites.clear();
            }

            if (!pressOnSomething) {
                for (BasicObject obj : canvas.basicObject)          //重新選被點到的物件
                    if (obj.isContain(e.getX(), e.getY())) { // 選最上面的obj
                        canvas.selectedObject.clear();
                        canvas.selectedObject.add(obj);
                    }

                if (canvas.selectedObject.size() != 0) { // 假如有選到東西(只會有一個obj)
                    if (canvas.selectedObject.get(0).isComposite) { // 檢查obj是不是composite
                        System.out.println("1:" + canvas.selectedObject);
                        for (MyComposite com : canvas.composites) { // 是composite，則找obj是屬於哪一個composite
                            if (com.objectisInComposite(canvas.selectedObject.get(0))) {
                                canvas.selectedComposites.add(com); // 找到了，加入composite加入selected
                                System.out.println("2:" + canvas.selectedObject);
                            }
                            System.out.println("3:" + canvas.selectedObject);

                        }
                        for (MyComposite com : canvas.selectedComposites) {
                            canvas.selectedObject = com.addAllObject();
                            System.out.println("4:" + canvas.selectedObject);
                        }
                    }
                    System.out.println("5:" + canvas.selectedObject);
                    for (BasicObject obj : canvas.selectedObject) {
                        canvas.basicObject.remove(obj); // let the selected obj move to the last,
                        canvas.basicObject.add(obj); // means the mouse is on the object
                    } // the last means the depth is the lowest
                } 
                else { // dragging
                    canvas.startPoint = new Point(e.getX(), e.getY());
                    canvas.endPoint = new Point(e.getX(), e.getY());
                    canvas.draggingArea = new Select(canvas.startPoint, canvas.endPoint);
                }
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(MyComposite com:canvas.composites)
                if(canvas.draggingArea != null && canvas.draggingArea.isContain(com)){
                    canvas.selectedComposites.add(com);
                    canvas.selectedObject.addAll(com.addAllObject());
                    System.out.println("Release1:"+ canvas.selectedObject);
                }
                    
            for(BasicObject obj:canvas.basicObject)
                if(canvas.draggingArea != null && canvas.draggingArea.isContain(obj) && !obj.isComposite)
                canvas.selectedObject.add(obj);
            
            
            for(BasicObject obj:canvas.selectedObject){    //被選到的物件移到最上層
                canvas.basicObject.remove(obj);     
                canvas.basicObject.add(obj);        
            } 

            System.out.println("Release2:"+ canvas.selectedObject);

            canvas.draggingArea = null;
            canvas.startPoint = null;
            canvas.endPoint = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(canvas.selectedObject.size() > 0){
            for(BasicObject obj:canvas.selectedObject){
                obj.updatePosition(obj.getX() + (e.getX() - canvas.lastMouseX), obj.getY() + (e.getY() - canvas.lastMouseY));
            }
            for(MyComposite com:canvas.selectedComposites){
                com.updatePosition(com.getX() + (e.getX() - canvas.lastMouseX), com.getY() + (e.getY() - canvas.lastMouseY));
            } 
            /*if(selectedComposites.size() == 1){
                selectedComposites.get(0).updatePosition(selectedComposites.get(0).getX() + (e.getX() - lastMouseX), selectedComposites.get(0).getY() + (e.getY() - lastMouseY));
            }*/

            canvas.lastMouseX = e.getX();
            canvas.lastMouseY = e.getY();
        }
        else{
            canvas.endPoint = new Point(e.getX(), e.getY());
            canvas.draggingArea.updateEndPoint(canvas.endPoint);
        }
    }
}
