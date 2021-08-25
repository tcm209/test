package com.my.test.core;

/**
 * @author wangjinqiang
 * @date 2020-11-12
 */
public interface IErrorCode {
    /**
     * 获取错误码
     * @return 错误码
     */
    String getCode();

    /**
     * 获取消息
     * @return 消息
     */
    String getMsg();
}
