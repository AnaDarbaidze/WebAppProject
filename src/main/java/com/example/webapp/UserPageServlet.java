package com.example.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserPageServlet", value = "/UserPageServlet")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String mail = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeat-password");
        String profession = request.getParameter("profession");

        UserDao userDao = new UserDao();
        User user = (User) request.getSession().getAttribute("user");

        try {
            if (user.getUsername() != username && userDao.getUser(username) != null) {
                request.setAttribute("updateStatus", "uname taken");
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
                return;
            } else if (user.getEmail() != mail &&  userDao.getUserByEmail(mail) != null) {
                request.setAttribute("updateStatus", "mail taken");
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!username.isEmpty()) {
            user.setUsername(username);
        }
        if (!firstname.isEmpty()) {
            user.setFirstname(firstname);
        }
        if (!lastname.isEmpty()) {
            user.setLastname(lastname);
        }
        if (!mail.isEmpty()) {
            user.setEmail(mail);
        }
        if (!profession.isEmpty()) {
            user.setProfession(profession);
        }


        if (!password.isEmpty()) {
            if (password.equals(repeatedPassword)) {
                user.setPassword(password);
            } else {
                request.setAttribute("updateStatus", "pass mismatch");
                request.getRequestDispatcher("userPage.jsp").forward(request, response);
                return;
            }
        }

        userDao = new UserDao();
        try {
            userDao.updateUserData(user);
            request.getRequestDispatcher("userPage.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
