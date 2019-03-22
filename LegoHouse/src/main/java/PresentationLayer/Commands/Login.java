package PresentationLayer.Commands;

import FunctionLayer.entities.UserFacade;
import FunctionLayer.entities.UserException;
import FunctionLayer.entities.User;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class Login extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        UserFacade uf = new UserFacade();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = uf.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        return user.getRole() + "page";
    }

}
