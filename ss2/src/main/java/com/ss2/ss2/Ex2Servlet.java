package com.ss2.ss2;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (name = "ex2", value = "/userinfo")
public class Ex2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        request.setAttribute("name", name);
        request.setAttribute("age", age);

        // Forward to JSP page
        request.getRequestDispatcher("/ex2.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ex2.jsp").forward(request, response);
    }
}
