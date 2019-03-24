package PresentationLayer.Commands;

import FunctionLayer.UserException;
import FunctionLayer.entities.User;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Runi
 */
public class EmployeeCommand extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("error", "test pls work");
        /*Lets check if user actually is an employee*/
        if (!user.getRole().equals("employee")) return "customer";
        return user.getRole(); //does above anyways :^)
    }
}
