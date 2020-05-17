package com.example.demo59.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * cities
 * @author lori
 */
@Data
public class Cities implements Serializable {
    private Integer cityId;

    private String cityName;

    private String province;

    private static final long serialVersionUID = 1L;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}