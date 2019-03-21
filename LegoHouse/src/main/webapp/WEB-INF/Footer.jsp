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
<div id="footer">
    <a id ="footerLink" href ="https://github.com/Runi-VN/LegoHouse" target="_blank">Project site</a>   
</div>
</body>
</html>

