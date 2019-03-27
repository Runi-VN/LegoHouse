package Logic;

import Data.Entities.Bricks;
import Data.Entities.Order;

/**
 *Tries to take height of height, width, length, whether to "bound" (forbandt) and take account for doors and windows.
 * 
 * @see Calculator
 * 
 * @author Runi
 */
public class CalculatorAdvanced implements Calculator
{

    /**
     *
     * @param order
     * @return
     */
    @Override
    public Bricks calculateBricks(Order order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param brickAmount
     * @return
     */
    @Override
    public Bricks calculateRowBricks(int brickAmount)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param lengthBricks
     * @param widthBricks
     * @param height
     * @return
     */
    @Override
    public Bricks CalculateTotalHouseBricks(Bricks lengthBricks, Bricks widthBricks, int height)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
