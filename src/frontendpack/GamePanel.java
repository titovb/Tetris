
package frontendpack;

import java.awt.*;
import javax.swing.*;
import tetrispack.Main;

public class GamePanel extends JPanel{
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    public GamePanel(){
        super();
        
        int amountOfSquaresInRowToPanel = 7;
        x = SquarePainter.getLENGTH() * amountOfSquaresInRowToPanel - 2;
        y = SquarePainter.getLENGTH()/2 - 2;
        
        int amountOfSquaresInRow = 10;
        int amountOfSquaresInColumn = 20;
        width = SquarePainter.getLENGTH() * amountOfSquaresInRow + 4;
        height = SquarePainter.getLENGTH() * amountOfSquaresInColumn + 4;
        
        this.setBounds(x, y, width, height);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyListener());
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.black);
        g2d.drawRect(x, y, width, height);
    }
}
