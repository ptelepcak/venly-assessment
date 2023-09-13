package com.venly.assessment.repositories;

import com.venly.assessment.model.WordRelation;
import com.venly.assessment.model.enums.RelationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRelationRepository extends JpaRepository<WordRelation, Long> {
    List<WordRelation> findByRelationType(RelationType relationType);
    boolean existsByWord1AndWord2AndRelationType(String word1, String word2, RelationType relationType);
}
