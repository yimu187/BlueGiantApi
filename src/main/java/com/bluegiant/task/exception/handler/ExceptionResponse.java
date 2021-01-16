package com.bluegiant.task.exception.handler;

import java.util.Date;

public class ExceptionResponse {

    private boolean success = false;
    private Date timeStamp;
    private String message;
    private String description;

    public ExceptionResponse(Date timeStamp, String message, String description) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccess() {
        return success;
    }
}
