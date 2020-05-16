package com.jason.book.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.constants.ErrorCodeEnum;
import com.jason.book.utils.JasonResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO: 统一异常拦截
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@ExceptionHandler(value = Exception.class)
	public JasonResult defaultErrorHandler(HttpServletRequest req, Exception exception) {
		if (exception != null) {
			if (UnknownAccountException.class.isInstance(exception)) {
				// 账户不存在
				return JasonResult.fail(ErrorCodeEnum.E_10002);
			}else if (IncorrectCredentialsException.class.isInstance(exception)) {
				// 账号或密码错误
				return JasonResult.fail(ErrorCodeEnum.E_10003);
			}else if(UnauthenticatedException.class.isInstance(exception)){
				// 登录已过期
				return JasonResult.fail(ErrorCodeEnum.E_20001);
			}
		}
		return JasonResult.fail(ErrorCodeEnum.E_20001);
	}

	/**
	 * GET/POST请求方法错误的拦截器
	 * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
	 * 所以定义了这个拦截器
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public JasonResult httpRequestMethodHandler() {
		return JasonResult.fail(ErrorCodeEnum.E_500);
	}

	/**
	 * 本系统自定义错误的拦截器
	 * 拦截到此错误之后,就返回这个类里面的json给前端
	 * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
	 */
	@ExceptionHandler(CommonJsonException.class)
	public JasonResult commonJsonExceptionHandler(CommonJsonException commonJsonException) {
		return commonJsonException.getResultJson();
	}

	/**
	 * 权限不足报错拦截
	 */
	@ExceptionHandler(UnauthorizedException.class)
	public JasonResult unauthorizedExceptionHandler() {
		return JasonResult.fail(ErrorCodeEnum.E_502);
	}

	@ExceptionHandler(AuthenticationException.class)
	public JasonResult authenticationException(){
		return JasonResult.fail(ErrorCodeEnum.E_10003);
	}
	/**
	 * 未登录报错拦截
	 * 在请求需要权限的接口,而连登录都还没登录的时候,会报此错
	 */
	@ExceptionHandler(UnauthenticatedException.class)
	public JasonResult unauthenticatedException() {
		return JasonResult.fail(ErrorCodeEnum.E_20001);
	}
}
