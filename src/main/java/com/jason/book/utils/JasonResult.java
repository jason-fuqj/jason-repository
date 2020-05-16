package com.jason.book.utils;

import com.jason.book.constants.Constants;
import com.jason.book.constants.ErrorCodeEnum;

/**
 * TODO: 返回结果工具类
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
public class JasonResult<T> {

    // 结果数据
    private T data;
    // 状态码
    private String code;
    // 返回信息
    private String msg;

    public JasonResult(T data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public JasonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JasonResult(String code) {
        this.code = code;
    }

    public JasonResult(T data, String code) {
        this.data = data;
        this.code = code;
    }

    /**
     * 返回一个状态码为200的json
     * @param data
     * @return
     */
    public static JasonResult success(Object data) {
        return new JasonResult(data,Constants.SUCCESS_CODE,Constants.SUCCESS_MSG);
    }

    /**
     *
     * @return
     */
    public static JasonResult success() {
        return new JasonResult(Constants.SUCCESS_CODE,Constants.SUCCESS_MSG);
    }

    /**
     * 返回默认错误信息JSON
     * @return
     */
    public static JasonResult fail(){
        return new JasonResult(Constants.FAIL_CODE,Constants.FAIL_MSG);
    }

    /**
     * 返回自定义错误信息JSON
     * @param errorEnum
     * @return
     */
    public static JasonResult fail(ErrorCodeEnum errorEnum){
        return new JasonResult(errorEnum.getErrorCode(),errorEnum.getErrorMsg());
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
