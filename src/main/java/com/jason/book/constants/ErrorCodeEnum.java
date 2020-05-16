package com.jason.book.constants;

/**
 * @author: hxy
 * @date: 2017/10/24 10:16
 */
public enum ErrorCodeEnum {
	/*
	 * 错误信息
	 * */
	E_400("400", "请求处理异常，请稍后再试"),
	E_500("500", "请求方式有误,请检查 GET/POST"),
	E_501("501", "请求路径不存在"),
	E_502("502", "权限不足"),

	E_10001("10001", "角色删除失败,尚有用户属于此角色"),
	E_10002("10002", "账户不存在"),
	E_10003("10003","账号或密码错误"),

	E_20001("20001", "登陆已过期,请重新登陆"),

	E_20002("20002", "缺少必填参数");

	private String errorCode;

	private String errorMsg;

	ErrorCodeEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}