package com.mishura.action;

import com.mishura.util.UserInput;

public class SubjectStatistics implements Action{

    @Override
    public void execute() {
        final String[] menuForTable = {"Subject with best grades", "Subject with worst grades"};
        final int userChoice = UserInput.menu(menuForTable, "Write what you want");

        if(userChoice == 0){
            service.getBestGradesSubject();
        }
        if(userChoice == 1) {
            service.getWorstGradesSubject();
        }
    }
}
