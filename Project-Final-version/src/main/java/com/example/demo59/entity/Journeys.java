package com.example.demo59.entity;

import java.io.Serializable;
import java.sql.Time;

import lombok.Data;

/**
 * journeys
 * @author lori
 */
@Data
public class Journeys implements Serializable {
    private Integer journeyId;

    private String trainId;

    private Integer stationIndex;

    private Integer stationId;

    private Time arriveTime;

    private Time departTime;

    private Integer arriveDay;

    private Integer departDay;

    private Integer distance;

    private static final long serialVersionUID = 1L;

    public Integer getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Integer journeyId) {
        this.journeyId = journeyId;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}