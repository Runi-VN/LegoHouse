package Presentation.Commands;

import Logic.Exceptions.UserException;
import Presentation.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Logs user out, clears session.
 * 
 * @author Runi
 */
public class LogOutCommand extends Command
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
        request.getSession().invalidate();
        request.setAttribute("error", "You have succesfully logged out");
        return "index";
    }
    
}
