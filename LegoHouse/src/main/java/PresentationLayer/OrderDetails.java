package PresentationLayer;

import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.OrderFacade;
import FunctionLayer.User;
import FunctionLayer.UserException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Runi
 */
public class OrderDetails extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        User sessionUser = (User) request.getSession().getAttribute("user");
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        OrderFacade of = new OrderFacade();

        try
        {
            Order o = of.getSingleOrder(orderID);

            if (sessionUser.getId() != o.getUserID())
            {
                if (!sessionUser.getRole().equals("employee"))
                {
                    request.setAttribute("error", "Order does not belong to you. (#406");
                    return sessionUser.getRole() + "page";
                }
            }

            request.setAttribute("order", o);

        }
        catch (OrderException ex)
        {
            request.setAttribute("error", "Order does not belong to you. (#405)");
            Logger.getLogger(OrderDetails.class.getName()).log(Level.SEVERE, null, ex);
            return sessionUser.getRole() + "page";
        }
        return "orderdetails";
    }

}
