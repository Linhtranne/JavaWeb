package com.ss2.ss2;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ex1", value = "/lifecycle")
public class Ex1Servlet extends HttpServlet {
        @Override
        public void init() throws ServletException {
            super.init();
            System.out.println("Servlet đang được khởi tạo (init)");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("lifecycleSteps", new String[]{
                    "1. Khởi tạo (init)",
                    "2. Xử lý yêu cầu (service/doGet/doPost)",
                    "3. Hủy (destroy)"

            });
            req.getRequestDispatcher("/ex1.jsp").forward(req, resp);
        }

        @Override
        public void destroy() {
            super.destroy();
            System.out.println("Servlet đã bị hủy (destroy)");
        }
    }
