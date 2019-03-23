package FunctionLayer;

import FunctionLayer.entities.Bricks;
import FunctionLayer.entities.Order;

/**
 *
 * Only takes account for length, width & height.
 *
 * For documentation see github ReadMe: https://github.com/Runi-VN/LegoHouse/
 *
 * @author runin
 */
public class CalculatorSimple implements Calculator
{

    @Override
    public Bricks calculateBricks(Order order)
    {
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        

        Bricks lengthBricks = calculateRowBricks(length);
        System.out.println(lengthBricks.getTotal() + "\n________");
        Bricks widthBricks = calculateRowBricks(width);
        //System.out.println(widthBricks.getTotal());
        return CalculateTotalHouseBricks(lengthBricks, widthBricks, height);
    }

    /**
     * Calculate width and height
     *
     * @param brickAmount
     * @return
     */
    @Override
    public Bricks calculateRowBricks(int brickAmount)
    {
        int CalcFours = (brickAmount / 4);
        int CalcRemainder = (brickAmount % 4);
        int CalcTwos = (CalcRemainder / 2);
        int CalcOnes = (CalcRemainder % 2);
        return new Bricks(CalcFours, CalcTwos, CalcOnes);
    }

    /**
     * Lets take height for all sides and do it all in one line :^)
     *
     * At the same time, we need to take into account that there are always 2
     * "sides" (lengths) and 2 widths to a house.
     *
     * @param lengthBricks
     * @param widthBricks
     * @param height
     * @return
     */
    @Override
    public Bricks CalculateTotalHouseBricks(Bricks lengthBricks, Bricks widthBricks, int height)
    {
        return new Bricks(((lengthBricks.getFours() + widthBricks.getFours()) * 2) * height, ((lengthBricks.getTwos() + widthBricks.getTwos()) * 2) * height, ((lengthBricks.getOnes() + widthBricks.getOnes()) * 2) * height);

    }

}
