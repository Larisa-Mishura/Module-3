package com.mishura.action;

import com.mishura.model.Group;
import com.mishura.model.Student;
import com.mishura.service.StudentService;
import com.mishura.util.UserInput;
import lombok.NonNull;

import java.time.LocalDateTime;

public class CreateStudentAction implements Action{

    StudentService studentService = StudentService.getInstance();

    @Override
    public void execute() {
        final Student student = studentService.create();
        System.out.println(student.toString());

        final String[] menuForTable = {"Yes", "No"};
        final int userChoice = UserInput.menu(menuForTable, "Do you want to save information to the database?");

        if(userChoice == 0){
            studentService.save(student);
        }

    }
}
