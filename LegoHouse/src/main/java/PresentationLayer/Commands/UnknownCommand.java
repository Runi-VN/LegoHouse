package PresentationLayer.Commands;

import FunctionLayer.UserException;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The purpose of UnknownCommand is to...
 *
 * @author kasper
 */
public class UnknownCommand extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String parameter = request.getParameter("command");
        StringBuffer path = request.getRequestURL();
        String msg = String.format("Unknown command \"%s\" AT %s <br><a href=\".\"><strong>Return to frontpage</strong></a>", parameter, path);
        throw new UserException(msg);
    }

}
