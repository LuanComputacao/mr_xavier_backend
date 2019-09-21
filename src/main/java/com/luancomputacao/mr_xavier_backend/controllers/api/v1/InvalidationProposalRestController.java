package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.InvalidationProposal;
import com.luancomputacao.mr_xavier_backend.services.InvalidationProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/invalidation-proposal")
public class InvalidationProposalRestController {

    @Autowired
    InvalidationProposalService invalidationProposalService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        List invalidationProposals = invalidationProposalService.list();
        return ResponseEntity.ok(invalidationProposals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        InvalidationProposal invalidationProposal = invalidationProposalService.findById(id);
        return ResponseEntity.ok(invalidationProposal);
    }
}
