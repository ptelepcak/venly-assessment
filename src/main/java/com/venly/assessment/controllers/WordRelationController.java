package com.venly.assessment.controllers;

import com.venly.assessment.model.WordRelation;
import com.venly.assessment.model.enums.RelationType;
import com.venly.assessment.services.WordRelationService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/word-relation")
public class WordRelationController {

    private final WordRelationService wordRelationService;

    public WordRelationController(WordRelationService wordRelationService) {
        this.wordRelationService = wordRelationService;
    }

    @GetMapping()
    public List<WordRelation> getAllWordRelations(@RequestParam(name = "includeInverses", defaultValue = "false") Boolean includeInverses) {
        return wordRelationService.getAllWordRelations(includeInverses);
    }

    @GetMapping("/{relationType}")
    public List<WordRelation> getWordRelationsByType(@NotNull @PathVariable RelationType relationType) {
        return wordRelationService.getWordRelationsByType(relationType);
    }

    @PutMapping("/{word1}/{word2}/{relationType}")
    public ResponseEntity<String> putWordRelation(@PathVariable @NotBlank String word1, @PathVariable String word2, @NotNull @PathVariable RelationType relationType){
        try {
            wordRelationService.createWordRelation(word1, word2, relationType);
        }
        catch (ConstraintViolationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Success");
    }


}
