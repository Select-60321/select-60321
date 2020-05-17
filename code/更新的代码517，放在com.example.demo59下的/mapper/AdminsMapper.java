package com.example.demo59.mapper;

import com.example.demo59.entity.*;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 不允许更改密码
 */
public interface AdminsMapper {
    /**
     * 找admin是否存在
     * @param admin 管理员用户名+密码
     * @return null为不存在
     */
    Admin findExistAdmin(Admin admin);
}