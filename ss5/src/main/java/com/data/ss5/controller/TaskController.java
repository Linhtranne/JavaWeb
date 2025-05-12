package com.data.ss5.controller;

import com.data.ss5.model.Task;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TaskController", value = "/tasks")
public class TaskController extends HttpServlet {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void init() throws ServletException {
        tasks.add(new Task(nextId++, "Đi mua sắm", "2025-05-15", false));
        tasks.add(new Task(nextId++, "Tham gia buổi yoga", "2025-05-16", true));
        tasks.add(new Task(nextId++, "Nấu bữa tối", "2025-05-17", false));
        tasks.add(new Task(nextId++, "Dọn dẹp nhà cửa", "2025-05-18", true));
        tasks.add(new Task(nextId++, "Gặp gỡ bạn bè", "2025-05-19", false));
        tasks.add(new Task(nextId++, "Đi dã ngoại cuối tuần", "2025-05-20", true));
        tasks.add(new Task(nextId++, "Xem phim tại rạp", "2025-05-21", false));
        tasks.add(new Task(nextId++, "Đọc sách mới mua", "2025-05-22", true));
        tasks.add(new Task(nextId++, "Chăm sóc cây cảnh", "2025-05-23", true));
        tasks.add(new Task(nextId++, "Đi tập gym", "2025-05-24", true));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                request.getRequestDispatcher("views/formTask.jsp").forward(request, response);
                break;
            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                for (Task task : tasks) {
                    if (task.getId() == editId) {
                        request.setAttribute("task", task);
                        break;
                    }
                }
                request.getRequestDispatcher("views/formTask.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("tasks", tasks);
                request.getRequestDispatcher("views/taskList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        switch (action) {
            case "create":
                Task newTask = new Task(
                        nextId++,
                        request.getParameter("description"),
                        request.getParameter("dueDate"),
                        request.getParameter("completed") != null
                );
                tasks.add(newTask);
                response.sendRedirect("tasks");
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                for (Task task : tasks) {
                    if (task.getId() == id) {
                        task.setDescription(request.getParameter("description"));
                        task.setDueDate(request.getParameter("dueDate"));
                        task.setCompleted(request.getParameter("completed") != null);
                        break;
                    }
                }
                response.sendRedirect("tasks");
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                tasks.removeIf(task -> task.getId() == deleteId);
                response.sendRedirect("tasks");
                break;
        }
    }
}