package com.quiz.couldcomputing.repsitory;


import com.quiz.couldcomputing.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query(value = "SELECT DISTINCT q.subject FROM QUESTION q",nativeQuery = true)
    List<String> findDistinctSubject();

    @Query(value = "SELECT DISTINCT q.week FROM QUESTION q",nativeQuery = true)
    List<String> findDistinctWeek();


    @Query(value = "SELECT * FROM Question q WHERE q.subject = :subject AND q.week = :week",nativeQuery = true)
    List<Question> findBySubjectAndWeek(@Param("subject") String subject, @Param("week") String week);

    List<Question> findBySubject(String subject);

}
