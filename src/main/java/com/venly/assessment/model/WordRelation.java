package com.venly.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.venly.assessment.model.enums.RelationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "word_relation",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"word1", "word2"})
        })
@Data
public class WordRelation {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @NotBlank(message = "Word cannot be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "Only letters are allowed")
    private String word1;
    @NotBlank(message = "Word cannot be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "Only letters are allowed")
    private String word2;
    private RelationType relationType;
    private Boolean inverse;
}

