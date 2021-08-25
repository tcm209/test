package com.my.test.core;

public class BizException extends RuntimeException {
    private String code;

    public BizException(String msg) {
        super(msg);
    }

    public BizException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }

    public String getCode() {
        return code;
    }

    public BizException setCode(String code) {
        this.code = code;
        return this;
    }
}
