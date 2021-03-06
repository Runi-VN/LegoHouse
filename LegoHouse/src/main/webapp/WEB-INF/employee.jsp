<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper

    Employee: Handles employee as a user object, allows to see all user orders and mark them sent.
    Also gives access to order details page.
--%>

<%@page import="Data.Entities.User"%>
<%@page import="Data.Entities.Order"%>
<%@page import="Logic.OrderFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='Header.jsp'></jsp:include>
<%
    ArrayList<Order> allOrders = (ArrayList<Order>) request.getAttribute("allOrders");
%>
<h2>Employee page</h2>
<h3>Hello ${user.email}</h3>
<p>You are now logged in as an <strong>EMPLOYEE</strong> of our wonderful site.</p>

<div id="Parent" class="col-md-offset-5">
    <div id="tablediv" class="padding">

        <label for="table">All system orders</label>
        <table class="table-condensed table-hover">
            <thead>
                <tr>
                    <th>OrderID</th>
                    <th>Status</th>
                    <th>UserID</th>
                    <th>Details</th>
                    <th>Ship order</th>
                </tr>
            </thead>
            <%for (int i = 0; i < allOrders.size(); i++)
                {
                    String statusMsg = "Processing";
            %> 
            <tr>
                <td> <%= allOrders.get(i).getOrderID()%></td>
                <td> <% if (allOrders.get(i).getStatus_sent() == true)
                    {
                        statusMsg = "Sent";
                    }%> <%=statusMsg%></td>
                <td> <%= allOrders.get(i).getUserID()%></td>
                <td> <a href="?command=orderdetails&id=<%= allOrders.get(i).getOrderID()%>"> Order details</a></td>
                <td>
                    <% if (allOrders.get(i).getStatus_sent() != true)
                        {%>

                    <form name="shiporder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="shiporder">
                        <input type="hidden" name="orderid" value="<%= allOrders.get(i).getOrderID()%>">
                        <input type="submit" value="Ship order"> 
                    </form>

                    <% } %>
                </td>
            </tr>
            <% }
            %>
        </table>
    </div>
</div>

<jsp:include page='Footer.jsp'></jsp:include>
