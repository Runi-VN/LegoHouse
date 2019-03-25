package Logic;

import Logic.Entities.Bricks;
import Logic.Entities.Order;

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
