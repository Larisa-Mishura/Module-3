package com.mishura.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    protected int age;

    public Person() {
    }

    public Person(String id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static abstract class Builder{
        protected String id;
        protected String firstName;
        protected String lastName;
        protected int age;

        protected LocalDateTime dateOfEntrance;
        protected Group group;
        private Set<Grade> grades;

        protected Subject subject;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withDateOfEntrance(LocalDateTime dateOfEntrance) {
            return this;
        }

        public Builder withGroup(Group group) {
            return this;
        }

        public Builder withGrades(Set<Grade> grades) {
            return this;
        }

        public Builder withSubject(Subject subject) {
            return this;
        }

        public abstract Person build();
    }


}
