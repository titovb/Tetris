
package backendpack;

import frontendpack.SquarePainter;
import backendpack.figurepack.FigureL;
import backendpack.figurepack.FigureZ;
import backendpack.figurepack.FigureS;
import backendpack.figurepack.FigureI;
import backendpack.figurepack.FigureO;
import backendpack.figurepack.Figure;
import backendpack.figurepack.FigureJ;
import backendpack.figurepack.FigureT;
import java.util.List;
import java.util.ArrayList;

public class GameField extends Thread{
    private List<Point> usedFiguresComponents;
    private int x;
    private int y;
    private int width;
    private int height;
    private Figure currentFigure;
    private boolean gameOver;
    
    public GameField(){
        int amountOfSquaresInRowToField = 7;
        x = SquarePainter.getLENGTH() * amountOfSquaresInRowToField;
        y = SquarePainter.getLENGTH();
        
        int amountOfSquaresInRow = 10;
        int amountOfSquaresInColumn = 20;
        width = SquarePainter.getLENGTH() * amountOfSquaresInRow;
        height = SquarePainter.getLENGTH() * amountOfSquaresInColumn;

        gameOver = false;
        
        usedFiguresComponents = new ArrayList<>();
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public Figure getCurrentFigure(){
        return this.currentFigure;
    }
    
    public List<Point> getUsedFiguresComponents(){
        return usedFiguresComponents;
    }
    
    public boolean usedFiguresComponentsContains(List<Point> components){
        for(Point component : components)
            if(usedFiguresComponents.contains(component)){
                return true;
            }
        return false;
    }
    
    private Figure randomFigure(){
        double random  = 7 * Math.random();
        if(random <= 1){
            return new FigureI(new Point(x + SquarePainter.getLENGTH()*3, y));
        }
        if(random <= 2 && random > 1){
            return new FigureO(new Point(x + SquarePainter.getLENGTH()*3, y));
        }
        if(random <= 3 && random > 2){
            return new FigureT(new Point(x + SquarePainter.getLENGTH()*3, y));
        }
        if(random <= 4 && random > 3){
            return new FigureL(new Point(x + SquarePainter.getLENGTH()*3, y));
        }
        if(random <= 5 && random > 4){
            return new FigureJ(new Point(x + SquarePainter.getLENGTH()*3, y));
        }
        if(random <= 6 && random > 5){
            return new FigureZ(new Point(x + SquarePainter.getLENGTH()*3, y));
        }
        return new FigureS(new Point(x + SquarePainter.getLENGTH()*3, y));
    }
    
    @Override
    public void run(){
        do{
            System.out.print("");
            if(currentFigure == null){
                currentFigure = randomFigure();
                currentFigure.start();
            }
            if(currentFigure.isStopped()){
                usedFiguresComponents.addAll(currentFigure.getComponents());
                currentFigure = randomFigure();
                currentFigure.start();
                deleteLine();
                checkGameOver();
            }
        }while(!gameOver);
        System.exit(0);
    }
    
    private void checkGameOver(){
        for(int i = usedFiguresComponents.size() - 1; i>=0; i--){
            if(usedFiguresComponents.get(i).getY() == y){
                gameOver = true;
                break;
            }
        }
    }
    
    private void deleteLine(){
        List<Point> lineForDelete = searchLineForDelete();
        while(!lineForDelete.isEmpty()){
            for(int i=0;i<usedFiguresComponents.size();i++)
                SquarePainter.clear(usedFiguresComponents.get(i));
            
            usedFiguresComponents.removeAll(lineForDelete);
            for(Point component : usedFiguresComponents){
                if(component.getY()<lineForDelete.get(0).getY()){
                    component.moveDown(SquarePainter.getLENGTH());
                }
            }
            
            for(int i=0;i<usedFiguresComponents.size();i++)
                SquarePainter.paint(usedFiguresComponents.get(i));
            
            lineForDelete = searchLineForDelete();
        }
    }
    
    private List<Point> searchLineForDelete(){
        int amountOfComponentsInCurrentLine = 0;
        int currentLine = y;
        List<Point> lineForDelete = new ArrayList<>();
        
        while(amountOfComponentsInCurrentLine < 10 && !(currentLine > SquarePainter.getLENGTH()*20)){
            for(Point component : usedFiguresComponents){
                if(component.getY() == currentLine){
                    amountOfComponentsInCurrentLine++;
                    lineForDelete.add(new Point(component));
                }
                if(amountOfComponentsInCurrentLine == 10){
                    return lineForDelete;
                }
            }
            amountOfComponentsInCurrentLine = 0;
            lineForDelete.clear();
            currentLine += SquarePainter.getLENGTH();
        }
        
        return lineForDelete;
    }
}
