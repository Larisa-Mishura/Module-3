package com.mishura.action;

public class ExitAction implements Action{
    @Override
    public void execute() {

        System.out.println("Good bye!");
        System.exit(0);
    }
}