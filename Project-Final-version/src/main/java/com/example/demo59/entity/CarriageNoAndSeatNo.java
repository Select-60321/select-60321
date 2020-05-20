package com.example.demo59.entity;

/**
 * 这个 class 是用来存储某趟列车的车厢号和对应的座位数信息的
 * @author Lori
 */
public class CarriageNoAndSeatNo {
    private Integer carriageIndex;
    private Integer seatNum;

    public Integer getCarriageIndex() {
        return carriageIndex;
    }

    public void setCarriageIndex(Integer carriageIndex) {
        this.carriageIndex = carriageIndex;
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    @Override
    public String toString() {
        return "CarriageNoAndSeatNo{" +
                "carriageIndex=" + carriageIndex +
                ", seat_num=" + seatNum +
                '}';
    }
}
