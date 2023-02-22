package com.mishura.action;

import com.mishura.service.SubjectService;
import com.mishura.util.UserInput;

public class SubjectStatistics implements Action{

    private static final SubjectService subjectService = SubjectService.getInstance();

    @Override
    public void execute() {
        final String[] menuForTable = {"Subject with best grades", "Subject with worst grades"};
        final int userChoice = UserInput.menu(menuForTable, "Write what you want");

        if(userChoice == 0){
            subjectService.getBestGradesSubject();
        }
        if(userChoice == 1) {
            subjectService.getWorstGradesSubject();
        }
    }
}
