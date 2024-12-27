package com.pfm.gse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfm.gse.models.Professeur;

@Repository
public interface ProfesseurDao extends JpaRepository<Professeur, Long> {
    Professeur findByNumero(String numero);

    void deleteByNumero(String numero);
}
