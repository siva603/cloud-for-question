package com.quiz.couldcomputing.serviceImp;

public class QuestionNotFound extends RuntimeException {
    private String  msg;

    public QuestionNotFound(String msg) {
        super(msg);
        this.msg=msg;
    }
}
