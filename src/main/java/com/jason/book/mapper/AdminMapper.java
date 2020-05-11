package com.jason.book.mapper;

import com.jason.book.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Component
@Mapper
public interface AdminMapper {

    /**
     * 添加管理员
     * @param record
     * @return
     */
    int addAdmin(Admin record);

    /**
     * 更新管理员信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Admin record);

    /**
     * 根据id查询
     * @param adminId
     * @return
     */
    Admin selectByPrimaryKey(Long adminId);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    Admin selectByNameAndPwd(String username,String password);
}
