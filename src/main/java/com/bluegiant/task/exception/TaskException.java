package com.bluegiant.task.exception;

public class TaskException extends RuntimeException {

    private final String exceptionMessage;
    private final Throwable ex;

    public TaskException(String exceptionMessage) {
        super(exceptionMessage);
        ex = null;
        this.exceptionMessage = exceptionMessage;
    }

    public TaskException(Throwable ex) {
        super(ex);
        this.ex = ex;
        exceptionMessage = ex.getMessage();
    }

    public TaskException(String exceptionMessage, Throwable ex) {
        super(ex);
        this.ex = ex;
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public Throwable getException() {
        return ex;
    }
}
