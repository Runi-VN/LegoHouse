//package DataLayer;
//
//import DataLayer.Mappers.UserMapper;
//import FunctionLayer.UserException;
//import FunctionLayer.User;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//
///**
// *
// * @author runin
// */
//public class DBConnectorTest
//{
//
//    //    Test date in the UsersTest table
////    INSERT INTO `UsersTest` VALUES 
////    (1,'jens@somewhere.com','jensen','customer'),
////    (2,'ken@somewhere.com','kensen','customer'),
////    (3,'robin@somewhere.com','batman','employee'),
////    (4,'someone@nowhere.com','sesam','customer');
//    private static Connection testConnection;
//    private static String USER = "root";
//    private static String USERPW = "1234";
//    private static String DBNAME = "legohouse2";
//    private static String HOST = "localhost";
//
//    @Before
//    public void setUp()
//    {
//        try
//        {
//            // awoid making a new connection for each test
//            if (testConnection == null)
//            {
//                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
//                Class.forName("com.mysql.cj.jdbc.Driver");
//
//                testConnection = DriverManager.getConnection(url, USER, USERPW);
//                // Make mappers use test 
//                DBConnector.setConnection(testConnection);
//            }
//            // reset test database
//            try (Statement stmt = testConnection.createStatement())
//            {
//                stmt.execute("drop table if exists Userstest");
//                stmt.execute("create table Userstest like user");
//                stmt.execute("insert into Userstest select * from user");
//            }
//
//        }
//        catch (ClassNotFoundException | SQLException ex)
//        {
//            testConnection = null;
//            System.out.println("Could not open connection to database: " + ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testSetUpOK()
//    {
//        // Just check that we have a connection.
//        assertNotNull(testConnection);
//    }
//
//    @Test
//    public void testLogin01() throws UserException
//    {
//        // Can we log in
//        User user = UserMapper.getInstance().login("jens@somewhere.com", "jensen");
//        assertTrue(user != null);
//    }
//
//    @Test(expected = UserException.class)
//    public void testLogin02() throws UserException
//    {
//        // We should get an exception if we use the wrong password
//        User user = UserMapper.getInstance().login("jens@somewhere.com", "larsen");
//    }
//
//    @Test
//    public void testLogin03() throws UserException
//    {
//        // Jens is supposed to be a customer
//        User user = UserMapper.getInstance().login("jens@somewhere.com", "jensen");
//        assertEquals("customer", user.getRole());
//    }
//
////    @Test //it works
////    public void testCreateUser01() throws UserException
////    {
////        // Can we create a new user - Notice, if login fails, this will fail
////        // but so would login01, so this is OK
////        User original = new User("king@kong.com", "uhahvorhemmeligt", "konge");
////        UserMapper.createUser(original);
////        User retrieved = UserMapper.login("king@kong.com", "uhahvorhemmeligt");
////        assertEquals("konge", retrieved.getRole());
////    }
//}
