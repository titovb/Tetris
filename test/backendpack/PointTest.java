/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendpack;

import backendpack.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class PointTest {
    
    Point example;
    Point expResult;
    Point instance;
    
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCopy1() {
        System.out.println("copy1");
        example = new Point(5, 5);
        instance = new Point(0, 0);
        expResult = new Point(5, 5);
        instance.copy(example);
        assertEquals(expResult, instance);
    }

    @Test
    public void testCopy2() {
        System.out.println("copy2");
        example = new Point(0, 0);
        instance = new Point(0, 0);
        expResult = new Point(0, 0);
        instance.copy(example);
        assertEquals(expResult, instance);
    }

    @Test
    public void testMoveDown1() {
        System.out.println("moveDown1");
        int distance = 5;
        expResult = new Point(5, 10);
        instance = new Point(5, 5);
        instance.moveDown(distance);
        assertEquals(instance, expResult);
    }

    @Test
    public void testMoveDown2() {
        System.out.println("moveDown2");
        int distance = -5;
        expResult = new Point(5, 10);
        instance = new Point(5, 5);
        instance.moveDown(distance);
        assertEquals(instance, expResult);
    }

    @Test
    public void testMoveUp1() {
        System.out.println("moveUp1");
        int distance = 5;
        expResult = new Point(5, 0);
        instance = new Point(5, 5);
        instance.moveUp(distance);
        assertEquals(instance, expResult);
    }
    
    @Test
    public void testMoveUp2() {
        System.out.println("moveUp2");
        int distance = -5;
        expResult= new Point(5, 0);
        instance = new Point(5, 5);
        instance.moveUp(distance);
        assertEquals(instance, expResult);
    }

    @Test
    public void testMoveRight1() {
        System.out.println("moveRight1");
        int distance = 5;
        expResult = new Point(10, 5);
        instance = new Point(5, 5);
        instance.moveRight(distance);
        assertEquals(instance, expResult);
    }
    
    @Test
    public void testMoveRight2() {
        System.out.println("moveRight2");
        int distance = -5;
        expResult = new Point(10, 5);
        instance = new Point(5, 5);
        instance.moveRight(distance);
        assertEquals(instance, expResult);
    }

    @Test
    public void testMoveLeft1() {
        System.out.println("moveLeft1");
        int distance = 5;
        expResult = new Point(0, 5);
        instance = new Point(5, 5);
        instance.moveLeft(distance);
        assertEquals(instance, expResult);
    }
    
    @Test
    public void testMoveLeft2() {
        System.out.println("moveLeft2");
        int distance = -5;
        expResult = new Point(0, 5);
        instance = new Point(5, 5);
        instance.moveLeft(distance);
        assertEquals(instance, expResult);
    }

    @Test
    public void testRotatePointByCenter1() {
        System.out.println("rotatePointByCenter");
        Point pointForRotate = new Point(3,3);
        Point centerForRotate = new Point(3,6);
        double angle = Math.PI/2;
        expResult = new Point(6, 6);
        Point result = Point.rotatePointByCenter(pointForRotate, centerForRotate, angle);
        assertEquals(expResult, result);
    }

    @Test
    public void testRotatePointByCenter2() {
        System.out.println("rotatePointByCenter");
        Point pointForRotate = new Point(3, 3);
        Point centerForRotate = new Point(3,6);
        double angle = - Math.PI/2;
        expResult = new Point(0, 6);
        Point result = Point.rotatePointByCenter(pointForRotate, centerForRotate, angle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRotatePointByCenter3() {
        System.out.println("rotatePointByCenter");
        Point pointForRotate = new Point(3,3);
        Point centerForRotate = new Point(3,6);
        double angle = 0;
        expResult = new Point(3, 3);
        Point result = Point.rotatePointByCenter(pointForRotate, centerForRotate, angle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRotatePointByCenter4() {
        System.out.println("rotatePointByCenter");
        Point pointForRotate = new Point(3,3);
        Point centerForRotate = new Point(3,6);
        double angle = Math.PI;
        expResult = new Point(3, 9);
        Point result = Point.rotatePointByCenter(pointForRotate, centerForRotate, angle);
        System.out.println(result.getX() + " " + result.getY());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRotatePointByCenter5() {
        System.out.println("rotatePointByCenter");
        Point pointForRotate = new Point(3,3);
        Point centerForRotate = new Point(3,6);
        double angle = Math.PI * 2;
        expResult = new Point(3, 3);
        Point result = Point.rotatePointByCenter(pointForRotate, centerForRotate, angle);
        System.out.println(result.getX() + " " + result.getY());
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Point(1, 1);
        instance = new Point(1, 1);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
