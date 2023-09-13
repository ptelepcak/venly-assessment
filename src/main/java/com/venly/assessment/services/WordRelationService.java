package com.venly.assessment.services;

import com.venly.assessment.model.WordRelation;
import com.venly.assessment.model.enums.RelationType;
import com.venly.assessment.repositories.WordRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordRelationService {
    private final WordRelationRepository wordRelationRepository;
    @Autowired
    public WordRelationService(WordRelationRepository wordRelationRepository){
        this.wordRelationRepository = wordRelationRepository;
    }

    public List<WordRelation> getAllWordRelations(Boolean includeInverses) {
        List<WordRelation> wordRelations = wordRelationRepository.findAll();
        if (includeInverses) {
            wordRelations.addAll(wordRelations.stream()
                    .map(wordRelation -> {
                        WordRelation inverseRelation = new WordRelation();
                        inverseRelation.setRelationType(wordRelation.getRelationType());
                        inverseRelation.setWord1(wordRelation.getWord2());
                        inverseRelation.setWord2(wordRelation.getWord1());
                        inverseRelation.setInverse(true);
                        return inverseRelation;
                    })
                    .toList());
        }
        return wordRelations;
    }

    public List<WordRelation> getWordRelationsByType(RelationType relationType) {
        return wordRelationRepository.findByRelationType(relationType);
    }

    public void createWordRelation(String word1, String word2, RelationType relationType){
        WordRelation wordRelation = new WordRelation();
        wordRelation.setWord1(word1);
        wordRelation.setWord2(word2);
        wordRelation.setRelationType(relationType);
        wordRelation.setInverse(false);
        wordRelationRepository.save(wordRelation);
    }
}
