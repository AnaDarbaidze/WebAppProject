import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String username = request.getParameter("username");
        String mail = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeat-password");
        String profession = request.getParameter("profession");



        try {
            UserDao userDao = new UserDao();
            if(userDao.getUser(username) != null){
                request.setAttribute("status", "uname taken");
                request.getRequestDispatcher("registration.jsp").forward(request, resp);
                return;
            }else if(userDao.getUserByEmail(mail) != null) {
                request.setAttribute("status", "mail taken");
                request.getRequestDispatcher("registration.jsp").forward(request, resp);
                return;
            }else if(!password.equals(repeatedPassword)){
                request.setAttribute("status", "pass mismatch");
                request.getRequestDispatcher("registration.jsp").forward(request, resp);
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            UserDao userDao = new UserDao();
            User newUser = new User(username,firstname,lastname,password,mail,profession);
            userDao.addUser(newUser);
            request.getSession().setAttribute("user", newUser);
            request.getRequestDispatcher("user-page.jsp").forward(request,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}