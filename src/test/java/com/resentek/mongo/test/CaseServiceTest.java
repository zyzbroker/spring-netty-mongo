package com.resentek.mongo.test;

import com.resentek.mongo.service.CaseService;
import com.resentek.mongo.test.config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
public class CaseServiceTest {
    private  final Logger log = LoggerFactory.getLogger(CaseServiceTest.class);
    @Autowired
    CaseService caseService;

    @BeforeEach
    void setupTestData() {
        log.info("---- setup test data ----");
        caseService.initData();
    }

    @AfterEach
    void teardownData() {
        log.info("---- delete test fata ----");
        caseService.deleteAll();
    }

    @Test
    void testFindAll() {
        assertEquals(2, caseService.findAll().size(),"two cases are init");
    }

    @Test
    @DisplayName("each test method will verify init data again")
    void testFindAll1() {
        assertEquals(2, caseService.findAll().size(),"two cases are init");
    }
}
