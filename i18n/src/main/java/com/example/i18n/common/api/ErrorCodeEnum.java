package com.example.i18n.common.api;

public enum ErrorCodeEnum {
    SUCCESS(0, "success"),
    FAILURE(1, "failure");

    private int errorCode;
    private String errorMsg;

    ErrorCodeEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
