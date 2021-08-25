package com.my.test.core;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author wangjinqiang
 * @date 2020-11-12
 */
@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

    private static final long serialVersionUID = -5325112889282352262L;
    @ApiModelProperty(required = true, notes = "结果码", example = "00000")
    private String code;
    @ApiModelProperty(required = true, notes = "返回数据")
    private T data;
    @ApiModelProperty(required = true, notes = "返回信息说明", example = "成功")
    private String msg;

    @ApiModelProperty(required = true, notes = "服务器时间戳")
    private long timestamp = System.currentTimeMillis();

    /**
     * 是否成功，状态码为 00000
     * @return 是否成功
     */
    public boolean isSuccess(){
        return StatusCode.SUCCESS.getCode().equals(code);
    }

    public R() {
    }

    public R(IErrorCode errorCode) {
            errorCode = Optional.ofNullable(errorCode).orElse(StatusCode.SYSTEM_ERROR);
        code = errorCode.getCode();
        msg = errorCode.getMsg();
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, StatusCode.SUCCESS);
    }

    public static <T> R<T> ok() {
        return ok(null);
    }
    public static <T> R<T> restResult(T data, IErrorCode errorCode) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> R<T> restResult(T data, String code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


    public static <T> R<T> failed(String msg) {
        return restResult(null, StatusCode.BIZ_EXCEPTION.getCode(), msg);
    }

    public static <T> R<T> failed(IErrorCode errorCode) {
        return restResult(null, errorCode);
    }
}
