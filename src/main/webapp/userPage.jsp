<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/7/2022
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
        <head>
            <title>User Page</title>
        </head>
        <body>
        <form action="registrationPage-servlet" >
            <h3>Registration Page</h3><br>
            <h1>Hello ragaca> </h1>
            <label for="username">Enter your username or email:</label><br>
            <input type="text" id="username" name="username" placeholder="Username/Email" required ><br><br>
            <label for="firstname">Enter your name:</label><br>
            <input type="text" id="firstname" name="firstname" placeholder="Name" required ><br><br>
            <label for="lastname">Enter your surname:</label><br>
            <input type="text" id="lastname" name="lastname" placeholder="Surname" required ><br><br>
            <label for="profession">Enter your profession:</label><br>
            <input type="text" id="profession" name="profession" placeholder="Profession" ><br><br>
            <label for="password">Enter your password:</label><br>
            <input type="password" id="password" name="password" placeholder="Password" required><br><br>
            <label for="repeat-password">Please, confirm password:</label><br>
            <input type="password" id="repeat-password" name="repeat-password" placeholder="Repeat password" required ><br><br>
            <input type="submit" value="Update">
        </form>
            <input  href="index.jsp" type="sumbit" value="Log out">
        </body>
</html>
