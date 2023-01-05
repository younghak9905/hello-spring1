package controller;

import domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.SearchService;

import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.Stack;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Question> results = searchService.search(query);
        model.addAttribute("results", results);
        return "search";
    }
}








