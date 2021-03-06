package Presentation.Commands;

import Logic.Calculator;
import Logic.CalculatorSimple;
import Data.Entities.Order;
import Logic.Exceptions.OrderException;
import Logic.OrderFacade;
import Data.Entities.User;
import Logic.Exceptions.UserException;
import Presentation.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Runi
 */
public class OrderDetailsCommand extends Command
{

    /**
     *
     * Handles orderdetails.jsp.
     * 
     * Checks if order belongs to order,
     * 
     * checks if user is an admin
     * 
     * then displays if one or both is true.
     * 
     * @param request
     * @param response
     * @return
     * @throws UserException
     */
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
            //Handle window/door calculation here (Search: future)
            Calculator c = new CalculatorSimple();
            request.setAttribute("bricks", c.calculateBricks(o));

        } catch (OrderException ex)
        {
            request.setAttribute("error", "Order does not belong to you. (#405)");
            Logger.getLogger(OrderDetailsCommand.class.getName()).log(Level.SEVERE, null, ex);
            return sessionUser.getRole() + "page";
        }
        return "orderdetails";
    }

}
