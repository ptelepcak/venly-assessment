package com.venly.assessment.services;

import com.venly.assessment.model.WordRelation;
import com.venly.assessment.model.enums.RelationType;
import com.venly.assessment.repositories.WordRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordRelationService {
    private final WordRelationRepository wordRelationRepository;
    @Autowired
    public WordRelationService(WordRelationRepository wordRelationRepository){
        this.wordRelationRepository = wordRelationRepository;
    }

    public List<WordRelation> getAllWordRelations() {
        return wordRelationRepository.findAll();
    }

    public void createWordRelation(String word1, String word2, RelationType relationType){
        WordRelation wordRelation = new WordRelation();
        wordRelation.setWord1(word1);
        wordRelation.setWord2(word2);
        wordRelation.setRelationType(relationType);
        wordRelationRepository.save(wordRelation);
    }
}
