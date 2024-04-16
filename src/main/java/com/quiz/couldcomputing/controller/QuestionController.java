package com.quiz.couldcomputing.controller;

import com.quiz.couldcomputing.entity.Question;
import com.quiz.couldcomputing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){

        return new ResponseEntity<>(questionService.createQuestion(question),HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long id,@RequestBody Question question)
    {
        return new ResponseEntity<>(questionService.updateQuestion(id,question),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id)
    {
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>("Question deleted successfully",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return new ResponseEntity<>(questionService.getAllQuestion(),HttpStatus.OK);
    }

    @GetMapping("/subject/{subject}")
    public ResponseEntity<List<Question>> getAllQuestionsBySubject(@PathVariable String subject)
    {
        return new ResponseEntity<>(questionService.getAllQuestionsBySubject(subject),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id)
    {
        return new ResponseEntity<>(questionService.getQuestionById(id),HttpStatus.OK);
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<String>> getAllSubjects()
    {
        return new ResponseEntity<>(questionService.getAllSubjects(),HttpStatus.OK);
    }

    @GetMapping("/weeks")
    public ResponseEntity<List<String>> getAllWeeks()
    {
        return new ResponseEntity<>(questionService.getAllWeeks(),HttpStatus.OK);
    }

    @GetMapping("/subjects/{subject}")
    public ResponseEntity<List<Question>> getQuestionBySubject(@PathVariable String subject)
    {
        return new ResponseEntity<>(questionService.getAllQuestionsBySubject(subject),HttpStatus.OK);
    }



    @GetMapping("/subjects/{subject}/weeks/{week}")
    public ResponseEntity<List<Question>> getAllQuestionsBySubjectAndWeek(@PathVariable String subject,@PathVariable String week)
    {
        return new ResponseEntity<>(questionService.getALlQuestionsBySujectAndWeek(subject,week),HttpStatus.OK);
    }




}
