package Presentation;

import Presentation.Commands.LoginCommand;
import Presentation.Commands.RegisterCommand;
import Presentation.Commands.UnknownCommand;
import Presentation.Commands.OrderDetailsCommand;
import Logic.Exceptions.UserException;
import Presentation.Commands.CreateOrderCommand;
import Presentation.Commands.LogOutCommand;
import Presentation.Commands.RedirectCommand;
import Presentation.Commands.ShipOrderCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Available commands to use to navigate the site with FrontController
 * 
 * @author Runi
 */
public abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("login", new LoginCommand());
        commands.put("register", new RegisterCommand());
        commands.put("orderdetails", new OrderDetailsCommand());
        commands.put("createorder", new CreateOrderCommand());
        commands.put("shiporder", new ShipOrderCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("return", new RedirectCommand());
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

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws UserException
     */
    public abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws UserException;

}
