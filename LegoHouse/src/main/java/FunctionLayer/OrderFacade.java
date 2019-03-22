package FunctionLayer;

import DataLayer.OrderMapper;

/**
 *
 * @author Runi
 */
public class OrderFacade
{

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
    public  Order createOrder(int length, int width, int height, int userID) throws OrderException
    {
        Order order = new Order(length, width, height, userID); //Desired info
        OrderMapper.createOrder(order); //Create order in database
        return order; //If no exception, return desired order with correct ID and status.
    }

    /**
     * Updates the status of the order in question
     *
     * @param order_id specific order ID
     * @param status new desired status of the order
     * @return returns true if update went correctly, false if not
     * @throws OrderException custom exception to handle later
     */
    public  boolean updateOrderStatus(int order_id, Boolean status) throws OrderException
    {
        return OrderMapper.updateStatus(order_id, status);
    }

    /**
     * Returns a single order ID through the database based on its ID.
     * @param OrderID
     * @return
     * @throws OrderException custom exception to handle later
     */
    public  Order getSingleOrder(int OrderID) throws OrderException
    {
        return OrderMapper.getOrderByID(OrderID);
    }

}
