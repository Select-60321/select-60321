package com.example.demo59.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * admins 表
 * @author lori
 */
@Data
public class Admin implements Serializable {
    private Integer adminId;

    private String adminName;

    private String password;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + adminId +
                ", admin_name='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}