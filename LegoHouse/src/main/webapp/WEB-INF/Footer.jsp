<%-- 
    Document   : Footer
    Created on : Mar 19, 2019, 8:27:34 PM
    Author     : Runi
--%>
<% String error = (String) request.getAttribute("error");
    if (error != null)
    {
        out.println("<h3 style=\"color: red;\">Message:</h3>");
        out.println(error);
    }
%>

<% if (request.getSession().getAttribute("userloggedin") != null)
    { %>
<div id="logout" style="margin-top: 15px;">
    <form id = "logoutform" action="FrontController" method="post">
        <input type="hidden" name="command" value="logout">
        <button class ="button" id="logoutbutton" type="submit"/>Log out</button>
    </form>
</div>
<% }%>
<div id="footer">
    <a id ="footerLink" href ="https://github.com/Runi-VN/LegoHouse" target="_blank">Project site</a>   
</div>
</body>
</html>

