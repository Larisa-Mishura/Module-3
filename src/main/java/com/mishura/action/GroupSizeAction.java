package com.mishura.action;

import com.mishura.service.StudentService;

public class GroupSizeAction implements Action{

    StudentService studentService = StudentService.getInstance();

    @Override
    public void execute() {
        System.out.println("The total amount of students in every group:");
        studentService.getGroupSizes();
    }
}
