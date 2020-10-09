package com.doka.games.utils;

public class ResponseModel {
    private String message;
    private int status;
    private Object object;

    public String getMessage() {
        return message;
    }

    public ResponseModel setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResponseModel setStatus(int status) {
        this.status = status;
        return this;
    }
    public Object getObject() {
        return object;
    }

    public ResponseModel setObject(Object object) {
        this.object = object;
        return this;
    }
}
