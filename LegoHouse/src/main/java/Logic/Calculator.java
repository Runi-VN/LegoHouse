package Logic;

import Data.Entities.Bricks;
import Data.Entities.Order;

/**
 *
 * Calculator interface for various degrees of calculators (simple, advanced)
 * 
 * @author runin
 */
public interface Calculator
{

    /**
     *
     * Main method. Calculates rows + total bricks
     * 
     * @param order
     * @return
     */
    Bricks calculateBricks(Order order);
    
    /**
     *
     * Method 1, calculates rows (width/length)
     * 
     * @param brickAmount
     * @return
     */
    Bricks calculateRowBricks (int brickAmount);

    /**
     *
     * Method 2. Calculates rows+length*height
     * 
     * @param lengthBricks
     * @param widthBricks
     * @param height
     * @return
     */
    Bricks CalculateTotalHouseBricks(Bricks lengthBricks, Bricks widthBricks, int height);
}
