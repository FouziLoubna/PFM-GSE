package com.pfm.gse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfm.gse.models.Competence;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Long> {
    Competence findByCode(String code);

    Competence findByLibelle(String libelle);

    void deleteByCode(String code);
}
