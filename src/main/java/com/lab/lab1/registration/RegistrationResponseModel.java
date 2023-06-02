package com.lab.lab1.registration;

public class RegistrationResponseModel {
    String message;
    Boolean isSuccess;
    int status;
    Object data;

    public RegistrationResponseModel(String message, Boolean isSuccess, int status, Object data) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
