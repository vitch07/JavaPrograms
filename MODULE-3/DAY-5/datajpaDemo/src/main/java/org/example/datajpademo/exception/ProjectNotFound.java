package org.example.datajpademo.exception;

public class ProjectNotFound extends RuntimeException{

    public ProjectNotFound(String message) {
        super(message);
    }
}
