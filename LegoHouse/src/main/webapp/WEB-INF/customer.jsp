<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@page import="FunctionLayer.OrderFacade"%>
<%@page import="FunctionLayer.entities.User"%>
<%@page import="FunctionLayer.entities.Order"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page='Header.jsp'></jsp:include>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Order> allUserOrders = OrderFacade.getInstance().getAllUserOrders(user.getId());

    /*if (user == null) //should be handled in frontcontroller
    {
        request.setAttribute("error", "you messed up");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }*/
%>
<h2>Customer Page</h2>
<h3>Hello ${user.email}</h3>
<p>You are now logged in as a <strong>CUSTOMER</strong> of our wonderful site.</p>

<div id="Parent" class="col-md-offset-5">
    <form id="allForms" name="createorder" action="FrontController" method="POST">
        <label>Make a new order:</label><br>
        <input type="hidden" name="command" value="createorder">
        <label for="height">Height (blocks)</label>
        <input name="height" type="number" style="width: 75px" min="5" max="50"  required placeholder="Height"><br> <!-- onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57"-->

        <label for="length">Length (dots)</label>
        <input name="length" type="number" style="width: 75px"min="8" max="100" required placeholder="Length"><br> <!-- ^^^IMPORTANT: ABOVE CODE REQUIRES FIELD TYPE="TEXT"!^^^-->

        <label for="width">Width (dots)</label>
        <input name="width" type="number"  style="width: 75px"min="8" max="100" required placeholder="Width"><br>

        <label for="door">Door</label>
        <input type="checkbox" name="door" value="door"><br>

        <label for="window">Window</label>
        <input type="checkbox" name="window" value="window"><br>

        <input type="submit" value="Finalize Order"></button>
    </form>
</div>

<%if (allUserOrders.size() > 0)
    {%>
<div id="tablediv" class="padding col-md-offset-5">

    <label for="table" style="display: inline;">Previous orders</label>
    <table id="allOrderstable" class="table-hover table-condensed">
        <thead>
        <tr>
            <th>OrderID</th>
            <th>Order status</th>
            <th>Order Details</th>
        </tr>
        </thead>
        <%for (int i = 0; i < allUserOrders.size(); i++)
            {
                String statusMsg = "Processing";
        %> 
        <tr>
            <td> <%= allUserOrders.get(i).getOrderID()%></td>
            <td> <% if (allUserOrders.get(i).getStatus_sent() == true)
                {
                    statusMsg = "Sent";
                }%> <%=statusMsg%></td>
            <td> <a href="?command=orderdetails&id=<%=allUserOrders.get(i).getOrderID()%>"> Order details</a>
            </td>
        </tr>
        <% }
        %>
    </table>
</div>
<%}%>
<!--</form>
<form id="allForms" name="myOrders" action="FrontController" method="POST">
    <label>Previous orders</label><br>
    <input type="hidden" value="<%=user.getId()%>">
    <input type="submit" value="See old orders">
</form>-->


<jsp:include page='Footer.jsp'></jsp:include>