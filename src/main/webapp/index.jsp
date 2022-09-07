<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
    <form action="/action_page.php">
        <h1>Welcome to new social network - Anagram!</h1>
        <h3>Please Log in</h3>
        <label for="email">Enter your username or email:</label><br>
        <input type="text" id="email" name="email" required><br><br>
        <label for="password">Enter your password:</label><br>
        <input type="text" id="password" name="password" required><br><br>
        <input type="Submit" value="Log in"><br><br>
    </form>
    <a href="registrationPage.jsp"> Register </a>
    </body>
</html>