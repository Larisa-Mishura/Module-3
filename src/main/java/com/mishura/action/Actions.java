package com.mishura.action;

import lombok.Getter;

@Getter
public enum Actions {

    SEARCH ("Search", new SearchAction()),
    AMOUNT_STUDENTS_IN_GROUP ("The total amount of students in every group", new GroupSizeAction()),
    AVERAGE_GRADE_FOR_GROUP ("Show average grade for groups", new AverageGradeForGroupAction()),
    SUBJECT_STATISTICS ("Show subject with best / worst grades",  new SubjectStatistics()),
    STUDENTS_WITH_AVERAGE_GRADE ("Show students with average grad", new StudentsWithAverageGrade()),
    CREATE ("Create", new CreateStudentAction()),
    EXIT ("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action){
        this.name = name;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }

    public static String[] mapActionsToNames(final Actions[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }
}