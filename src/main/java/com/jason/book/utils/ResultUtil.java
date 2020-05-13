package com.jason.book.utils;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.constants.Constants;
import com.jason.book.constants.ErrorCodeEnum;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

import java.util.List;

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
        resultJson.put("data", "[]");
        return resultJson;
    }

    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    /**
     * 查询分页结果后的封装工具方法
     *
     * @param requestJson 请求参数json,此json在之前调用fillPageParam 方法时,已经将pageRow放入
     * @param list        查询分页对象list
     * @param totalCount  查询出记录的总条数
     */
    public static JSONObject successPage(final JSONObject requestJson, List<JSONObject> list, int totalCount) {
        int pageRow = requestJson.getIntValue("pageSize");
        int totalPage = getPageCounts(pageRow, totalCount);
        JSONObject result = successJson();
        JSONObject info = new JSONObject();
        info.put("list", list);
        info.put("totalCount", totalCount);
        info.put("totalPage", totalPage);
        result.put("data", info);
        return result;
    }

    /**
     * 查询分页结果后的封装工具方法
     *
     * @param list 查询分页对象list
     */
    public static JSONObject successPage(List<JSONObject> list) {
        JSONObject result = successJson();
        JSONObject info = new JSONObject();
        info.put("list", list);
        result.put("data", info);
        return result;
    }

    /**
     * 获取总页数
     *
     * @param pageRow   每页行数
     * @param itemCount 结果的总条数
     */
    private static int getPageCounts(int pageRow, int itemCount) {
        if (itemCount == 0) {
            return 1;
        }
        return itemCount % pageRow > 0 ?
                itemCount / pageRow + 1 :
                itemCount / pageRow;
    }

    /**
     * 在分页查询之前,为查询条件里加上分页参数
     *
     * @param paramObject    查询条件json
     * @param defaultPageRow 默认的每页条数,即前端不传pageRow参数时的每页条数
     */
    private static void fillPageParam(final JSONObject paramObject, int defaultPageRow) {
        int pageNum = paramObject.getIntValue("pageNumber");
        pageNum = pageNum == 0 ? 1 : pageNum;
        int pageRow = paramObject.getIntValue("pageSize");
        pageRow = pageRow == 0 ? defaultPageRow : pageRow;
        paramObject.put("pageNumber", (pageNum - 1) * pageRow);
        paramObject.put("pageSize", pageRow);
        //删除此参数,防止前端传了这个参数,pageHelper分页插件检测到之后,拦截导致SQL错误
//        paramObject.remove("pageSize");
    }

    /**
     * 分页查询之前的处理参数
     * 没有传pageRow参数时,默认每页10条.
     */
    public static void fillPageParam(final JSONObject paramObject) {
        fillPageParam(paramObject, 10);
    }

    public static void main(String[] args) {
        //生成盐（需要存入数据库中）
        ByteSource salt = ByteSource.Util.bytes("jason");
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String encryptedPwd = new Md5Hash("123456",salt,3).toString();

        System.out.println("salt:" + salt + "，encryptedPwd:" + encryptedPwd);
    }
}
