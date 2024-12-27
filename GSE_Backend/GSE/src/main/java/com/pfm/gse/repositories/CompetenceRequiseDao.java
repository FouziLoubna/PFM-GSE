package com.pfm.gse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfm.gse.models.CompetenceRequise;

@Repository
public interface CompetenceRequiseDao extends JpaRepository<CompetenceRequise, Long> {
    CompetenceRequise findByCompetenceCodeAndTypeStageType(String code, String type);

    List<CompetenceRequise> findByCompetenceCode(String code);

    List<CompetenceRequise> findByTypeStageType(String type);

    void deleteByCompetenceCodeAndTypeStageType(String code, String type);
}
