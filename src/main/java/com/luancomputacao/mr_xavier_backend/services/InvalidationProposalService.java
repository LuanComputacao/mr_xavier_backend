package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.InvalidationProposal;
import com.luancomputacao.mr_xavier_backend.repositories.InvalidationProposalRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvalidationProposalService {
    @Autowired
    InvalidationProposalRepository invalidationProposalRepository;

    public List list() {
        Optional<List> invalidationProposal = Optional.of(invalidationProposalRepository.findAll());
        return invalidationProposal.orElseThrow(() -> new ObjectNotFoundException("Questions não encontradas"));
    }

    public InvalidationProposal findById(Integer id) {
        Optional<InvalidationProposal> invalidationProposal = invalidationProposalRepository.findById(id);
        return invalidationProposal.orElseThrow(() -> new ObjectNotFoundException("Questão " + id + " não encontrada"));
    }
}
