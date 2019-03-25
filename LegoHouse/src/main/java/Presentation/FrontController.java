package Presentation;

import Logic.Exceptions.UserException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kasper
 */
@WebServlet(name = "FrontController", urlPatterns =
{
    "/FrontController"
})
public class FrontController extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            validateSession(request);
            Command action = Command.from(request);
            String view = action.execute(request, response);
            //System.out.println("This is your view: " + view);
            if (view.equals("index"))
            {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
            }
        }
        catch (UserException ex)
        {
            System.out.println(ex.getMessage());
            if (ex.toString().contains("for key 'email_UNIQUE'"))
            {
                request.setAttribute("error", "(E-mail): E-mail already exists");
            }
            else
            {
                request.setAttribute("error", "Error: FrontController Error(#1337):\n " + ex.getMessage());
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void validateSession(HttpServletRequest req) throws UserException
    {
        HttpSession session = req.getSession();
        if (!(req.getParameter("command").equals("login") || req.getParameter("command").equals("register")))
        {
            if (session == null || session.getAttribute("user") == null)
            {
                session.invalidate(); //to clear any extra attributes such as /userloggedin/.
                throw new UserException("Your session or user is invalid - try again.");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
