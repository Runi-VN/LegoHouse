package Logic;

import Logic.Entities.Bricks;
import Logic.Entities.Order;

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

        /*A single brick unit has a default width of 2 "dots" -- When this brick corners up to another brick, we are faced with a problem.*/
        length = length - 2; //Taking account of bricks accumulating in corners
        width = width - 2; //Taking account of bricks accumulating in corners

        /*Example:
        New order: (23,5,1) (length, width, height)
        We subtract -2 to counter corner bricks as written above, so actual count is >(21,3,1)<
                Length:
            21/4 = 5
            21%4 = 1 (remainder - used for next calc)
            1/2 = 0
            1%2 = 1
                    length = (5,0,1) * 2 = (10,0,2) (fours, twos, ones)
                Width:
            3/4 = 0
            3%4 = 3 (remainder - used for next calc)
            3/2 = 1
            3%2 = 1
                    width = (0, 1, 1) * 2 = (0, 2, 2)  (fours, twos, ones)

        Total:  (length+width) (10,2,4) `(fours, twos, ones)`*/
        
        Bricks lengthBricks = calculateRowBricks(length);
        //System.out.println(lengthBricks.getTotal() + "\n--");
        Bricks widthBricks = calculateRowBricks(width);
        System.out.println(widthBricks.getTotal());
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
        int CalcFours = (brickAmount / 4); //4 = bricksize
        int CalcRemainder = (brickAmount % 4);
        int CalcTwos = (CalcRemainder / 2); //2 = bricksize
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
