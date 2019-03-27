package Logic.Exceptions;

/**
 * Custom exception used in regards to user login/creation.
 *
 *
 * @author kasper
 */
public class UserException extends Exception
{

    /**
     *
     * @param msg
     */
    public UserException(String msg)
    {
        super(msg);
    }

}
