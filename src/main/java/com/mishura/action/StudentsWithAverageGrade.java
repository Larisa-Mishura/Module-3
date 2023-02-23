package com.mishura.action;

import com.mishura.util.UserInput;

public class StudentsWithAverageGrade implements Action{

    @Override
    public void execute() {

        double grade = UserInput.getDouble("Enter the grade");

        System.out.println("Students with average grade above " + grade);

        service.getStudentsByGrade(grade);
    }
}
