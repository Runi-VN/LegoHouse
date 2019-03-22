package PresentationLayer.Commands;

import FunctionLayer.entities.UserFacade;
import FunctionLayer.entities.UserException;
import FunctionLayer.entities.User;
import PresentationLayer.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    public String execute( HttpServletRequest request, HttpServletResponse response ) throws UserException {
        UserFacade uf = new UserFacade();
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = uf.createUser( email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new UserException( "The two passwords did not match" );
        }
    }

}
