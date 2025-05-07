package com.ss2.ss2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "ex6", value = "/products")
public class Ex678Servlet extends HttpServlet {
    private static final ArrayList<Product> productList = new ArrayList<>();
    private static int currentId = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product found = null;
            for (Product p : productList) {
                if (p.getId() == id) {
                    found = p;
                    break;
                }
            }

            if (found != null) {
                request.setAttribute("product", found);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ex7.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("products");
            }

        } else {
            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ex6+8.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));

                if (name == null || name.isEmpty() || price < 0) {
                    throw new Exception("Thông tin không hợp lệ.");
                }

                for (Product p : productList) {
                    if (p.getId() == id) {
                        p.setName(name);
                        p.setPrice(price);
                        break;
                    }
                }

                request.setAttribute("message", "Cập nhật thành công!");
                response.sendRedirect("products");

            } catch (Exception e) {
                Product fallbackProduct = new Product();
                fallbackProduct.setId(Integer.parseInt(request.getParameter("id")));
                fallbackProduct.setName(request.getParameter("name"));
                fallbackProduct.setPrice(0);

                request.setAttribute("product", fallbackProduct);
                request.setAttribute("error", "Cập nhật không thành công: " + e.getMessage());
                request.getRequestDispatcher("ex7.jsp").forward(request, response);
            }

        } else if ("delete".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                productList.removeIf(p -> p.getId() == id);
            } catch (Exception e) {
            }
            response.sendRedirect("products");
        }else {
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            if (name != null && priceStr != null && !name.isEmpty() && !priceStr.isEmpty()) {
                double price = Double.parseDouble(priceStr);
                productList.add(new Product(currentId++, name, price));
            }

            response.sendRedirect("products");
        }
    }

}
