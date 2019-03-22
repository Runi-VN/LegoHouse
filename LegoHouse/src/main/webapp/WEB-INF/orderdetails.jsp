<%-- 
    Document   : orderdetails
    Created on : Mar 22, 2019, 9:41:08 AM
    Author     : Runi
--%>

<%@page import="FunctionLayer.User"%>
<%
    User sessionUser = (User) request.getSession().getAttribute("user");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='Header.jsp'></jsp:include>

    <div id="orderDetailsMain">



    </div>

<jsp:include page='Footer.jsp'></jsp:include>
