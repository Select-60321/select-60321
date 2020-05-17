package com.example.demo59.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * seat_type
 * @author Lori
 */
@Data
public class SeatType implements Serializable {
    private Integer seatTypeId;

    private String seatName;

    private Double seatBasicPrice;

    private static final long serialVersionUID = 1L;

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Double getSeatBasicPrice() {
        return seatBasicPrice;
    }

    public void setSeatBasicPrice(Double seatBasicPrice) {
        this.seatBasicPrice = seatBasicPrice;
    }
}