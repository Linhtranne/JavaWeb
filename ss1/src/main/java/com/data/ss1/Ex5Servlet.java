package com.data.ss1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ex5")
public class Ex5Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int result = 10 / 0;

            response.setContentType("text/html");
            response.getWriter().println("Kết quả là: " + result);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Đã xảy ra lỗi");
            request.getRequestDispatcher("ex5.jsp").forward(request, response);
        }
    }
}
