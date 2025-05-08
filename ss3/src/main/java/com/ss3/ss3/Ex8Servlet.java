package com.ss3.ss3;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ex8")
public class Ex8Servlet extends HttpServlet {
    private List<Book> bookList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            int year = Integer.parseInt(request.getParameter("year"));

            bookList.add(new Book(name, author, year));
            request.setAttribute("message", "Thêm sách thành công!");
        } else if ("search".equals(action)) {
            String searchName = request.getParameter("searchName");
            List<Book> searchResults = new ArrayList<>();
            for (Book book : bookList) {
                if (book.getName().toLowerCase().contains(searchName.toLowerCase())) {
                    searchResults.add(book);
                }
            }
            request.setAttribute("searchResults", searchResults);
        }

        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("ex8.jsp").forward(request, response);
    }
}