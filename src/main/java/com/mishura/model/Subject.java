package com.mishura.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//@Entity
public enum Subject {
    MATHEMATICS,
    PHYSICS,
    CHEMISTRY,
    BIOLOGY,
    PHILOSOPHY,
    ENGLISH,
    HISTORY;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne
    private Teacher teacher;
}
