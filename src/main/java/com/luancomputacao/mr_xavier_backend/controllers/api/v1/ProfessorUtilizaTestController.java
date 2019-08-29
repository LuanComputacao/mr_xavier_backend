package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.ProfessorUtilizaTest;
import com.luancomputacao.mr_xavier_backend.services.ProfessorUtilizaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/professor-utiliza-test")
public class ProfessorUtilizaTestController {
    @Autowired
    ProfessorUtilizaTestService professorUtilizaTestService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List professorUtilizaTestService = this.professorUtilizaTestService.list();
        return ResponseEntity.ok(professorUtilizaTestService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        ProfessorUtilizaTest professorUtilizaTestService = this.professorUtilizaTestService.findById(id);
        return ResponseEntity.ok(professorUtilizaTestService);
    }
}
