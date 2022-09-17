<%@ page import="com.example.webapp.User" %><%--
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
                    background-color: #008080;
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
                    background-color: #008080;
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
        <form action="UserPageServlet" >
            <h1>User Page</h1><br>
            <h2>Hello <%=((User)request.getSession().getAttribute("user")).getUsername()%>!</h2>
            <div class="container">
            <label for="username">Enter your username:</label><br>
            <input type="text" id="username" name="username" placeholder="Username"  ><br><br>
            <label for="email">Enter your email:</label><br>
            <input type="text" id="email" name="email" placeholder="Email"  ><br><br>
            <label for="firstname">Enter your name:</label><br>
            <input type="text" id="firstname" name="firstname" placeholder="Name"  ><br><br>
            <label for="lastname">Enter your surname:</label><br>
            <input type="text" id="lastname" name="lastname" placeholder="Surname"  ><br><br>
            <label for="profession">Enter your profession:</label><br>
            <input type="text" id="profession" name="profession" placeholder="Profession" ><br><br>
            <label for="password">Enter your password:</label><br>
            <input type="password" id="password" name="password" placeholder="Password" ><br><br>
            <label for="repeat-password">Please, confirm password:</label><br>
            <input type="password" id="repeat-password" name="repeat-password" placeholder="Repeat password"  ><br><br>
                <%if(request.getAttribute("updateStatus") != null){%>
                <% if(request.getAttribute("updateStatus").equals("uname taken")){%>
                <label form="registration-form"> Username already taken! </label>
                <%} else if(request.getAttribute("updateStatus").equals("mail taken")){%>
                <label form="registration-form"> Mail already taken! </label>
                <%}else if(request.getAttribute("updateStatus").equals("pass mismatch")){%>
                <label form="registration-form"> passwords don't match! </label><br><br>
                <%}}%><br><br>
            <input type="submit" value="Update">
            </div>

        </form>
        <div class="container signOut">
            <p>Want to sign out? <a href="index.jsp">Sign out</a></p>
        </div>
        </body>
</html>
