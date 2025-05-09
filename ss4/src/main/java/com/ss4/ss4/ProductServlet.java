package com.ss4.ss4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "1", 4, "7"));
        products.add(new Product(2, "2", 5, "8"));
        products.add(new Product(3, "3", 6, "9"));

        req.setAttribute("productList", products);
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }
}