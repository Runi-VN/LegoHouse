<%-- 
    Document   : Footer
    Created on : Mar 19, 2019, 8:27:34 PM
    Author     : Runi
--%>
<%
    /*
    Footer -- Handles error and logout button
    
     */
    String error = (String) request.getAttribute("error");
    if (error != null)
    {
        out.println("<h3 style=\"color: red;\">Message:</h3>");
        out.println(error);
    }
%>

<div id="footer">
    <div>
        <a id ="footerLink" href ="https://github.com/Runi-VN/LegoHouse" target="_blank">Project site</a>
    </div>
    <% if (request.getSession().getAttribute("userloggedin") != null)
        { %>
    <div id="logout">
        <form id = "logoutform" action="FrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <button id="logoutbutton" type="submit"/>Log out</button>
        </form>
    </div>
    <% }%>
</div>
</body>
</html>

