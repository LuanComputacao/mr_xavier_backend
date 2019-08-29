package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Subject;
import com.luancomputacao.mr_xavier_backend.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/subject")
public class SubjectsRestController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("/")
    public ResponseEntity<?> list(){
        List subjects = subjectService.list();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Optional<Subject> subject = Optional.ofNullable(subjectService.findById(id));
        return ResponseEntity.ok(subject);
    }
}
