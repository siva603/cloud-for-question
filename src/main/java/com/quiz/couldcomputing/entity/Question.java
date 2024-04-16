package com.quiz.couldcomputing.entity;


import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String week;

    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private String questionType;

    @ElementCollection
    @Column(nullable = false)
    private List<String> choices;

    @ElementCollection
    @Column(nullable = false)
    private List<String> correctAnswers;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
