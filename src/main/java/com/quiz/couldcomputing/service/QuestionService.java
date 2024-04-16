package com.quiz.couldcomputing.service;

import com.quiz.couldcomputing.entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestion();

    Question getQuestionById(Long id);

    List<String> getAllSubjects();
    List<String> getAllWeeks();

    String updateQuestion(Long id,Question question);

    void deleteQuestionById(Long id);

    List<Question> getAllQuestionsBySubject(String subject);


    List<Question> getALlQuestionsBySujectAndWeek(String subject,String week);
}
