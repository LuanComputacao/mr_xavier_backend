package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Question;
import com.luancomputacao.mr_xavier_backend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionsRestController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List questions = questionService.list();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Question question = questionService.findById(id);
        return ResponseEntity.ok(question);
    }

    @PutMapping("/")
    public ResponseEntity<?> put(Question question) {
        return ResponseEntity.ok(question);
    }
}
