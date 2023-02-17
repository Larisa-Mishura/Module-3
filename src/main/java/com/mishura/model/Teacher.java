package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
public class Teacher extends Person{

    private Subject subject;

    public Teacher() {
        super();
    }

    public Teacher(String id, String firstName, String lastName, int age, Subject subject) {
        super(id, firstName, lastName, age);
        this.subject = subject;
    }

    public static class Builder extends Person.Builder{
        private Subject subject;

        @Override
        public Person.Builder withSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        @Override
        public Person build() {
            return new Teacher(id, firstName, lastName, age, subject);
        }
    }
}
