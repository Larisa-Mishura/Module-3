package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String gradeId;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Subject subject;

    private int mark;

    @ManyToMany(mappedBy = "grades")
    private Set<Student> students;

    public Grade() {
    }

    public Grade(Subject subject, int mark, Set<Student> students) {
        this.subject = subject;
        this.mark = mark;
        this.students = students;
    }

    public static class Builder{
        private String id;
        private Subject subject;
        private int mark;
        private Set<Student> students;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder withMark(int mark) {
            if(mark > 5 || mark < 0){
                throw new IllegalArgumentException();
            }
            this.mark = mark;
            return this;
        }

        public Builder withStudents(Set<Student> students) {
            this.students = students;
            return this;
        }

        public Grade build() {
            if(subject == null){
                throw new IllegalArgumentException();
            }

            return new Grade(subject, mark, students);
        }
    }
}
