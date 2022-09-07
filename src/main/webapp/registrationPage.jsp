<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/7/2022
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="registration-servlet" >
  <label for="username">Enter your username or email:</label><br>
  <input type="text" id="username" name="username" placeholder="Username/Email" required ><br>

  <label for="firstname">Enter your name:</label><br>
  <input type="text" id="firstname" name="firstname" placeholder="Name" required ><br>

  <label for="lastname">Enter your surname:</label><br>
  <input type="text" id="lastname" name="lastname" placeholder="Surname" required ><br>

  <label for="profession">“Enter Your Profession:</label><br>
  <input type="text" id="profession" name="profession" placeholder="Profession" ><br>

  <label for="password">“Enter your password:</label><br>
  <input type="password" id="password" name="password" placeholder="Password" required><br>

  <label for="repeat-password">Please, confirm password:</label><br>
  <input type="password" id="repeat-password" name="repeat-password" placeholder="Repeat password" required ><br><br>

  <input type="submit" value="Register">

</form>
</body>
</html>
