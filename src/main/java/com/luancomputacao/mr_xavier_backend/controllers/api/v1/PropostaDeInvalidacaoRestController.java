package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.PropostaDeInvalidacao;
import com.luancomputacao.mr_xavier_backend.domain.Questao;
import com.luancomputacao.mr_xavier_backend.services.PropostaDeInvalidacaoService;
import com.luancomputacao.mr_xavier_backend.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/proposta-de-invalidacao")
public class PropostaDeInvalidacaoRestController {

    @Autowired
    PropostaDeInvalidacaoService propostaDeInvalidacaoService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List propostasDeInvalidacao = propostaDeInvalidacaoService.list();
        return ResponseEntity.ok(propostasDeInvalidacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        PropostaDeInvalidacao propostaDeInvalidacao = propostaDeInvalidacaoService.findById(id);
        return ResponseEntity.ok(propostaDeInvalidacao);
    }
}
