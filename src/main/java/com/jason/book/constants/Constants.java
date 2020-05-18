package com.jason.book.constants;

/**
 * 通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 */
public class Constants {

	public static final String SUCCESS_CODE = "200";
	public static final String SUCCESS_MSG = "请求成功";

	public static final String FAIL_CODE = "400";
	public static final String FAIL_MSG = "请求失败";

	public static String SALT_STR = "salt";
	public static String PASSWORD_STR = "password";
	public static String LOGIN_NAME_STR = "userName";
	//加密方式
	public static String ALGORITHM_NAME_MD5 = "md5";
	//加密次数
	public static int HASH_ITERATIONS = 3;
	//session过期时间 ms
	public static int SESSION_TIME_OUT = 5 * 60 * 1000;

	/**
	 * session中存放用户信息的key值
	 */
	public static final String SESSION_USER_INFO = "userInfo";
	public static final String SESSION_USER_PERMISSION = "userPermission";

	public static final String CACHE_KEY = "shiro:cache:";
	public static final String SESSION_KEY = "shiro:session:";
	public static final String ID_KEY = "userName";
}
