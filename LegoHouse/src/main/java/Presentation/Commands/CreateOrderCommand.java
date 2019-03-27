package Presentation.Commands;

import Logic.Exceptions.OrderException;
import Logic.OrderFacade;
import Logic.Exceptions.UserException;
import Data.Entities.Order;
import Data.Entities.User;
import Presentation.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Creates an order based on req parameters
 * 
 * @author Runi
 */
public class CreateOrderCommand extends Command
{

    /**
     *
     * Creates an order based on request parameters, returns to userpage.
     *
     * @param request
     * @param response
     * @return
     * @throws UserException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        try
        {
            User user = (User) request.getSession().getAttribute("user");
            int height = Integer.parseInt(request.getParameter("height"));
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int userID = user.getId();
            Order o = new Order(length, width, height, userID);
            o.setHasDoor(request.getParameter("door") != null);
            o.setHasWindow(request.getParameter("window") != null);
            OrderFacade.getInstance().createOrder(o);
            user.addToOrderList(o);

            request.setAttribute("error", "Succesfully added order");
            //response.sendRedirect("customer");
        }
        catch (OrderException/* | IOException*/ ex)
        {
            request.setAttribute("error", "Error #397: " + ex);
            Logger.getLogger(CreateOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "customer";
    }

}
