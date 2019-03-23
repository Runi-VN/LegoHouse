package PresentationLayer.Commands;

import FunctionLayer.entities.Order;
import FunctionLayer.OrderException;
import FunctionLayer.OrderFacade;
import FunctionLayer.entities.User;
import FunctionLayer.UserException;
import PresentationLayer.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Runi
 */
public class OrderDetails extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        User sessionUser = (User) request.getSession().getAttribute("user");
        int orderID = Integer.parseInt(request.getParameter("id"));
        OrderFacade of = OrderFacade.getInstance();

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

        } catch (OrderException ex)
        {
            request.setAttribute("error", "Order does not belong to you. (#405)");
            Logger.getLogger(OrderDetails.class.getName()).log(Level.SEVERE, null, ex);
            return sessionUser.getRole() + "page";
        }
        return "orderdetails";
    }

}
