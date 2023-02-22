package com.mishura.action;

import com.mishura.model.Person;
import com.mishura.repository.GroupRepository;
import com.mishura.repository.SearchableRepository;
import com.mishura.repository.StudentRepository;
import com.mishura.repository.TeacherRepository;
import com.mishura.service.*;
import com.mishura.util.UserInput;

public class SearchAction implements Action{

    @Override
    public void execute() {

        String field;
        SearchableRepository searchableRepository = null;
        final String[] menuForTable = {"Teacher", "Student", "Group"};
        final int userChoiceTable = UserInput.menu(menuForTable, "Write what you want to search");

        if(userChoiceTable == 2){
            searchableRepository = GroupRepository.getInstance();
            field = "name";
        } else {
            if (userChoiceTable == 0) {
                searchableRepository = TeacherRepository.getInstance();
            }
            if (userChoiceTable == 1) {
                searchableRepository = StudentRepository.getInstance();
            }
            final String[] menuForField = {"first_name", "last_name"};
            final int userChoiceField = UserInput.menu(menuForField, "Write what you want to search");
            field = menuForField[userChoiceField];
        }

        String fieldName = UserInput.getString("Enter name for search");

        service.getByFieldName(field, fieldName, searchableRepository);
    }
}