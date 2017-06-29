
package backendpack;

public class Point {
    private int x;
    private int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Point(double x, double y){
        this.x = (int)Math.round(x);
        this.y = (int)Math.round(y);
    }
    
    public Point(Point obj){
        this(obj.x, obj.y);
    }
    
    public void copy(Point obj){
        this.x = obj.x;
        this.y = obj.y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void moveDown(int distance){
        distance = changeDistanceToPositive(distance);
        y += distance;
    }
    
    public void moveUp(int distance){
        distance = changeDistanceToPositive(distance);
        y -= distance;
    }
    
    public void moveRight(int distance){
        distance = changeDistanceToPositive(distance);
        x += distance;
    }
    
    public void moveLeft(int distance){
        distance = changeDistanceToPositive(distance);
        x -= distance;
    }
    
    private int changeDistanceToPositive(int distance){
        if(distance < 0)
            distance = -distance;
        return distance;
    }
    
    public static Point rotatePointByCenter(Point pointForRotate, Point centerForRotate, double angle){
        return new Point(centerForRotate.getX()+(pointForRotate.getX()-centerForRotate.getX())*Math.cos(angle)+
                (centerForRotate.getY()-pointForRotate.getY())*Math.sin(angle),
                         centerForRotate.getY()+(pointForRotate.getX()-centerForRotate.getX())*Math.sin(angle)+
                (pointForRotate.getY()-centerForRotate.getY())*Math.cos(angle));
    }
    
    @Override
    public boolean equals(Object obj){
        Point p = (Point)obj;
        return p.x == this.x && p.y == this.y;
    }
}
