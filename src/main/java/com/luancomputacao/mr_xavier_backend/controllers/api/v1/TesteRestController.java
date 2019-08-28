package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Questao;
import com.luancomputacao.mr_xavier_backend.domain.Teste;
import com.luancomputacao.mr_xavier_backend.services.QuestaoService;
import com.luancomputacao.mr_xavier_backend.services.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teste")
public class TesteRestController {
    @Autowired
    TesteService testeService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List testes = testeService.list();
        return ResponseEntity.ok(testes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Teste teste = testeService.findById(id);
        return ResponseEntity.ok(teste);
    }
}
