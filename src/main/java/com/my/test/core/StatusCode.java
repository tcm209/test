package com.my.test.core;


public enum StatusCode implements  IErrorCode {

    // 成功状态码 1 开头
    SUCCESS("00000","成功"),

    // 异常状态码 2 开头
    NO_LOGIN("A0001","没有登录"),
    USER_NOT_EXIST("A00011","用户不存在"),
    TOKEN_EXPIRE("A0002","token过期"),
    NOT_AUTHORITY("A0003","没有权限"),
    BIZ_EXCEPTION("A0004","业务异常"),
    SYSTEM_ERROR("A0005","系统后台异常"),
    TOKEN_ERROR("A0007","非法的token"),
    BAD_REQUEST("A0008","请求参数校验失败"),
    NEED_CONFIRM("A0009","需要前端确认操作"),

    WX_NOT_SUB_MCH("B0001", "租户没有绑定子商户");



    private final String  code;
    private final String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    StatusCode(String code , String defaultMsg){
        this.code = code;
        this.msg = defaultMsg;
    }

}
