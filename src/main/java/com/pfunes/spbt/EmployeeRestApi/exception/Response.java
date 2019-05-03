package com.pfunes.spbt.EmployeeRestApi.exception;

public class Response {

    private int id;

    private String message;

    private long timeStamp;

    public Response(){}

    public Response(int id, String message, long timeStamp) {
        this.id = id;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
