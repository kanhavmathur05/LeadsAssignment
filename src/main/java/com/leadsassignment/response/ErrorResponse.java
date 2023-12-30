package com.leadsassignment.response;

public class ErrorResponse {

    private String status = "error";
    private ErrorResponseDetails errorResponse;

    public ErrorResponse(String status, ErrorResponseDetails errorResponse) {
        this.status = status;
        this.errorResponse = errorResponse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorResponseDetails getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponseDetails errorResponse) {
        this.errorResponse = errorResponse;
    }
}
