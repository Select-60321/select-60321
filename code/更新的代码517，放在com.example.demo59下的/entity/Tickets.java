package com.example.demo59.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * tickets
 *
 * @author lori
 */
@Data
public class Tickets implements Serializable {
    private Integer ticketId;

    private Integer orderId;

    private Integer carriageId;

    private Integer departJourney;

    private Integer arriveJourney;

    private Date departDate;

    private Double ticketPrice;
    private Integer seatTypeId;

    private Integer ticketActive;

    public Integer getTicketActive() {
        return ticketActive;
    }

    public void setTicketActive(Integer ticketActive) {
        this.ticketActive = ticketActive;
    }

    private static final long serialVersionUID = 1L;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCarriageId() {
        return carriageId;
    }

    public void setCarriageId(Integer carriageId) {
        this.carriageId = carriageId;
    }

    public Integer getDepartJourney() {
        return departJourney;
    }

    public void setDepartJourney(Integer departJourney) {
        this.departJourney = departJourney;
    }

    public Integer getArriveJourney() {
        return arriveJourney;
    }

    public void setArriveJourney(Integer arriveJourney) {
        this.arriveJourney = arriveJourney;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }
}