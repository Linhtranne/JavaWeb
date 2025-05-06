package com.data.ss1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ex3")
public class Ex3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "Trần Quang Linh";
        int age = 30;


        request.setAttribute("userName", name);
        request.setAttribute("userAge", age);


        RequestDispatcher dispatcher = request.getRequestDispatcher("ex3.jsp");
        dispatcher.forward(request, response);
    }
}
