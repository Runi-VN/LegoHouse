<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper

    Customer:
    Handles customer as an user object and displays all their orders. Also handles new orders.
--%>
<%@page import="Logic.OrderFacade"%>
<%@page import="Data.Entities.User"%>
<%@page import="Data.Entities.Order"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page='Header.jsp'></jsp:include>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Order> allUserOrders = (ArrayList<Order>) request.getAttribute("allUserOrders");
%>
<h2>Customer Page</h2>
<h3>Hello ${user.email}</h3>
<p>You are now logged in as a <strong>CUSTOMER</strong> of our wonderful site.</p>

<div id="Parent" class="col-md-offset-5">
    <form id="allForms" name="createorder" action="FrontController" method="POST">
        <label>Make a new order:</label><br>
        <input type="hidden" name="command" value="createorder">
        <label for="height">Height (blocks)</label>
        <input name="height" type="number" style="width: 75px" min="5" max="50" title="Minimum 5" required placeholder="Height"><br> <!-- onkeypress="return (event.charCode == 8 || event.charCode == 0 || event.charCode == 13) ? null : event.charCode >= 48 && event.charCode <= 57"-->

        <label for="length">Length (dots)</label>
        <input name="length" type="number" style="width: 75px"min="8" max="100" title="Minimum 8" required placeholder="Length"><br> <!-- ^^^IMPORTANT: ABOVE CODE REQUIRES FIELD TYPE="TEXT"!^^^-->

        <label for="width">Width (dots)</label>
        <input name="width" type="number"  style="width: 75px"min="8" max="100" title="Minimum 8" required placeholder="Width"><br>

        <label for="door" style="display: inline-block">Door</label>
        <input type="checkbox" name="door" value="door"><br>

        <label for="window">Window</label>
        <input type="checkbox" name="window" value="window" ><br>

        <input type="submit" value="Finalize Order" style="margin-left: 50%" ><br>
    </form>
</div>

<%if (allUserOrders.size() > 0)
    {%>
<div id="tablediv" class="padding col-md-offset-5">


    <table id="allOrderstable" class="table-hover table-condensed">
        <label for="allOrdersTable" style="display: table-row-group">Previous orders</label><br>
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

<jsp:include page='Footer.jsp'></jsp:include>