package com.resentek.mongo.entities;

import org.springframework.data.annotation.Id;

public class Case {
    @Id
    public String id;
    public String name;
    public CaseStatus status;
    public String description;

    public Case() {}

    public Case(String name, String description) {
        this(name, description, CaseStatus.OPEN);
    }

    public Case(String name, String description, CaseStatus status){
        this.name = name;
        this.status = CaseStatus.OPEN;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Case[id=%s, name=%s, status=%s, description=:%s]",
                this.id, this.name, this.status, this.description
        );
    }
}
