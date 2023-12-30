package com.leadsassignment.response;

public class SuccessResponse {

    private String status = "success";
    private String data;


    public SuccessResponse(String status, String data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}