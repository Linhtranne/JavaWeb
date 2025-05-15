package com.data.ss8.controller;


import com.data.ss8.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class QuizController {

    private final List<Question> questions = new ArrayList<>();

    public QuizController() {
        questions.add(new Question(1, "https://images.unsplash.com/photo-1574169208507-843761648bb8", "strawberry"));
        questions.add(new Question(2, "https://images.unsplash.com/photo-1592194996308-7b43879b85ff", "elephant"));
        questions.add(new Question(3, "https://images.unsplash.com/photo-1612197551773-2ff38fbcccf0", "parrot"));
        questions.add(new Question(4, "https://images.unsplash.com/photo-1582289951725-1e0e5cb31e86", "grape"));
        questions.add(new Question(5, "https://images.unsplash.com/photo-1593642634315-48f5414b3ad9", "laptop"));
    }

    @GetMapping("/quiz")
    public String showQuiz(Model model, HttpSession session) {
        Question question = questions.get(new Random().nextInt(questions.size()));
        session.setAttribute("question", question);
        session.setAttribute("attempts", 0);
        model.addAttribute("question", question);
        return "/quiz";
    }

    @PostMapping("/guess")
    public String handleGuess(@RequestParam("userAnswer") String userAnswer,
                              HttpSession session,
                              Model model) {
        Question question = (Question) session.getAttribute("question");
        Integer attempts = (Integer) session.getAttribute("attempts");
        if (attempts == null) attempts = 0;

        if (userAnswer.trim().equalsIgnoreCase(question.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("correct", true);
        } else {
            attempts++;
            session.setAttribute("attempts", attempts);
            if (attempts >= 3) {
                model.addAttribute("message", "Bạn hết lượt đoán.");
                model.addAttribute("outOfAttempts", true);
            } else {
                model.addAttribute("message", "Sai rồi! Bạn còn " + (3 - attempts) + " lượt.");
            }
        }

        model.addAttribute("question", question);
        return "quiz";
    }
}
