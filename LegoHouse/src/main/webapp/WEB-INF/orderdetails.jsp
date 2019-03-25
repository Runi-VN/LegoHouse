<%-- 
    Document   : orderdetails
    Created on : Mar 22, 2019, 9:41:08 AM
    Author     : Runi
--%>

<%@page import="FunctionLayer.entities.Bricks"%>
<%@page import="FunctionLayer.entities.Order"%>
<%@page import="FunctionLayer.entities.User"%>
<%
    User sessionUser = (User) request.getSession().getAttribute("user");
    Order o = (Order) request.getAttribute("order");
    Bricks bricks = (Bricks) request.getAttribute("bricks");

    String statusMsg = "Processing";
    String doorMsg = "\u2718"; //"x" == "No"
    String windowMsg = "\u2718"; //"x" == "No"
    if (o.getStatus_sent() == true)
    {
        statusMsg = "Sent";
    }
    if (o.getHasDoor() == true)
    {
        doorMsg = "\u2713"; //"Checkmark" == yes
    }
    if (o.getHasWindow() == true)
    {
        windowMsg = "\u2713"; //"Checkmark" == yes
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='Header.jsp'></jsp:include>
<h2>Order details: Order #<%=o.getOrderID()%> </h2>
<div id="orderDetailsMain" style="margin-top: 15px">
    <p>User # <%= sessionUser.getId()%> | <%= sessionUser.getEmail()%></p>

    <div id="tablediv" class="padding">

        <label for="table" style="display: inline">Details for order #<%=o.getOrderID()%></label>
        <table id="orderDetailsTable" class="table-condensed table-striped col-md-offset-5">
            <thead>
            <th>Order ID</th>
            <th>Length</th>
            <th>Width</th>
            <th>Height</th>
            <th>Order status</th>
            </thead>

            <tr>
                <td> <%= o.getOrderID()%></td>
                <td> <%= o.getLength()%></td>
                <td> <%= o.getWidth()%></td>
                <td> <%= o.getHeight()%></td>
                <td> <%= statusMsg%></td>
            </tr>
        </table>
    </div>

    <table id="BrickDetailsTable" class="table-condensed table-striped col-md-offset-5 padding">
        <label for="BrickDeailsTable">Bill of Materials</label>
        <thead style="background-color: #4CAF50">
        <th>4x4 brick</th>
        <th>2x2 brick</th>
        <th>1x2 brick</th>
        <th>Window</th>
        <th>Door</th>
        <th>Total</th>
        </thead> 
        <tr>
            <td><%=bricks.getFours()%></td>
            <td><%=bricks.getTwos()%></td>
            <td><%=bricks.getOnes()%> </td>
            <td> <%= windowMsg%></td>
            <td> <%= doorMsg%></td>
            <td style="text-decoration: underline"><%=bricks.getTotal()%></td>
        </tr>
    </table>
    <br>


    <p><a href="FrontController?command=<%=sessionUser.getRole()%>">Return to your page</a></p>
</div>

<jsp:include page='Footer.jsp'></jsp:include>
