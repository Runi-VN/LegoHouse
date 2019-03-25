package Presentation;

import Presentation.Commands.LoginCommand;
import Presentation.Commands.RegisterCommand;
import Presentation.Commands.UnknownCommand;
import Presentation.Commands.OrderDetailsCommand;
import Logic.Exceptions.UserException;
import Presentation.Commands.CreateOrderCommand;
import Presentation.Commands.CustomerCommand;
import Presentation.Commands.EmployeeCommand;
import Presentation.Commands.LogOutCommand;
import Presentation.Commands.ShipOrderCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{

    private static HashMap<String, Command> commands;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("login", new LoginCommand());
        commands.put("register", new RegisterCommand());
        commands.put("orderdetails", new OrderDetailsCommand());
        commands.put("customer", new CustomerCommand());
        commands.put("employee", new EmployeeCommand());
        commands.put("createorder", new CreateOrderCommand());
        commands.put("shiporder", new ShipOrderCommand());
        commands.put("logout", new LogOutCommand());
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
