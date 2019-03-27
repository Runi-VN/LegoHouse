package Presentation.Commands;

import Data.Entities.Order;
import Logic.UserFacade;
import Logic.Exceptions.UserException;
import Data.Entities.User;
import Logic.Exceptions.OrderException;
import Logic.OrderFacade;
import Presentation.Command;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logs an user in.
 *
 * @author kasper
 */
public class LoginCommand extends Command
{

    /**
     *
     * Logs user in. Handles user request attributes on user role
     * 
     * @param request
     * @param response
     * @return
     * @throws UserException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        UserFacade uf = new UserFacade();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = uf.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        setRequestAttributes(request, user); //set correct attributes

        session.setAttribute("userloggedin", true);
        //session.setAttribute("role", user.getRole());
        //return user.getRole() + "page";
        return user.getRole();
    }

    /**
     * Handles necessary request attributes based on the role of the user
     * 
     * @param request
     * @param user 
     */
    private void setRequestAttributes(HttpServletRequest request, User user)
    {
        try
        {
            if (user.getRole().equals("employee"))
            {
                ArrayList<Order> allOrders = OrderFacade.getInstance().getAllOrders();
                request.setAttribute("allOrders", allOrders);
            }
            else if (user.getRole().equals("customer"))
            {
                ArrayList<Order> allUserOrders = OrderFacade.getInstance().getAllUserOrders(user.getId());
                request.setAttribute("allUserOrders", allUserOrders);
            }

        }
        catch (OrderException ex)
        {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "Error retrieving user orders");
        }
    }

}
