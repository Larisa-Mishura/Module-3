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

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_grade",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id"))
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
        public Builder withDateOfEntrance(LocalDateTime dateOfEntrance) {
            this.dateOfEntrance = dateOfEntrance;
            return this;
        }

        @Override
        public Builder withGroup(Group group) {
            this.group = group;
            return this;
        }

        @Override
        public Builder withGrades(Set<Grade> grades) {
            this.grades = grades;
            return this;
        }

        @Override
        public Student build() {
            return new Student(id, firstName, lastName, age, dateOfEntrance, group, grades);
        }
    }
}
