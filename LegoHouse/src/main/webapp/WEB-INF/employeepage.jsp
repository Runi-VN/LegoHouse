<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='Header.jsp'></jsp:include>
    <h2>Employee page</h2>
    <h3>Hello <%=request.getParameter("email")%> </h3>
<p>You are now logged in as an EMPLOYEE of our wonderful site.</p>

<p>See all orders</p>
<p>Change order status</p>

<jsp:include page='Footer.jsp'></jsp:include>
