/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispack;

import backendpack.GameField;
import frontendpack.MainFrame;

/**
 *
 * @author 1
 */
public class Main {
    
    private static MainFrame mainFrame;
    private static GameField gameField;
    
    public static void main(String[] args){
        gameField = new GameField();
        mainFrame = new MainFrame();
        gameField.start();
    }
    
    public static GameField getGameField(){
        return gameField; 
    }
    
    public static MainFrame getMainFrame(){
        return mainFrame;
    }
}
