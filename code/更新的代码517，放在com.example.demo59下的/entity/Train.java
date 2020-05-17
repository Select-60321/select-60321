package com.example.demo59.entity;

import java.sql.Time;

/**
 * 临时类，用来存储一趟列车的信息
 *
 * @author Lori
 */

public class Train {
    private String trainId;
    private Integer stationIndex;
    private String stationName;
    private String cityName;
    private String province;
    private Time arriveTime;
    private Integer arriveDay;
    private Time departTime;
    private Integer departDay;
    private Integer accumulatedDistance;
    private String stationStatus;

    @Override
    public String toString() {
        return "Train{" +
                "trainId='" + trainId + '\'' +
                ", stationIndex=" + stationIndex +
                ", stationName='" + stationName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", province='" + province + '\'' +
                ", arriveTime=" + arriveTime +
                ", arriveDay=" + arriveDay +
                ", departTime=" + departTime +
                ", departDay=" + departDay +
                ", accumulatedDistance=" + accumulatedDistance +
                ", stationStatus='" + stationStatus + '\'' +
                '}';
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public Integer getStationIndex() {
        return stationIndex;
    }

    public void setStationIndex(Integer stationIndex) {
        this.stationIndex = stationIndex;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Time getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    public Integer getArriveDay() {
        return arriveDay;
    }

    public void setArriveDay(Integer arriveDay) {
        this.arriveDay = arriveDay;
    }

    public Integer getDepartDay() {
        return departDay;
    }

    public void setDepartDay(Integer departDay) {
        this.departDay = departDay;
    }

    public Integer getAccumulatedDistance() {
        return accumulatedDistance;
    }

    public void setAccumulatedDistance(Integer accumulatedDistance) {
        this.accumulatedDistance = accumulatedDistance;
    }

    public String getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(String stationStatus) {
        this.stationStatus = stationStatus;
    }

}