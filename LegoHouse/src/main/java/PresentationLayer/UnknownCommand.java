package PresentationLayer;

import FunctionLayer.UserException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws UserException {
        String msg = "Unknown command. <a href=\".\">Return to frontpage</a>.";
        throw new UserException( msg );
    }

}
