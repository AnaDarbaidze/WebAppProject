package com.example.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String unameOrmail = request.getParameter("email");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User currUser = userDao.getUser(unameOrmail);
            if(currUser == null) {
                request.setAttribute("loginStatus", "wrong uname");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return;
            }
            if(!currUser.getPassword().equals(password)){
                request.setAttribute("loginStatus", "incorrect pass");
                request.getRequestDispatcher("index.jsp").forward(request,response);
                return;
            }
            System.out.println("user exists");
            request.getSession().setAttribute("user", currUser);
            request.setAttribute("user", currUser);
            request.getRequestDispatcher("userPage.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
    }

}
