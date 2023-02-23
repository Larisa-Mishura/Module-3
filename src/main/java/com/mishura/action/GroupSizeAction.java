package com.mishura.action;

public class GroupSizeAction implements Action{

    @Override
    public void execute() {

        System.out.println("The total amount of students in every group:");

        service.getGroupSizes();
    }
}
