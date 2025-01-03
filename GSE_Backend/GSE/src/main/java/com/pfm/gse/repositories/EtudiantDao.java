package com.pfm.gse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfm.gse.models.Etudiant;

public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Etudiant findByNumero(String numero);

    List<Etudiant> findByPromotionAnnee(String annee);

    void deleteByNumero(String numero);
}
