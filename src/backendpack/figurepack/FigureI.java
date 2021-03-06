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
public class FigureI extends Figure{

    public FigureI(Point leftUpperPoint) {
        super(leftUpperPoint);
        centerIndex = 2;
    }

    @Override
    protected void initComponents() {
        components = new ArrayList<>();
          
        final int amountComponents = 4;
        for(int numberOfComponent = 0; numberOfComponent < amountComponents; numberOfComponent++){
            Point component = new Point(leftUpperPoint.getX() + SquarePainter.getLENGTH()/2 + SquarePainter.getLENGTH() * numberOfComponent, leftUpperPoint.getY());
            components.add(component);
        }  
    }
    
}
