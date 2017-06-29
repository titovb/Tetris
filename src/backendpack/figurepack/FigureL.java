/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendpack.figurepack;

import backendpack.Point;
import java.util.ArrayList;
import frontendpack.SquarePainter;

/**
 *
 * @author 1
 */
public class FigureL extends Figure{

    public FigureL(Point leftUpperPoint) {
        super(leftUpperPoint);
        centerIndex = 1;
    }

    @Override
    protected void initComponents() {
        components = new ArrayList<>();
          
        Point component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2, leftUpperPoint.getY()+ SquarePainter.getLENGTH());
        components.add(component);
        
        component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2 + SquarePainter.getLENGTH(), leftUpperPoint.getY()+ SquarePainter.getLENGTH());
        components.add(component);
        
        component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2 + SquarePainter.getLENGTH()*2, leftUpperPoint.getY()+ SquarePainter.getLENGTH());
        components.add(component);
        
        component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2 + SquarePainter.getLENGTH()*2, leftUpperPoint.getY());
        components.add(component);
    }
    
}
