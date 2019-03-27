package Presentation.Commands;

import Data.Entities.User;
import Logic.Exceptions.UserException;
import Presentation.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Works in the same way as login, without having to do a login; Returns user to
 * their "home page" (employeepage/customerpage)
 *
 *
 * Used on the OrderDetails page to return users to their respective page.
 *
 * @author Runi
 */
public class RedirectCommand extends Command
{

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws UserException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        User user = (User) request.getSession().getAttribute("user");
        return user.getRole();
    }

}
