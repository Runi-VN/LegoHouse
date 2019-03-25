package PresentationLayer.Commands;

import FunctionLayer.OrderException;
import FunctionLayer.OrderFacade;
import FunctionLayer.UserException;
import PresentationLayer.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author runin
 */
public class ShipOrderCommand extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        try
        {
            System.out.println("What is the orderID?");
            int orderID = Integer.parseInt(request.getParameter("orderid"));
            System.out.println("Current Order ID: " + orderID);
            OrderFacade.getInstance().updateOrderStatus(orderID, Boolean.TRUE);
            //OrderFacade of = OrderFacade.getInstance();
            //of.updateOrderStatus(0, Boolean.TRUE)
            return "employee";
        } catch (OrderException ex)
        {
            request.setAttribute("error", "Error updating Order Status: " + ex);
            
            Logger.getLogger(ShipOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "employee";
    }

}