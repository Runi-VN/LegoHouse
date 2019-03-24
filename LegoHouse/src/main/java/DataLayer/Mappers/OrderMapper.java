package DataLayer.Mappers;

import DataLayer.DBConnector;
import FunctionLayer.entities.Order;
import FunctionLayer.OrderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Runi
 */
public class OrderMapper
{

    private static OrderMapper instance = null;

    public synchronized static OrderMapper getInstance()
    {
        if (instance == null)
        {
            instance = new OrderMapper();
        }
        return instance;
    }

    public Order createOrder(Order order) throws OrderException
    {
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO `legohouse`.`orders` "
                    + "(`length`, "
                    + "`width`, "
                    + "`height`, "
                    + "`user_id`)"
                    + "VALUES"
                    + "(?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, order.getLength());
            stmt.setInt(2, order.getWidth());
            stmt.setInt(3, order.getHeight());
            stmt.setInt(4, order.getUserID());

            stmt.executeUpdate(); //Send update

            ResultSet rs = stmt.getGeneratedKeys(); //Get back result
            rs.next(); //First row
            int id = rs.getInt(1); //First result row (int OrderID)
            //boolean status = rs.getBoolean("status_sent"); 
            //boolean window = rs.getBoolean("hasWindow"); 
            //boolean door = rs.getBoolean("hasDoor"); 
            order.setOrderID(id);
            //order.setStatus_sent(status);
            //order.setHasWindow(window);
            //order.setHasDoor(door);
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Error creating order: \n" + ex.getMessage());
        }
        return order;
    }

    public boolean updateStatus(int orderID, boolean newStatus) throws OrderException
    {
        int result;
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "UPDATE `legohouse`.`orders` "
                    + "SET "
                    + "`status_sent` = ? "
                    + "WHERE <{?}>;";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setBoolean(1, newStatus);
            stmt.setInt(2, orderID);
            result = stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Error updating order status: \n" + ex.getMessage());
        }
        return result > 0;
    }

    /**
     * Returns all orders from a specific user
     *
     * @param userID users UID
     * @return list of orders
     * @throws OrderException throws exception
     */
    public ArrayList<Order> getAllOrdersByUserID(int userID) throws OrderException
    {
        ArrayList<Order> allUserOrders = new ArrayList<>();
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM legohouse.orders WHERE orders.user_id = ?;";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int orderID = rs.getInt("order_id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean status_sent = rs.getBoolean("status_sent");
                boolean hasWindow = rs.getBoolean("hasWindow");
                boolean hasDoor = rs.getBoolean("hasDoor");
                Order o = new Order(length, width, height, userID);
                o.setOrderID(orderID);
                o.setStatus_sent(status_sent);
                o.setHasWindow(hasWindow);
                o.setHasDoor(hasDoor);
                allUserOrders.add(o);
            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Error retrieving USER orders from database: \n" + ex.getMessage());
        }
        return allUserOrders;
    }

    /**
     * Retrieve a single order from database based on its ID. (Order ID)
     *
     * Make sure to check for ownership on userID.
     *
     *
     * @param orderID
     * @return
     */
    public Order getOrderByID(int orderID) throws OrderException
    {
        Order o = null;
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM legohouse.orders WHERE orders.order_id = ?;";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setInt(1, orderID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int user_id = rs.getInt("user_id");
                boolean status_sent = rs.getBoolean("status_sent");
                boolean hasWindow = rs.getBoolean("hasWindow");
                boolean hasDoor = rs.getBoolean("hasDoor");
                o = new Order(length, width, height, user_id);
                o.setOrderID(orderID);
                o.setStatus_sent(status_sent);
                o.setHasWindow(hasWindow);
                o.setHasDoor(hasDoor);
            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Error retrieving specific order from database: \n" + ex.getMessage());
        }
        return o;
    }

    public ArrayList<Order> getAllOrders() throws OrderException
    {
        ArrayList<Order> allOrders = new ArrayList<>();
        try
        {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM legohouse.orders;";
            PreparedStatement stmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                int orderID = rs.getInt("order_id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean status_sent = rs.getBoolean("status_sent");
                int userID = rs.getInt("user_id");
                boolean hasWindow = rs.getBoolean("hasWindow");
                boolean hasDoor = rs.getBoolean("hasDoor");
                Order o = new Order(length, width, height, userID);
                o.setOrderID(orderID);
                o.setStatus_sent(status_sent);
                o.setHasWindow(hasWindow);
                o.setHasDoor(hasDoor);
                allOrders.add(o);
            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new OrderException("Unable to retrieve all orders from database: \n" + ex.getMessage());
        }
        return allOrders;
    }
}
