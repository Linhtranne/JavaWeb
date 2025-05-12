package com.data.ss5.controller;

import com.data.ss5.model.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BlogController", value = "/blog")
public class BlogController extends HttpServlet {
    private List<Post> posts = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        posts.add(new Post(1, "Tình yêu đầu đời", "Những cảm xúc ngây ngô khi yêu lần đầu.", "Nguyễn Văn An", "2024-05-01"));
        posts.add(new Post(2, "Hạnh phúc từ những điều nhỏ", "Yêu là trân trọng từng khoảnh khắc nhỏ bé.", "Trần Thị Bình", "2024-05-02"));
        posts.add(new Post(3, "Giữ lửa yêu thương", "Bí quyết duy trì tình yêu bền vững.", "Lê Văn Cường", "2024-05-03"));
        posts.add(new Post(4, "Vượt qua giông bão", "Tình yêu cần sự sẻ chia và cảm thông.", "Phạm Thị Diễm", "2024-05-04"));
        posts.add(new Post(5, "Lời xin lỗi chân thành", "Khi yêu, xin lỗi không bao giờ là đủ.", "Ngô Quang Em", "2024-05-05"));
        posts.add(new Post(6, "Viết cho người cũ", "Những kỷ niệm buồn nhưng đáng trân trọng.", "Bùi Thiên Phúc", "2024-05-06"));
        posts.add(new Post(7, "Đợi chờ là hạnh phúc?", "Chờ đợi người mình yêu là đúng hay sai?", "Hoàng Minh Gia", "2024-05-07"));
        posts.add(new Post(8, "Tình yêu xa", "Khoảng cách có làm tình yêu phai nhạt?", "Đặng Thu Hà", "2024-05-08"));
        posts.add(new Post(9, "Khi tình yêu không còn như trước", "Nhận ra sự thay đổi và chấp nhận sự thật.", "Vũ Hoàng Kiên", "2024-05-09"));
        posts.add(new Post(10, "Bắt đầu lại từ đầu", "Dũng cảm yêu thêm lần nữa sau tổn thương.", "Lý Minh Khôi", "2024-05-10"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String postIdParam = request.getParameter("id");

        if (postIdParam != null) {
            int postId = Integer.parseInt(postIdParam);
            for (Post p : posts) {
                if (p.getId() == postId) {
                    request.setAttribute("post", p);
                    request.getRequestDispatcher("views/Bai9/postDetail.jsp").forward(request, response);
                    return;
                }
            }
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            request.setAttribute("posts", posts);
            request.getRequestDispatcher("views/Bai9/postList.jsp").forward(request, response);
        }
    }
}