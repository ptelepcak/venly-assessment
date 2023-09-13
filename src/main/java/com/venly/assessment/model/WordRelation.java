package com.venly.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.venly.assessment.model.enums.RelationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class WordRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String word1;
    private String word2;
    private RelationType relationType;
    private Boolean inverse;
}

