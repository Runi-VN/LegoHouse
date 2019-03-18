package FunctionLayer;

import DataLayer.UserMapper;

/**
 * The purpose of UserFacade is to...
 * @author kasper
 */
public class UserFacade {

    /*User*/
    
    /**
     * Log in user
     * @param email
     * @param password
     * @return
     * @throws UserException 
     */
    public static User login( String email, String password ) throws UserException {
        return UserMapper.login( email, password );
    } 

    /**
     * Register user
     * @param email
     * @param password
     * @return
     * @throws UserException 
     */
    public static User createUser( String email, String password ) throws UserException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
}
