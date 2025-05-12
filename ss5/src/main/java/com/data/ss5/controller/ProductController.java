package com.data.ss5.controller;

import com.data.ss5.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() {
        productList.add(new Product(1, "A", 1, "iPhone 16"));
        productList.add(new Product(2, "B", 2, "iPhone 15"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", productList);
        request.getRequestDispatcher("views/product.jsp").forward(request, response);
    }
}