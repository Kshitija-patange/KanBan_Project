package com.cg.fsd4.kanban_board.exception;

public class TaskNotFoundException extends Exception{
    private final String message;

    public TaskNotFoundException() {
        this.message="";
    }

    public TaskNotFoundException(String message) {
        this.message=message;

    }

    @Override
    public String toString() {
        return "Task Was Not Found "+this.message;
    }
}
