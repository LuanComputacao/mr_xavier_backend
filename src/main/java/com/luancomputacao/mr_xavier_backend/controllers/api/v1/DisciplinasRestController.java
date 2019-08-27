package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Disciplina;
import com.luancomputacao.mr_xavier_backend.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinasRestController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping("/")
    public ResponseEntity<?> list(){
        List disciplinas = disciplinaService.list();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Optional<Disciplina> disciplina = Optional.ofNullable(disciplinaService.findById(id));
        return ResponseEntity.ok(disciplina);
    }
}
