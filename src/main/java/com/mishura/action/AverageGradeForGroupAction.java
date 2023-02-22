package com.mishura.action;

import com.mishura.service.GradeService;

public class AverageGradeForGroupAction implements Action{

    GradeService gradeService = GradeService.getInstance();

    @Override
    public void execute() {
        gradeService.getAverageGradeInGroup();
    }
}
