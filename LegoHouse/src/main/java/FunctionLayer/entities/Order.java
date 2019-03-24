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
    private boolean status_sent = false;
    private int userID;
    private boolean hasWindow = false;
    private boolean hasDoor = false;

    public Order(int orderID, int length, int width, int height, boolean status_sent, int userID, boolean hasWindow, boolean hasDoor)
    {
        this.orderID = orderID;
        this.length = length;
        this.width = width;
        this.height = height;
        this.status_sent = status_sent;
        this.userID = userID;
        this.hasWindow = hasWindow;
        this.hasDoor = hasDoor;
    }

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
    {
        return status_sent;
    }

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

    public boolean getHasWindow()
    {
        return hasWindow;
    }

    public void setHasWindow(boolean hasWindow)
    {
        this.hasWindow = hasWindow;
    }

    public boolean getHasDoor()
    {
        return hasDoor;
    }

    public void setHasDoor(boolean hasDoor)
    {
        this.hasDoor = hasDoor;
    }

}
