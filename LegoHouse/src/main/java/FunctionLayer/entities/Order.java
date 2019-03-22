package FunctionLayer.entities;

/**
 *
 * @author Runi
 */
public class Order
{

    private int orderID;
    private int length;
    private int width;
    private int height;
    private boolean status_sent;
    private int userID;

//    public Order()
//    {
//    }

    public Order(int length, int width, int height, int userID)
    {
        this.length = length;
        this.width = width;
        this.height = height;
        this.userID = userID;
    }

    public int getOrderID()
    {
        return orderID;
    }

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public boolean getStatus_sent()
    /*Same as below*/
    {
        return status_sent;
    }

    /*
    public boolean isStatus_sent() //Same as above
    {
        return status_sent;
    }*/
    public void setStatus_sent(boolean status_sent)
    {
        this.status_sent = status_sent;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

}
