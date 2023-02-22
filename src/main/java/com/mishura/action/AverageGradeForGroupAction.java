package com.mishura.action;

public class AverageGradeForGroupAction implements Action{

    @Override
    public void execute() {

        System.out.println("Average grade for group:");

        service.getAverageGradeInGroup();
    }
}
