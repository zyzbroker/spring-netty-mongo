package com.resentek.mongo.controller;

import com.resentek.mongo.entities.Case;
import com.resentek.mongo.service.CaseService;
import com.resentek.mongo.service.HtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.html.HTMLSelectElement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CaseController {
    private ApplicationContext context;
    private CaseService caseService;
    private HtmlService htmlService;

    public CaseController(ApplicationContext context, CaseService caseService, HtmlService htmlService){
        this.context = context;
        this.caseService = caseService;
        this.htmlService = htmlService;
    }

    @GetMapping(path = "/beans")
    public Mono<String> getBeans() {
        return Mono.just(htmlService.genHTML(context.getBeanDefinitionNames()));
    }
    @GetMapping(path="/cases")
    public Flux<List<Case>> index(){
        return Flux.just(caseService.findAll());
    }
}
