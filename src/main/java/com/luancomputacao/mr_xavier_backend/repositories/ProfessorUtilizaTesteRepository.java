package com.luancomputacao.mr_xavier_backend.repositories;

import com.luancomputacao.mr_xavier_backend.domain.ProfessorUtilizaTeste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorUtilizaTesteRepository extends JpaRepository<ProfessorUtilizaTeste, Integer> {
}
