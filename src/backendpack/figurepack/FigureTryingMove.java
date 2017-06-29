/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendpack.figurepack;

import backendpack.exceptionpack.MoveException;
import backendpack.Point;
import java.util.List;
import java.util.ArrayList;
import tetrispack.Main;
import frontendpack.SquarePainter;

/**
 *
 * @author 1
 */
public class FigureTryingMove {
    
    public static List<Point> tryToMoveDown(List<Point> componentsOfFigure) throws MoveException{
        List<Point> tryingComponents = new ArrayList<>();
        tryingComponents.add(new Point(componentsOfFigure.get(0)));
        tryingComponents.add(new Point(componentsOfFigure.get(1)));
        tryingComponents.add(new Point(componentsOfFigure.get(2)));
        tryingComponents.add(new Point(componentsOfFigure.get(3)));
        for(Point component : tryingComponents){
            component.moveDown(SquarePainter.getLENGTH());
        }
        if(isLuckyTryToMoveDown(tryingComponents)){
            return tryingComponents;
        }
        else{
            throw new MoveException("Cant move down");
        }
    }
      
      private static boolean isLuckyTryToMoveDown(List<Point> components){
          List<Point> usedFiguresComponents = Main.getGameField().getUsedFiguresComponents();
          for(Point component : components)
            if(usedFiguresComponents.contains(component)){
                return false;
            }
          
          for(Point component : components){
              if(component.getY() > Main.getGameField().getHeight()){
                  return false;
              }
          }
          
          return true;
      }
    
    public static List<Point> tryToMoveLeft(List<Point> componentsOfFigure) throws MoveException{
        List<Point> tryingComponents = new ArrayList<>();
        tryingComponents.add(new Point(componentsOfFigure.get(0)));
        tryingComponents.add(new Point(componentsOfFigure.get(1)));
        tryingComponents.add(new Point(componentsOfFigure.get(2)));
        tryingComponents.add(new Point(componentsOfFigure.get(3)));
        for(Point component : tryingComponents){
            component.moveLeft(SquarePainter.getLENGTH());
        }
        if(isLuckyTryToMoveLeft(tryingComponents)){
            return tryingComponents;
        }
        throw new MoveException("Cant move left!");
    }
      
      private static boolean isLuckyTryToMoveLeft(List<Point> components){
          List<Point> usedFiguresComponents = Main.getGameField().getUsedFiguresComponents();
          for(Point component : components)
            if(usedFiguresComponents.contains(component)){
                return false;
            }
          
          for(Point part : components){
              if(part.getX() < Main.getGameField().getX()){
                  return false;
              }
          }
          
          return true;
      }  
    
    public static List<Point> tryToMoveRight(List<Point> componentsOfFigure) throws MoveException{
        List<Point> tryingComponents = new ArrayList<>();
        tryingComponents.add(new Point(componentsOfFigure.get(0)));
        tryingComponents.add(new Point(componentsOfFigure.get(1)));
        tryingComponents.add(new Point(componentsOfFigure.get(2)));
        tryingComponents.add(new Point(componentsOfFigure.get(3)));
        for(Point component : tryingComponents){
            component.moveRight(SquarePainter.getLENGTH());
        }
        if(isLuckyTryToMoveRight(tryingComponents)){
            return tryingComponents;
        }
        else{
            throw new MoveException("Cant move right");
        }
    }
      
      private static boolean isLuckyTryToMoveRight(List<Point> components){
          List<Point> usedFiguresComponents = Main.getGameField().getUsedFiguresComponents();
          for(Point component : components)
            if(usedFiguresComponents.contains(component)){
                return false;
            }
          
          for(Point component : components){
              if(component.getX() > Main.getGameField().getX() + Main.getGameField().getWidth()){
                  return false;
              }
          }
          
          return true;
      }
      
    public static List<Point> tryToRotate(List<Point> componentsOfFigure, Point centerForRotate) throws MoveException{
        List<Point> tryingComponents = new ArrayList<>();
        tryingComponents.add(new Point(componentsOfFigure.get(0)));
        tryingComponents.add(new Point(componentsOfFigure.get(1)));
        tryingComponents.add(new Point(componentsOfFigure.get(2)));
        tryingComponents.add(new Point(componentsOfFigure.get(3)));
        Point center = new Point(centerForRotate);
        for(Point component : tryingComponents){
            component.copy(Point.rotatePointByCenter(component, center, Math.PI/2));
        }
        if(isLuckyTryToRotate(tryingComponents)){
            return tryingComponents;
        }
        else{
            throw new MoveException("Cant rotate");
        }
    }
      
      private static boolean isLuckyTryToRotate(List<Point> components){
          List<Point> usedFiguresComponents = Main.getGameField().getUsedFiguresComponents();
          for(Point component : components)
            if(usedFiguresComponents.contains(component)){
                return false;
            }
          
          for(Point component : components){
              if(component.getY() > Main.getGameField().getHeight() || component.getX() < Main.getGameField().getX() || component.getX() > Main.getGameField().getX() + Main.getGameField().getWidth()){
                  return false;
              }
          }
          
          return true;
      }  
}
