package com.mishura.action;

import com.mishura.model.Group;
import com.mishura.model.Student;
import com.mishura.service.StudentService;
import com.mishura.util.UserInput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CreateStudentAction implements Action{

    StudentService studentService = StudentService.getInstance();

    @Override
    public void execute() {

        LocalDateTime dateOfEntrance = null;

        final String[] menuForDateAndTime = {"Current date and time", "Enter date and time"};
        final int userChoice = UserInput.menu(menuForDateAndTime, "Make your choice");

        if(userChoice == 0){
            dateOfEntrance = LocalTime.now().atDate(LocalDate.now());
        }
        if(userChoice == 1) {
            dateOfEntrance = UserInput.getDateAngTime();
        }

        final Student.Builder builder = new Student.Builder();
        Student student = (Student) builder
                .withFirstName(UserInput.getString("Enter first name"))
                .withLastName(UserInput.getString("Enter last name"))
                .withAge(UserInput.getInt("Enter age"))
                .withDateOfEntrance(dateOfEntrance)
                .withGroup(new Group(UserInput.getString("Enter group")))
                .build();

        System.out.println(student.toString());

        final String[] menuForSaving = {"Yes", "No"};
        final int userChoiceForSaving = UserInput.menu(menuForSaving, "Do you want to save information to the database?");

        if(userChoiceForSaving == 0){
            studentService.save(student);
        }
    }
}
