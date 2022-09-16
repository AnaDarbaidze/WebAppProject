package com.example.webapp;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String getName = request.getParameter("email");
        request.setAttribute("ragaca", getName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userPage.jsp");
        dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}