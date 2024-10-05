package com.example.quizAppVivek.dao;


import com.example.quizAppVivek.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :noOFQuestions", nativeQuery = true)
    List<Question> findRandomQuestion(@Param("category") String category, @Param("noOFQuestions") int noOFQuestions);

}
