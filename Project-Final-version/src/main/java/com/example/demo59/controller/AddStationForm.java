package com.example.demo59.controller;

import java.sql.Time;

public class AddStationForm {
    private String trainNumber;
    private Integer stationId;
    private Time arriveTime;
    private Time updateDepartTime;
    private Integer arriveDay;
    private Integer updateDepartDay;
    private Integer distance;

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Time getUpdateDepartTime() {
        return updateDepartTime;
    }

    public void setUpdateDepartTime(Time updateDepartTime) {
        this.updateDepartTime = updateDepartTime;
    }

    public Integer getArriveDay() {
        return arriveDay;
    }

    public void setArriveDay(Integer arriveDay) {
        this.arriveDay = arriveDay;
    }

    public Integer getUpdateDepartDay() {
        return updateDepartDay;
    }

    public void setUpdateDepartDay(Integer updateDepartDay) {
        this.updateDepartDay = updateDepartDay;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
