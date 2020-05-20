package com.example.demo59.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * temporary class about the order details
 *
 * @author Lori
 */
public class OrdersDetails {
    private Integer orderId;
    private Timestamp createDate;
    private String orderStatus;
    private String userName;
    private Integer ticketId;
    private String ticketStatus;
    private Date departDate;
    private String trainId;
    private String fromStation;
    private String fromStationStatus;
    private String toStation;
    private String toStationStatus;
    private Time departureTime;
    private Integer departureDay;
    private Time arrivalTime;
    private Integer arrivalDay;
    private Integer carriageNo;
    private String seatNum;
    private Double ticketPrice;
    private String seatType;
    private Integer totalDistance;

    @Override
    public String toString() {
        return "OrdersDetails{" +
                "orderId=" + orderId +
                ", createDate=" + createDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", userName='" + userName + '\'' +
                ", ticketId=" + ticketId +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", departDate=" + departDate +
                ", trainId='" + trainId + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", fromStationStatus='" + fromStationStatus + '\'' +
                ", toStation='" + toStation + '\'' +
                ", toStationStatus='" + toStationStatus + '\'' +
                ", departureTime=" + departureTime +
                ", departureDay=" + departureDay +
                ", arrivalTime=" + arrivalTime +
                ", arrivalDay=" + arrivalDay +
                ", carriageNo=" + carriageNo +
                ", seatNum='" + seatNum + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", seatType='" + seatType + '\'' +
                ", totalDistance=" + totalDistance +
                '}';
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getFromStationStatus() {
        return fromStationStatus;
    }

    public void setFromStationStatus(String fromStationStatus) {
        this.fromStationStatus = fromStationStatus;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getToStationStatus() {
        return toStationStatus;
    }

    public void setToStationStatus(String toStationStatus) {
        this.toStationStatus = toStationStatus;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Integer departureDay) {
        this.departureDay = departureDay;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(Integer arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    public Integer getCarriageNo() {
        return carriageNo;
    }

    public void setCarriageNo(Integer carriageNo) {
        this.carriageNo = carriageNo;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

}
    /**
     * //TODO: sql语句
     * select x.order_id,
     *        u.user_name,
     *        ticket_id,
     *        depart_date,
     *        train_id,
     *        s1.station_name                from_station,
     *        case from_status
     *            when 0 then 'Normal'
     *            when 1 then 'No passing by station!'
     *            else 'Train cancelled' end from_station_status,
     *        s2.station_name                to_station,
     *        case to_status
     *            when 0 then 'Normal'
     *            when 1 then 'No passing by station!'
     *            else 'Train cancelled' end to_station_status,
     *        departure_time,
     *        departure_day,
     *        arrival_time,
     *        arrival_day,
     *        carriage_no,
     *        seat_no,
     *        ticket_price,
     *        seat_type,
     *        total_distance
     * from (select t.ticket_id,
     *              t.order_id,
     *              t.depart_date,
     *              j.train_id,
     *              j2.station_id            from_station_id,
     *              j2.status                from_status,
     *              j.station_id             to_station_id,
     *              j.status                 to_status,
     *              j2.depart_time           departure_time,
     *              j2.depart_day            departure_day,
     *              j.arrive_time            arrival_time,
     *              j.arrive_day             arrival_day,
     *              t.carriage_id            carriage_no,
     *              t.seat_num               seat_no,
     *              t.ticket_price           ticket_price,
     *              st.seat_name             seat_type,
     *              j.distance - j2.distance total_distance
     *       from tickets t
     *                join journeys j on t.arrive_journey = j.journey_id
     *                join journeys j2 on j2.journey_id = t.depart_journey
     *                join seat_type st on t.seat_type_id = st.seat_type_id
     *                join stations s on j.station_id = s.station_id) x
     *          join stations s1 on from_station_id = s1.station_id
     *          join stations s2 on to_station_id = s2.station_id
     *          join orders o on o.order_id = x.order_id
     *          join users u on o.person = u.user_id
     * where u.user_name = 'lsl' and o.order_id = 1;
     */

