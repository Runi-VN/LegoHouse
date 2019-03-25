package PresentationLayer;

import PresentationLayer.Commands.Login;
import PresentationLayer.Commands.Register;
import PresentationLayer.Commands.UnknownCommand;
import PresentationLayer.Commands.OrderDetails;
import FunctionLayer.UserException;
import PresentationLayer.Commands.CreateOrderCommand;
import PresentationLayer.Commands.CustomerCommand;
import PresentationLayer.Commands.EmployeeCommand;
import PresentationLayer.Commands.ShipOrderCommand;
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
        commands.put("customer", new CustomerCommand());
        commands.put("employee", new EmployeeCommand());
        commands.put("createorder", new CreateOrderCommand());
        commands.put("shiporder", new ShipOrderCommand());
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
