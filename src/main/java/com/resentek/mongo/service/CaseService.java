package com.resentek.mongo.service;

import com.resentek.mongo.entities.Case;
import com.resentek.mongo.repository.CaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CaseService {
    private CaseRepository caseRepo;
    private Logger logger = LoggerFactory.getLogger(CaseService.class);

    public CaseService(CaseRepository caseRepo){
        this.caseRepo = caseRepo;
    }

    public void initData() {
        logger.info("-- load data into mongodb --");
        caseRepo.deleteAll();
        caseRepo.saveAll(Arrays.asList(
           new Case("case 1", "case description"),
           new Case( "case 2", "case 2 description")
        ));
        logger.info("-- end of load data --");
    }

    public List<Case> findAll() {
        return caseRepo.findAll();
    }
}
