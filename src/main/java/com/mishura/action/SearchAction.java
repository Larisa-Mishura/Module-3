package com.mishura.action;

import com.mishura.model.Person;
import com.mishura.service.*;
import com.mishura.util.UserInput;

public class SearchAction implements Action{

    private static SearchService service;

    @Override
    public void execute() {

        String field;
        final String[] menuForTable = {"Teacher", "Student", "Group"};
        final int userChoiceTable = UserInput.menu(menuForTable, "Write what you want to search");

        if(userChoiceTable == 2){
            service = GroupService.getInstance();
            field = "name";
        } else {
            if (userChoiceTable == 0) {
                service = TeacherService.getInstance();
            }
            if (userChoiceTable == 1) {
                service = StudentService.getInstance();
            }
            final String[] menuForField = {"first_name", "last_name"};
            final int userChoiceField = UserInput.menu(menuForField, "Write what you want to search");
            field = menuForField[userChoiceField];
        }

        String fieldName = UserInput.getString("Enter name for search");

        service.getByFieldName(field, fieldName);
    }
}