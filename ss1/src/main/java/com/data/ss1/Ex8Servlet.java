package com.data.ss1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ex8")
public class Ex8Servlet extends HttpServlet {
    private static final List<Task> taskList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String description = req.getParameter("task");
        if (description != null && !description.trim().isEmpty()) {
            taskList.add(new Task(description));
        }
        resp.sendRedirect("todo"); // redirect lại chính nó
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String completeIndex = req.getParameter("complete");

        if (completeIndex != null) {
            try {
                int index = Integer.parseInt(completeIndex);
                if (index >= 0 && index < taskList.size()) {
                    taskList.get(index).setCompleted(true);
                }
            } catch (NumberFormatException ignored) {}
        }

        req.setAttribute("tasks", taskList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ex8.jsp");
        dispatcher.forward(req, resp);
    }
}
