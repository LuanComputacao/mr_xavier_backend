package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Subject;
import com.luancomputacao.mr_xavier_backend.repositories.SubjectRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List list() {
        Optional<List> subjects = Optional.of(subjectRepository.findAll());
        return subjects.orElseThrow(() -> new ObjectNotFoundException("Professores não encontrados"));
    }

    public Subject findById(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElseThrow(() -> new ObjectNotFoundException("Professor " + id +" não encontrado"));
    }

}
