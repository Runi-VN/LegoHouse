<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<jsp:include page='WEB-INF/Header.jsp'></jsp:include>
    <h2>Welcome to LegoHouse</h2>
    <div id="Parent" class="col-md-offset-4">
        <form id="allForms" name="login" action="FrontController" method="POST" class="">
            <label for="login">Login</label><br>
            <input type="hidden" name="command" value="login">
            <label for="email">E-mail</label>
            <input type="email" name="email" value="" placeholder="E-mail" required>
            <br> <label for="password">Password</label>
            <input type="password" name="password" placeholder="Password" required>
            <br>
            <input id="submitButton" type="submit" value="Submit">
        </form>

        <form id="allForms" name="register" action="FrontController" method="POST" class="">
            <label for="login"> Register</label><br>
            <input type="hidden" name="command" value="register">
            <label for="email">E-mail</label>
            <input type="email" name="email" placeholder="E-mail" required>
            <br>
            <label for="password1">Password</label>
            <input type="password" name="password1" placeholder="Password" required>
            <br>
            <label for="password2">Retype password</label>
            <input type="password" name="password2" placeholder="Same password"required >
            <br>
            <input id="submitButton" type="submit" value="Submit">
        </form>
    </div>


<jsp:include page='WEB-INF/Footer.jsp'></jsp:include>
