
import Logic.Entities.Order;
import Logic.Entities.User;
import Logic.Exceptions.UserException;
import Logic.UserFacade;
import Logic.Entities.Bricks;
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
        
        Order or = new Order(23, 5, 1, 0);
        System.out.println(or.toString());
        Bricks br = new Bricks(11, 1, 0);
        System.out.println(br.toString());
        
        
        
        
//        UserFacade uf = new UserFacade();
//        try
//        {
//            uf.createUser("Johnson@dr.dk", "1234");
//        }
//        catch (UserException ex)
//        {
//            System.out.println("wrong");
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        /*
        User user = new User("", "", "");
        user.getOrders().add(new Order(0, 0, 0, 0));
         */ //it works - GOLDEN
    }

}
