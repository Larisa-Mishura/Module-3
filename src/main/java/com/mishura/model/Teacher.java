package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Teacher extends Person{

    @OneToOne(cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Subject subject;

    public Teacher() {

    }

    public Teacher(String id, String firstName, String lastName, int age, Subject subject) {
        super(id, firstName, lastName, age);
        this.subject = subject;
    }

    public static class Builder extends Person.Builder{
        private Subject subject;

        @Override
        public Builder withSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        @Override
        public Teacher build() {
            return new Teacher(id, firstName, lastName, age, subject);
        }
    }
}
