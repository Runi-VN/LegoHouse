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
public class CustomerCommand extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        User user = (User) request.getSession().getAttribute("user");
        return user.getRole();
    }
}