<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Log in page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                background-color: black;
            }

            * {
                box-sizing: border-box;
            }

            /* Add padding to containers */
            .container {
                padding: 16px;
                background-color: white;
            }

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                display: inline-block;
                border: none;
                background: #f1f1f1;
            }

            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            /* Overwrite default styles of hr */
            hr {
                border: 1px solid #f1f1f1;
                margin-bottom: 25px;
            }

            /* Set a style for the submit button */
            .logbtn{
                background-color: #04AA6D;
                color: white;
                padding: 16px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }

            .logbtn:hover {
                opacity: 1;
            }

            /* Add a blue text color to links */
            a {
                color: dodgerblue;
            }

            /* Set a grey background color and center the text of the "sign in" section */
            .register {
                background-color: #f1f1f1;
                text-align: center;
            }
        </style>
<%--        class="login-form"--%>
    </head>
    <body>
    <form action="/LoginServlet">
        <div class="container">
        <h1>Login</h1>
        <label for="email">Enter your username or email:</label><br>
        <input type="text" id="email" name="email" required><br><br>
        <label for="password">Enter your password:</label><br>
        <input type="password" id="password" name="password" required><br><br>
<%--        <input type="Submit" value="Log in"><br><br>--%>
            <button type="submit" class="logbtn">Log in</button>
        </div>
        <div class="container register">
            <p>Don't have an account? <a href="registrationPage.jsp">Register</a></p>
        </div>
    </form>
<%--    <a href="registrationPage.jsp"> Register </a>--%>
    </body>
</html>