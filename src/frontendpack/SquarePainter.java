
package frontendpack;

import java.awt.*;
import tetrispack.Main;
import backendpack.Point;

public class SquarePainter {
    private static final int LENGTH = 30;
    
    public static int getLENGTH(){
        return LENGTH;
    }
    
    public static void paint(Point center){
        Graphics2D g = (Graphics2D) Main.getMainFrame().getGamePanel().getGraphics();
        
        Image img;
        
        String adr = "images\\Square.png";
        
        img = Toolkit.getDefaultToolkit().getImage(adr);
        
        g.drawImage(img, center.getX()-LENGTH/2, center.getY()-LENGTH/2, LENGTH, LENGTH, Main.getMainFrame().getGamePanel());
    }
    
    public static void clear(Point center){
        Graphics2D g = (Graphics2D) Main.getMainFrame().getGamePanel().getGraphics();
        
        g.setColor(g.getBackground());
        g.fillRect(center.getX()-LENGTH/2, center.getY()-LENGTH/2, LENGTH, LENGTH);
    }
}
