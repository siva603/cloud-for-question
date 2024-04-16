package com.quiz.couldcomputing.serviceImp;


import com.quiz.couldcomputing.entity.Question;
import com.quiz.couldcomputing.repsitory.QuestionRepository;
import com.quiz.couldcomputing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {

        Question question=questionRepository.findById(id).orElseThrow(
                () -> new QuestionNotFound(String.format("Question not found with this id %d",id))
        );

        return question;
    }

    @Override
    public List<String> getAllSubjects() {
        return questionRepository.findDistinctSubject();
    }

    @Override
    public List<String> getAllWeeks() {
        return questionRepository.findDistinctWeek();
    }

    @Override
    public String updateQuestion(Long id,Question question) {

        Question updatedQuestion =questionRepository.findById(id).orElseThrow(
                () -> new QuestionNotFound(String.format("Question not found with this id %d",id))
        );
        updatedQuestion.setQuestionType(question.getQuestionType());
        updatedQuestion.setSubject(question.getSubject());
        updatedQuestion.setWeek(question.getWeek());
        updatedQuestion.setQuestion(question.getQuestion());
        updatedQuestion.setChoices(question.getChoices());
        updatedQuestion.setCorrectAnswers(question.getCorrectAnswers());

        questionRepository.save(updatedQuestion);

        return "Question updated successfully";

    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getAllQuestionsBySubject(String subject) {
        return questionRepository.findBySubject(subject);
    }


    @Override
    public List<Question> getALlQuestionsBySujectAndWeek(String subject, String week) {
        return questionRepository.findBySubjectAndWeek(subject,week);
    }


}
