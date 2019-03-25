package FunctionLayer;

import Logic.CalculatorSimple;
import Logic.Calculator;
import Logic.Entities.Bricks;
import Logic.Entities.Order;
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
        Bricks expected = new Bricks(10, 2, 4); //see CalculatorSimple for detailed documentation
//        21/4 = 5
//            21%4 = 1 (remainder - used for next calc)
//            1/2 = 0
//            1%2 = 1
//                    length = (5,0,1) * 2 = (10,0,2) (fours, twos, ones)
//                Width:
//            3/4 = 0
//            3%4 = 3 (remainder - used for next calc)
//            3/2 = 1
//            3%2 = 1
//                    width = (0, 1, 1) * 2 = (0, 2, 2)  (fours, twos, ones)

                        //Total:  (length+width) (10,2,4) `(fours, twos, ones)`*/
        Calculator c = new CalculatorSimple();
        Bricks instance = c.calculateBricks(o);
        assertEquals(expected.getTotal(), instance.getTotal());
        assertEquals(expected.getFours(), instance.getFours());
        assertEquals(expected.getTwos(), instance.getTwos());
        assertEquals(expected.getOnes(), instance.getOnes());
    }

    @Test
    public void testCalculateBricksEven1Height()
    {
        Order o = new Order(42, 5, 1, 0); //42 length, 5 width, 1 height
        Bricks expected = new Bricks(20, 2, 2);
        //42/5/1 (l/w/h)
        //
        //40/3 (-2l/-2w)
            //length:
                //40/4 = 10
                //40%4 = 0
                //0/2 = 0
                //0%2 = 0
                //
                //length = (10,0,0) *2 (sides) = (20,0,0) (fours, twos, ones) 
            //width:
                //3/4 = 0
                //3%4 = 3
                //3/2 = 1
                //3%2 = 1
                //
                //width = (0, 1, 1) * 2 (sides) = (0, 2, 2)  (fours, twos, ones)
        //
                    //Total: (20,2,2)
        Calculator c = new CalculatorSimple();
        Bricks instance = c.calculateBricks(o);
        assertEquals(expected.getTotal(), instance.getTotal());
        assertEquals(expected.getFours(), instance.getFours());
        assertEquals(expected.getTwos(), instance.getTwos());
        assertEquals(expected.getOnes(), instance.getOnes());
    }

    
    @Test
    public void testCalculateBricksUneven4Height()
    {
        Order o = new Order(23, 5, 4, 0); //23 length, 5 width, 4 height
        Bricks expected = new Bricks(40, 8, 16); //Explanation: Just take result from 1Height method*4
        
        Calculator c = new CalculatorSimple();
        Bricks instance = c.calculateBricks(o);
        assertEquals(expected.getTotal(), instance.getTotal());
        assertEquals(expected.getFours(), instance.getFours());
        assertEquals(expected.getTwos(), instance.getTwos());
        assertEquals(expected.getOnes(), instance.getOnes());
    }
    
    @Test
    public void testCalculateBricksEven4Height()
    {
        Order o = new Order(42, 5, 4, 0); //42 length, 5 width, 4 height
        Bricks expected = new Bricks(80, 8, 8); //Explanation: Just take result from 1Height method*4
        
        Calculator c = new CalculatorSimple();
        Bricks instance = c.calculateBricks(o);
        assertEquals(expected.getTotal(), instance.getTotal());
        assertEquals(expected.getFours(), instance.getFours());
        assertEquals(expected.getTwos(), instance.getTwos());
        assertEquals(expected.getOnes(), instance.getOnes());
    }
}
