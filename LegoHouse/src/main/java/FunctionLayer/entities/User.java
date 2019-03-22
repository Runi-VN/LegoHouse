package FunctionLayer.entities;

import java.util.List;
import java.util.Objects;

/**
 * The purpose of User is to...
 *
 * @author kasper
 */
public class User
{

    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private List<Order> orderList;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public void addToOrderList(Order order)
    {
       orderList.add(order);
    }

    public List<Order> getOrders()
    {
        return orderList;
    }

    public void setOrders(List<Order> orders)
    {
        this.orderList = orders;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.role);
        hash = 47 * hash + Objects.hashCode(this.orderList);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id)
        {
            return false;
        }
        if (!Objects.equals(this.email, other.email))
        {
            return false;
        }
        if (!Objects.equals(this.password, other.password))
        {
            return false;
        }
        if (!Objects.equals(this.role, other.role))
        {
            return false;
        }
        if (!Objects.equals(this.orderList, other.orderList))
        {
            return false;
        }
        return true;
    }

}
