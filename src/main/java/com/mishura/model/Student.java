package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
public class Student extends Person{

    @Column(name = "date_of_entrance")
    private LocalDateTime dateOfEntrance;

    @Transient
    private Group group;

    @Transient
    private Set<Grade> grades;

    public Student(){
        super();
    }

    public Student(String id, String firstName, String lastName, int age, LocalDateTime dateOfEntrance, Group group, Set<Grade> grades) {
        super(id, firstName, lastName, age);
        this.dateOfEntrance = dateOfEntrance;
        this.group = group;
        this.grades = grades;
    }

    public static class Builder extends Person.Builder{

        private LocalDateTime dateOfEntrance;
        private Group group;
        private Set<Grade> grades;

        @Override
        public Person.Builder withDateOfEntrance(LocalDateTime dateOfEntrance) {
            this.dateOfEntrance = dateOfEntrance;
            return this;
        }

        @Override
        public Person.Builder withGroup(Group group) {
            this.group = group;
            return this;
        }

        @Override
        public Person.Builder withGrades(Set<Grade> grades) {
            this.grades = grades;
            return this;
        }

        @Override
        public Person build() {
            return new Student(id, firstName, lastName, age, dateOfEntrance, group, grades);
        }
    }
}
