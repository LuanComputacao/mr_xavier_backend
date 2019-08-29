package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Question;
import com.luancomputacao.mr_xavier_backend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestoesRestController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List questoes = questionService.list();
        return ResponseEntity.ok(questoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Question question = questionService.findById(id);
        return ResponseEntity.ok(question);
    }
}
