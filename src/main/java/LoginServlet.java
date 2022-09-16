import com.example.webapp.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String unameOrmail = request.getParameter("username");
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
            request.getSession().setAttribute("user", currUser);
            request.setAttribute("user", currUser);
            request.getRequestDispatcher("user-page.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
    }

}
