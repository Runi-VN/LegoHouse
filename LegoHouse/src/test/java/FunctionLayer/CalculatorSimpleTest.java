package FunctionLayer;

import FunctionLayer.entities.Bricks;
import FunctionLayer.entities.Order;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Runi
 */
public class CalculatorSimpleTest
{
    
    public CalculatorSimpleTest()
    {
    }

    /**
     * Test of calculateBricks method, of class CalculatorSimple.
     */
    @Test
    public void testCalculateBricksUneven1Height()
    {
        Order o = new Order(23, 5, 1, 0); //23 length, 5 width, 1 height
        //Bricks expected = new Bricks(5, 1, 1); // = 23
        Bricks expected = new Bricks(12, 1, 0); // = (23*2) = (46/4)=11 for length, (5*1) for width, total 
        Calculator c = new CalculatorSimple();
        Bricks instance = c.calculateBricks(o);
        //assertEquals(expected.getTotal(), instance.getTotal());
        assertEquals(expected.getFours(), instance.getFours());
        assertEquals(expected.getTwos(), instance.getTwos());
        assertEquals(expected.getOnes(), instance.getOnes());
    }
    
     @Test
    public void testCalculateBricksEven1Height()
    {
        Order o = new Order(42, 5, 1, 0);
        Bricks expected = new Bricks(10, 1, 0); // = 42
        Calculator c = new CalculatorSimple();
        Bricks instance = c.calculateBricks(o);
        assertEquals(expected.getTotal(), instance.getTotal());
        assertEquals(expected.getFours(), instance.getFours());
        assertEquals(expected.getTwos(), instance.getTwos());
        assertEquals(expected.getOnes(), instance.getOnes());
    }

        
}
