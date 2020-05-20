package com.example.demo59.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * stations
 *
 * @author lori
 */
@Data
public class Stations implements Serializable {
    private Integer stationId;

    private String stationName;

    private Integer cityId;

    private Integer stationActive;

    private static final long serialVersionUID = 1L;

    public Integer getStationActive() {
        return stationActive;
    }

    public void setStationActive(Integer stationActive) {
        this.stationActive = stationActive;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

}