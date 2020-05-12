package com.jason.book.utils;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.constants.Constants;
import com.jason.book.constants.ErrorCodeEnum;

/**
 * TODO: 返回结果转换
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
public class ResultUtil {

    /**
     * 返回一个返回码为200的json
     */
    public static JSONObject successJson(Object info) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", Constants.SUCCESS_CODE);
        resultJson.put("msg", Constants.SUCCESS_MSG);
        resultJson.put("data", info);
        return resultJson;
    }

    /**
     * 返回错误信息JSON
     */
    public static JSONObject errorJson(ErrorCodeEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", errorEnum.getErrorCode());
        resultJson.put("msg", errorEnum.getErrorMsg());
        resultJson.put("data", new JSONObject());
        return resultJson;
    }
}
