package com.luancomputacao.mr_xavier_backend.services;

import com.luancomputacao.mr_xavier_backend.domain.Materia;
import com.luancomputacao.mr_xavier_backend.repositories.MateriaRepository;
import com.luancomputacao.mr_xavier_backend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    public List list() {
        Optional<List<Materia>> professores = Optional.of(materiaRepository.findAll());
        return professores.orElseThrow(() -> new ObjectNotFoundException("Materias não encontrados"));
    }

    public Materia findById(Integer id){
        Optional<Materia> materia = materiaRepository.findById(id);
        return materia.orElseThrow(() -> new ObjectNotFoundException("Materia " + id + "não encontrado"));
    }

}
