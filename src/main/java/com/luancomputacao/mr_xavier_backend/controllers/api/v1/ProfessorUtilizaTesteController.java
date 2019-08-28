package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.ProfessorUtilizaTeste;
import com.luancomputacao.mr_xavier_backend.domain.Questao;
import com.luancomputacao.mr_xavier_backend.services.ProfessorUtilizaTesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/professor-utiliza-teste")
public class ProfessorUtilizaTesteController {
    @Autowired
    ProfessorUtilizaTesteService professorUtilizaTesteService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List professorUtilizaTesteService = this.professorUtilizaTesteService.list();
        return ResponseEntity.ok(professorUtilizaTesteService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        ProfessorUtilizaTeste professorUtilizaTesteService = this.professorUtilizaTesteService.findById(id);
        return ResponseEntity.ok(professorUtilizaTesteService);
    }
}
