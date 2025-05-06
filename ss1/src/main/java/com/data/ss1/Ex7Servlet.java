package com.data.ss1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ex7")
public class Ex7Servlet extends HttpServlet {
    private static List<Student> studentList = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        super.init();
        studentList.add(new Student("Hehe", "12A2", "Xe máy", "22B1-999.88"));
        studentList.add(new Student("Hehehe", "12A2", "Xe máy", "Không có"));
        studentList.add(new Student("Hehehehe", "12A2", "Xe máy", "22B2-999.99"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("students", studentList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ex7.jsp");
        dispatcher.forward(req, resp);
    }
}
