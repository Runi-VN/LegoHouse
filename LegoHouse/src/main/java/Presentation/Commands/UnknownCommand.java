package Presentation.Commands;

import Logic.Exceptions.UserException;
import Presentation.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles commands not known to FrontController.
 * 
 * e.g. FrontController?command=wtf
 *
 * @author kasper
 */
public class UnknownCommand extends Command
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
        String parameter = request.getParameter("command");
        StringBuffer path = request.getRequestURL();
        String msg = String.format("Unknown command \"%s\" AT %s <br><a href=\".\"><strong>Return to frontpage</strong></a>", parameter, path);
        throw new UserException(msg);
    }

}
