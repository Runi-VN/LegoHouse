
import FunctionLayer.Order;
import FunctionLayer.User;
import FunctionLayer.UserException;
import FunctionLayer.UserFacade;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Runi
 */
public class Main
{

    public static void main(String[] args)
    {
        UserFacade uf = new UserFacade();
        try
        {
            uf.createUser("Johnson@dr.dk", "1234");
        }
        catch (UserException ex)
        {
            System.out.println("wrong");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        User user = new User("", "", "");
        user.getOrders().add(new Order(0, 0, 0, 0));
         */ //it works - GOLDEN
    }

}
