package controller;

import domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.QuestionService;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    public void saveQuestion(Question question) {
        questionService.saveQuestion(question);
    }



    @PostMapping("/questions")
    public String postQuestion(@ModelAttribute Question question, Model model) {
        // Save the question to the database using the questionService
        questionService.saveQuestion(question);
        // Redirect to the homepage
        return "redirect:/";
    }


}
