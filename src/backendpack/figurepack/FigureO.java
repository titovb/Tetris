
package backendpack.figurepack;

import backendpack.Point;
import java.util.ArrayList;
import frontendpack.SquarePainter;

public class FigureO extends Figure{

    public FigureO(Point leftUpperPoint) {
        super(leftUpperPoint);
        centerIndex = 0;
    }

    @Override
    protected void initComponents() {
        components = new ArrayList<>();
          
        Point component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2, leftUpperPoint.getY());
        components.add(component);
        
        component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2, leftUpperPoint.getY()+ SquarePainter.getLENGTH());
        components.add(component);
        
        component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2 + SquarePainter.getLENGTH(), leftUpperPoint.getY());
        components.add(component);
        
        component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2 + SquarePainter.getLENGTH(), leftUpperPoint.getY() + SquarePainter.getLENGTH());
        components.add(component);
    }
    
    @Override
    public void rotate(){
        
    }
    
}
