package com.example.quizAppVivek.controller;

import com.example.quizAppVivek.model.Question;
import com.example.quizAppVivek.model.QuestionWrapper;
import com.example.quizAppVivek.model.Response;
import com.example.quizAppVivek.service.QuizService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOFQuestions, @RequestParam String title){
        return  quizService.createQuiz(category,noOFQuestions,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);

    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);

    }


}
