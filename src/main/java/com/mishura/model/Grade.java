package com.mishura.model;

public class Grade {

    private Subject subject;
    private int mark;

    public Grade() {
    }

    public Grade(Subject subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }
}
