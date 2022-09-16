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
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <style>
                body {
                    font-family: Arial, Helvetica, sans-serif;
                    background-color: black;
                }

                * {
                    box-sizing: border-box;
                }

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

                hr {
                    border: 1px solid #f1f1f1;
                    margin-bottom: 25px;
                }

                .signOut{
                    background-color: #04AA6D;
                    color: white;
                    padding: 16px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    width: 100%;
                    opacity: 0.9;
                }

                .signOut:hover {
                    opacity: 1;
                }

                a {
                    color: dodgerblue;
                }

                .signOut {
                    background-color: #008080;
                    text-align: center;
                }
            </style>
        </head>
        <body>
        <form action="registrationPage-servlet" >
            <h1>Hello <%=request.getAttribute("ragaca")%> </h1>
            <h3>Registration Page</h3><br>
            <div class="container">
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
            </div>

        </form>
        <div class="container signOut">
            <p>Want to sign out? <a href="index.jsp">Sign out</a></p>
        </div>
        </body>
</html>
