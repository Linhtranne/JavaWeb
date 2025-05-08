package com.ss3.ss3;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class Ex6Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Product product = new Product(0, productName, price, description, stock, status);
        List<Product> productList = (List<Product>) getServletContext().getAttribute("productList");
        if (productList == null) {
            productList = new ArrayList<>();
        }
        product.setId(productList.size() + 1); // Auto-increment ID
        productList.add(product);

        // Store the updated list in the ServletContext
        getServletContext().setAttribute("productList", productList);
        response.sendRedirect("ex6.jsp");
    }
}