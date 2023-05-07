package com.example.task.Model;

public class Response {
    private long responseValue;

    public Response(int responseValue) {
        this.responseValue = responseValue;
    }

    public Response(){}

    public long getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(long responseValue) {
        this.responseValue = responseValue;
    }
}
