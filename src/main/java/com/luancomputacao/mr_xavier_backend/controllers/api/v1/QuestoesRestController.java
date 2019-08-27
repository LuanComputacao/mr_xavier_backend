package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Questao;
import com.luancomputacao.mr_xavier_backend.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/questao")
public class QuestoesRestController {

    @Autowired
    QuestaoService questaoService;

    @GetMapping("/")
    public List<Questao> list() {
        List questoes = questaoService.list();
        return questoes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Questao questao = questaoService.findById(id);
        return ResponseEntity.ok(questao);
    }
}
