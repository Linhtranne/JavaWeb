package com.ss2.ss2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;

@WebServlet("/guess")
public class Ex9Servlet extends HttpServlet {
    private String getRandomWord() {
        int wordLength = new Random().nextInt(5) + 3;
        StringBuilder word = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < wordLength; i++) {
            char letter = (char) ('a' + rand.nextInt(26));
            word.append(letter);
        }
        return word.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String hiddenWord = getRandomWord();
        session.setAttribute("hiddenWord", hiddenWord);
        session.setAttribute("attemptsLeft", 5);
        session.setAttribute("message", "");
        session.setAttribute("displayHint", getHint(hiddenWord));

        request.getRequestDispatcher("ex9.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String hiddenWord = (String) session.getAttribute("hiddenWord");
        int attemptsLeft = (int) session.getAttribute("attemptsLeft");
        String guess = request.getParameter("guess");

        if (guess != null && !guess.trim().isEmpty()) {
            guess = guess.trim().toLowerCase();
            if (guess.equals(hiddenWord)) {
                session.setAttribute("message", "🎉 Chúc mừng! Bạn đã đoán đúng từ: " + hiddenWord);
            } else {
                attemptsLeft--;
                if (attemptsLeft <= 0) {
                    session.setAttribute("message", " Bạn đã thua! Từ đúng là: " + hiddenWord);
                } else {
                    session.setAttribute("message", "Sai rồi! Hãy thử lại.");
                }
            }
        }

        session.setAttribute("attemptsLeft", attemptsLeft);
        session.setAttribute("displayHint", getHint(hiddenWord));

        request.getRequestDispatcher("ex9.jsp").forward(request, response);
    }

    private String getHint(String word) {
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        boolean[] revealed = new boolean[word.length()];
        int count = 0;
        while (count < 2) {
            int i = rand.nextInt(word.length());
            if (!revealed[i]) {
                revealed[i] = true;
                count++;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (revealed[i]) {
                result.append(word.charAt(i));
            } else {
                result.append("_");
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
