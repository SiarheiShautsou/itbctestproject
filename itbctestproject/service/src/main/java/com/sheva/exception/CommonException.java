package com.sheva.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommonException extends RuntimeException{

    private String exceptionMessage;
    private Integer errorCode;
    private String exceptionId;

    public CommonException(String exceptionMessage, Integer errorCode, String exceptionId) {
        this.exceptionMessage = exceptionMessage;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    public CommonException(String message, String exceptionMessage, Integer errorCode, String exceptionId) {
        super(message);
        this.exceptionMessage = exceptionMessage;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    public CommonException(String message, Throwable cause, String exceptionMessage, Integer errorCode, String exceptionId) {
        super(message, cause);
        this.exceptionMessage = exceptionMessage;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    public CommonException(Throwable cause, String exceptionMessage, Integer errorCode, String exceptionId) {
        super(cause);
        this.exceptionMessage = exceptionMessage;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionMessage, Integer errorCode, String exceptionId) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionMessage = exceptionMessage;
        this.errorCode = errorCode;
        this.exceptionId = exceptionId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
