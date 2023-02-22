package com.mishura.action;

import com.mishura.service.StudentService;
import com.mishura.util.UserInput;

public class StudentsWithAverageGrade implements Action{
    StudentService studentService = StudentService.getInstance();

    @Override
    public void execute() {

        double grade = UserInput.getDouble("Enter grade for searching for students with average grade above");

        System.out.println("Students with average grade above " + grade);

        studentService.getStudentsByGrade(grade);
    }
}
