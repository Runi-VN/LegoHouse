package DataLayer;

import FunctionLayer.UserException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Runi
 */
public class OrderMapper
{

    public static void createOrder(Order order) throws OrderException
    {
        try
        {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `legohouse`.`orders` "
                    + "(`length`, "
                    + "`width`, "
                    + "`height`, "
                    + "`user_id`)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getLength());
            stmt.setInt(2, order.getWidth());
            stmt.setInt(3, order.getHeight());
            stmt.setInt(4, order.getUserID());

            stmt.executeUpdate(); //Send update

            ResultSet rs = stmt.getGeneratedKeys(); //Get back result
            rs.next(); //First row
            int id = rs.getInt(1); //First result row (int OrderID)
            boolean status = rs.getBoolean(5); //Fifth result row (boolean status_sent)
            order.setOrderID(id);
            order.setStatus_sent(status);
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Error creating order: \n" + ex.getMessage());
        }
        // return true;
    }

    public static boolean updateStatus(int orderID, boolean newStatus) throws OrderException
    {
        int result;
        try
        {
            Connection con = Connector.connection();
            String SQL = "UPDATE `legohouse`.`orders` "
                    + "SET "
                    + "`status_sent` = ? "
                    + "WHERE <{?}>;";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setBoolean(1, newStatus);
            stmt.setInt(2, orderID);
            result = stmt.executeUpdate();

        }
        catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Error updating order status: \n" + ex.getMessage());
        }

        return result > 0;
    }
}
