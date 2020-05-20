package com.example.demo59.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * carriages primary key
 * @author lori
 */
@Data
public class CarriagesKey implements Serializable {
    private String trainNumber;

    private Integer carriageIndex;

    private static final long serialVersionUID = 1L;

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Integer getCarriageIndex() {
        return carriageIndex;
    }

    public void setCarriageIndex(Integer carriageIndex) {
        this.carriageIndex = carriageIndex;
    }

}