package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
public class Teacher extends Person{

    @OneToOne(cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    //@JoinColumn(name = "subject_name")
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
