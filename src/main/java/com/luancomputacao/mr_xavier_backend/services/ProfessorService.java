package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Professor;
import com.luancomputacao.mr_xavier_backend.repositories.ProfessorRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public List list() {
        Optional<List<Professor>> professores = Optional.of(professorRepository.findAll());
        return professores.orElseThrow(() -> new ObjectNotFoundException("Professores não encontrados"));
    }

    public Professor findById(Integer id){
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElseThrow(() -> new ObjectNotFoundException("Professor " + id + "não encontrado"));
    }

    public Professor insert(Professor obj) {
        obj.setId(null);
        return professorRepository.save(obj);
    }
}
