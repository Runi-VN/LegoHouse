package Presentation.Commands;

import Logic.UserFacade;
import Logic.Exceptions.UserException;
import Logic.Entities.User;
import Presentation.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of LoginCommand is to...
 *
 * @author kasper
 */
public class LoginCommand extends Command
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
        session.setAttribute("userloggedin", true);
        //session.setAttribute("role", user.getRole());
        //return user.getRole() + "page";
        return user.getRole();
    }

}
