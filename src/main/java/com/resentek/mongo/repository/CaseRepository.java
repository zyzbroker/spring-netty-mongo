package com.resentek.mongo.repository;

import com.resentek.mongo.entities.Case;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CaseRepository extends MongoRepository<Case, String> {
    public Case findByName(String name);
    public List<Case> findListByName(String name);
}
