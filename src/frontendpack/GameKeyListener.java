/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendpack;

import backendpack.figurepack.Figure;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetrispack.Main;

/**
 *
 * @author 1
 */
public class GameKeyListener implements KeyListener{
    
    private Figure currentFigure;
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentFigure = Main.getGameField().getCurrentFigure();
        
        currentFigure.clearFigure();
        
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("A")){
            currentFigure.moveLeft();
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("D")){
            currentFigure.moveRight();
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("W")){
            currentFigure.rotate();
        }
        
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Space")){
            currentFigure.fastMoveDown();
        }
        
        currentFigure.paintFigure();
    }
    
}
