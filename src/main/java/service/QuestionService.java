package service;

import domain.Question;
import org.springframework.stereotype.Service;
import repository.QuestionRepository;


@Service
public class QuestionService {


    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);

        // Save the question to the database


    }

    public void searchQuestion(Question question) {
        questionRepository.save(question);

        // Save the question to the database
    }
}
