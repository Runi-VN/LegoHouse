package PresentationLayer;

import PresentationLayer.Commands.Login;
import PresentationLayer.Commands.Register;
import PresentationLayer.Commands.UnknownCommand;
import PresentationLayer.Commands.OrderDetails;
import FunctionLayer.entities.UserException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("orderdetails", new OrderDetails());
    }

    static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter("command");
        if (commands == null)
        {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws UserException;

}
