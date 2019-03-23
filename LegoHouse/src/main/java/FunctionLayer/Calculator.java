package FunctionLayer;

import FunctionLayer.entities.Bricks;
import FunctionLayer.entities.Order;

/**
 *
 * @author runin
 */
public interface Calculator
{

    Bricks calculateBricks(Order order);
    
    Bricks calculateRowBricks (int brickAmount);
    Bricks CalculateTotalHouseBricks(Bricks lengthBricks, Bricks widthBricks, int height);
}
