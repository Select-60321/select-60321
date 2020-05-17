package com.example.demo59.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * carriages
 * @author lori
 */
@Data
public class Carriages extends CarriagesKey implements Serializable {
    private Integer seatTypeId;

    private Integer seatNum;

    private static final long serialVersionUID = 1L;

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }


}