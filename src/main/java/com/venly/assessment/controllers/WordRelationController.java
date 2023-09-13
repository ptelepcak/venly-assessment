package com.venly.assessment.controllers;

import com.venly.assessment.model.WordRelation;
import com.venly.assessment.model.enums.RelationType;
import com.venly.assessment.services.WordRelationService;
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

    @PutMapping("/{word1}/{word2}/{relationType}")
    public void putWordRelation(@PathVariable String word1, @PathVariable String word2, @PathVariable RelationType relationType){
        wordRelationService.createWordRelation(word1, word2, relationType);
    }



}
