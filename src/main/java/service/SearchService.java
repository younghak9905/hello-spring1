package service;

import domain.Question;
import repository.QuestionRepository;

import java.util.List;

public class SearchService {
    private final QuestionRepository questionRepository;

    public SearchService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> search(String query) {
        // Search through questions and tags to find matches
        return questionRepository.findByTitleContainingOrTagsContaining(query, query);
    }

}
