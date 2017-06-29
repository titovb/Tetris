
package backendpack.figurepack;


import backendpack.exceptionpack.MoveException;
import backendpack.Point;
import java.util.ArrayList;
import java.util.List;
import frontendpack.SquarePainter;

public abstract class Figure extends Thread{
    protected List<Point> components;
    protected Point centerForRotate;
    protected int centerIndex;
    protected Point leftUpperPoint;
    protected long speed;
    protected boolean stopped;
    
    public Figure(Point leftUpperPoint){
        this.leftUpperPoint = new Point(leftUpperPoint);
        initComponents();
        centerForRotate = components.get(centerIndex);
        speed = 500;
        stopped = false;
    }
      
      protected abstract void initComponents();
        
    public void moveDown() throws MoveException{
        List<Point> newComponents = null;
        try{
            newComponents = FigureTryingMove.tryToMoveDown(components);
        }catch(MoveException ex){
            throw ex;
        }
        components.clear();
        components.addAll(newComponents);
        centerForRotate = components.get(centerIndex);
    }
      
    public void moveLeft(){
        List<Point> newComponents = null;
        try {
            newComponents = FigureTryingMove.tryToMoveLeft(components);
        } catch (MoveException ex) {
            return;
        }
        components.clear();
        components.addAll(newComponents);
        centerForRotate = components.get(centerIndex);
    }
      
    public void moveRight(){
        List<Point> newComponents = null;
        try {
            newComponents = FigureTryingMove.tryToMoveRight(components);
        } catch (MoveException ex) {
            return;
        }
        components.clear();
        components.addAll(newComponents);
        centerForRotate = components.get(centerIndex);
    }
      
    public void rotate(){
        List<Point> newComponents = null;
        try {
            newComponents = FigureTryingMove.tryToRotate(components, centerForRotate);
        } catch (MoveException ex) {
            return;
        }
        components.clear();
        components.addAll(newComponents);
        centerForRotate = components.get(centerIndex);
    }
    
    public boolean isStopped(){
        return stopped;
    }
    
    public void fastMoveDown(){
        speed = 1;
    }
    
    public List<Point> getComponents(){
        return components;
    }
    
    @Override
    public void run(){
        while(true){
            clearFigure();
            try {
                moveDown();
                paintFigure();
                Thread.sleep(speed);
            } catch (MoveException | InterruptedException ex) {
                paintFigure();
                stopped = true;
                break;
            }
        }
    }
    
    public synchronized void paintFigure(){
        for(int i=0;i<components.size();i++){
            SquarePainter.paint(components.get(i));
        }
    }
    
    public synchronized void clearFigure(){
        for(int i=0;i<components.size();i++){
            SquarePainter.clear(components.get(i));
        }
    }

}















