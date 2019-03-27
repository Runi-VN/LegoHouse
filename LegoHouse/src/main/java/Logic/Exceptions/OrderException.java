package Logic.Exceptions;

/**
 *
 * Custom exception related to order creation.
 *
 * @author Runi
 */
public class OrderException extends Exception
{

    /**
     *
     * @param msg
     */
    public OrderException(String msg)
    {
        super(msg);
    }
}
