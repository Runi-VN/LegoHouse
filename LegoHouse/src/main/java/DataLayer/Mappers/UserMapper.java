package DataLayer.Mappers;

import DataLayer.DBConnector;
import FunctionLayer.entities.UserException;
import FunctionLayer.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper
{

    private static UserMapper instance = null;

    public synchronized static UserMapper getInstance()
    {
        if (instance == null)
        {
            instance = new UserMapper();
        }
        return instance;
    }

    public void createUser(User user) throws UserException
    {
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO User (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException
    {
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "SELECT id, role FROM User "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else
            {
                throw new UserException("Could not validate user information, try again");
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

}
