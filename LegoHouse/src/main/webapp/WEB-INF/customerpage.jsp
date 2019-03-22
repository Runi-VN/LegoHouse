<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.OrderFacade"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
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
<h3>Hello <%=request.getParameter("email")%> </h3>
<p>You are now logged in as a customer of our wonderful site.</p>

<div id="Parent" class="col-md-offset-4">
    <form id="allForms" name="createOrder" action="FrontController" method="POST">
        <label>Make a new order:</label><br>
        <label for="height">Height (blocks)</label>
        <input type="number" min="1" placeholder="Height" required><br>
        <label for="length">Length (dots)</label>
        <input type="number" min="2" placeholder="Length" required><br>
        <label for="width">Width (dots)</label>
        <input type="number" min="2" placeholder="Width" required><br>
        <input type="submit" value="Submit">

        <div id="tablediv" class="padding">

            <label for="table">Previous orders</label>
            <table class="table">
                <tr>
                    <th>OrderID</th>
                    <th>Order status</th>
                    <th>Order Details</th>
                <tr>
                    <%for (int i = 0; i < allUserOrders.size(); i++)
                        {%>
                <tr>
                    <td> <%= allUserOrders.get(i).getOrderID()%></td>
                    <td> <%= allUserOrders.get(i).getStatus_sent()%></td>
                    <td> <a href="?command=orderdetails&id=<%=allUserOrders.get(i).getOrderID()%>"> Order details</a>
                    </td>
                </tr>
                <% }
                %>
            </table>
        </div>
        <!--</form>
        <form id="allForms" name="myOrders" action="FrontController" method="POST">
            <label>Previous orders</label><br>
            <input type="hidden" value="<%=user.getId()%>">
            <input type="submit" value="See old orders">
        </form>-->
</div>

<jsp:include page='Footer.jsp'></jsp:include>