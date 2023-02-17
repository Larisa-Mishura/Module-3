package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Subject {

    @Id
    private String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }
}
