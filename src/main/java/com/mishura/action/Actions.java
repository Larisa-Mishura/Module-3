package com.mishura.action;

import lombok.Getter;

@Getter
public enum Actions {

    CREATE ("Create", new CreateStudentAction()),
    SEARCH ("Search", new SearchAction()),
    EXIT("Finish program", new ExitAction());

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