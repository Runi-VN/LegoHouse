package FunctionLayer;

/**
 *
 * @author runin
 */
public class Bricks
{
    
    private int fours;
    private int twos;
    private int ones;

    /**
     * Functions as a unit count of the bricks
     * @param fours 2x4
     * @param twos 2x2
     * @param ones 1x2
     */
    public Bricks(int fours, int twos, int ones)
    {
        this.fours = fours;
        this.twos = twos;
        this.ones = ones;
    }

    public int getFours()
    {
        return fours;
    }

    public void setFours(int fours)
    {
        this.fours = fours;
    }

    public int getTwos()
    {
        return twos;
    }

    public void setTwos(int twos)
    {
        this.twos = twos;
    }

    public int getOnes()
    {
        return ones;
    }

    public void setOnes(int ones)
    {
        this.ones = ones;
    }
    
    
    
    
}
