<%-- 
    Document   : orderdetails
    Created on : Mar 22, 2019, 9:41:08 AM
    Author     : Runi
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%
    User sessionUser = (User) request.getSession().getAttribute("user");
    Order o = (Order) request.getSession().getAttribute("order");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='Header.jsp'></jsp:include>
<h2>Order details: Order #<%=o.getOrderID() %> </h2>
<div id="orderDetailsMain">
    <p>User # <%= sessionUser.getId()%> | <%= sessionUser.getEmail()%></p>
    <p>Table goes here</p>

</div>

<jsp:include page='Footer.jsp'></jsp:include>
