package FunctionLayer;

import DataLayer.Mappers.OrderMapper;
import DataLayer.Mappers.UserMapper;
import FunctionLayer.entities.Order;
import java.util.ArrayList;

/**
 *
 * @author Runi
 */
public class OrderFacade
{

    private static OrderFacade instance = null;

    public synchronized static OrderFacade getInstance()
    {
        if (instance == null)
        {
            instance = new OrderFacade();
        }
        return instance;
    }

    /**
     * Creates an order from desired parameters, adds it to database.
     *
     * If successful, returns order with updated ID (AUTO_INCREMENT) &
     * status_sent (Default: False/0) returned from database.
     *
     * @see OrderMapper
     *
     * @param length desired length in DOTS (int)
     * @param width desired with in DOTS (int)
     * @param height desired height in BLOCKS (int)
     * @param userID
     * @return
     * @throws OrderException custom exception to handle later
     */
    public Order createOrderByFields(int length, int width, int height, int userID) throws OrderException
    {
        Order order = new Order(length, width, height, userID); //Desired info
        OrderMapper.getInstance().createOrder(order); //Create order in database
        return order; //If no exception, return desired order with correct ID and status.
    }

    public Order createOrder(Order order) throws OrderException
    {
        return OrderMapper.getInstance().createOrder(order);
    }

    /**
     * Updates the status of the order in question
     *
     * @param order_id specific order ID
     * @param status new desired status of the order
     * @return returns true if update went correctly, false if not
     * @throws OrderException custom exception to handle later
     */
    public boolean updateOrderStatus(int order_id, Boolean status) throws OrderException
    {
        return OrderMapper.getInstance().updateStatus(order_id, status);
    }

    /**
     * Returns a single order ID through the database based on its ID.
     *
     * @param OrderID
     * @return
     * @throws OrderException custom exception to handle later
     */
    public Order getSingleOrder(int OrderID) throws OrderException
    {
        return OrderMapper.getInstance().getOrderByID(OrderID);
    }

    /**
     *
     * @param userID
     * @return
     * @throws OrderException
     */
    public ArrayList<Order> getAllUserOrders(int userID) throws OrderException
    {
        return OrderMapper.getInstance().getAllOrdersByUserID(userID);
    }

}
