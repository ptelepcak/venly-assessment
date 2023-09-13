package com.venly.assessment.controllers;

import com.venly.assessment.model.WordRelation;
import com.venly.assessment.model.enums.RelationType;
import com.venly.assessment.services.WordRelationService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/word-relation")
public class WordRelationController {

    private final WordRelationService wordRelationService;

    public WordRelationController(WordRelationService wordRelationService) {
        this.wordRelationService = wordRelationService;
    }

    @GetMapping("/")
    public List<WordRelation> getAllWordRelations() {
        return wordRelationService.getAllWordRelations();
    }

    @GetMapping("/{relationType}")
    public List<WordRelation> getWordRelationsByType(@NotNull @PathVariable RelationType relationType) {
        return wordRelationService.getWordRelationsByType(relationType);
    }

    @PutMapping("/{word1}/{word2}/{relationType}")
    public void putWordRelation(@NotBlank @PathVariable String word1, @NotBlank @PathVariable String word2, @NotNull @PathVariable RelationType relationType){
        wordRelationService.createWordRelation(word1, word2, relationType);
    }



}
