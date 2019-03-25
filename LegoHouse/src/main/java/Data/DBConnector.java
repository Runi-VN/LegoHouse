package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The purpose of DBConnector is to...
 *
 * @author runi
 */
public class DBConnector
{

//    private static final String URL = "localhost";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "1234";
    private static final String IP = "localhost";
    private static final String PORT = "3306";
    public static final String DATABASE = "legohouse";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234"; //laptop: root //desktop: 1234

    private static Connection singleton;

    public static void setConnection(Connection con)
    {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException
    {
        if (singleton == null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

                String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

                Properties props = new Properties();
                props.put("user", USERNAME);
                props.put("password", PASSWORD);
                props.put("allowMultiQueries", true);
                props.put("useUnicode", true);
                props.put("useJDBCCompliantTimezoneShift", true);
                props.put("useLegacyDatetimeCode", false);
                props.put("serverTimezone", "CET");
                singleton = DriverManager.getConnection(url, props);
                System.out.println("Connection correctly established to the database: " + DATABASE);
            } catch (InstantiationException | IllegalAccessException ex)
            {
                /*ex.printStackTrace();*/
                System.out.println(ex);
                throw new SQLException("Error accessing database (#1338)");
            }
            //singleton = DriverManager.getConnection("jdbc:mysql://"+URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

}
