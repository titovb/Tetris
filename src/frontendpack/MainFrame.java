/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendpack;

import frontendpack.GamePanel;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 1
 */
public class MainFrame extends JFrame{
    
    private GamePanel gamePanel;
    
    public MainFrame(){
        int amountOfSquaresInRow = 24;
        int amountOfSquaresInColumn = 24;
        
        int width = amountOfSquaresInRow * SquarePainter.getLENGTH();
        int height = amountOfSquaresInColumn * SquarePainter.getLENGTH();
        
        this.setSize(width, height);
        
        gamePanel = new GamePanel();
        
        this.setContentPane(gamePanel);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public GamePanel getGamePanel(){
        return this.gamePanel;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
}
