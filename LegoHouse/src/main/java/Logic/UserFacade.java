package Logic;

import Logic.Exceptions.UserException;
import Data.Mappers.UserMapper;
import Data.Entities.User;

/**
 *
 * Singleton logic facade for handling database -> logic -> presentation user handling.
 * 
 * @author runi
 */
public class UserFacade
{

    private static UserFacade instance = null;

    /**
     *
     * @return
     */
    public synchronized static UserFacade getInstance()
    {
        if (instance == null)
        {
            instance = new UserFacade();
        }
        return instance;
    }

    /**
     * Log in user
     *
     * @param email
     * @param password
     * @return
     * @throws UserException
     */
    public User login(String email, String password) throws UserException
    {
        return UserMapper.getInstance().login(email, password);
    }

    /**
     * Register user
     *
     * @param email
     * @param password
     * @return
     * @throws UserException
     */
    public User createUser(String email, String password) throws UserException
    {
        User user = new User(email, password, "customer");
        UserMapper.getInstance().createUser(user);
        return user;
    }

}
