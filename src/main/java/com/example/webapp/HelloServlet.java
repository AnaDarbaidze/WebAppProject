package com.example.webapp;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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