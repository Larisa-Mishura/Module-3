package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "student_group")
public class Group {
    @Id
    private String name;

    @OneToMany(mappedBy = "group",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Set<Student> students;

    public Group(){

    }

    public Group(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }
}
