package FunctionLayer;

import DataLayer.UserMapper;

/**
 * 
 * @author runi
 */
public class UserFacade {

    
    /**
     * Log in user
     * @param email
     * @param password
     * @return
     * @throws UserException 
     */
    public  User login( String email, String password ) throws UserException {
        return UserMapper.login( email, password );
    } 

    /**
     * Register user
     * @param email
     * @param password
     * @return
     * @throws UserException 
     */
    public  User createUser( String email, String password ) throws UserException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
}
