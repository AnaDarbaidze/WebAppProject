import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

        User user = (User) request.getSession().getAttribute("user");

        if(!username.isEmpty()){
            user.setUsername(username);
        }
        if(!firstname.isEmpty()){
            user.setFirstname(firstname);
        }
        if(!lastname.isEmpty()){
            user.setLastname(lastname);
        }
        if(!mail.isEmpty()){
            user.setEmail(mail);
        }
        if(!profession.isEmpty()){
            user.setProfession(profession);
        }
        if(!password.isEmpty()){
            if(password.equals(repeatedPassword)) {
                user.setPassword(password);
            }else {
                request.setAttribute("updateStatus", "not same passwords idiot");
                request.getRequestDispatcher("user-page.jsp").forward(request,response);
            }
        }

        UserDao userDao = new UserDao();
        try {
            userDao.updateUserData(user);
            request.getRequestDispatcher("user-page.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
