package com.example.demo59.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

/**
 * temporary class for searching the tickets information between the stations
 *
 * @author lori
 */
@RestController
public class BetweenStationsInfo {
    private String trainId;
    private Integer journeyIdFrom;
    private String fromStation;
    private Integer stationIdxFrom;
    private Integer journeyIdTo;
    private String toStation;
    private Integer stationIdxTo;
    private Time fromDepartTime;
    private Integer fromDepartDay;
    private Time toArrTime;
    private Integer toArriveDay;
    private Integer totalDistance;
    private Integer seatTypeId;
    private String seatName;
    private Integer ticketPrice;
    private String trainStatus;
    private Integer restTickets;

    @Override
    public String toString() {
        return "BetweenStationsInfo{" +
                "trainId='" + trainId + '\'' +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", fromDepartTime=" + fromDepartTime +
                ", fromDepartDay=" + fromDepartDay +
                ", toArrTime=" + toArrTime +
                ", toArriveDay=" + toArriveDay +
                ", totalDistance=" + totalDistance +
                ", seatName='" + seatName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", trainStatus='" + trainStatus + '\'' +
                ", restTickets=" + restTickets +
                '}';
    }

    public Integer getRestTickets() {
        return restTickets;
    }

    public void setRestTickets(Integer restTickets) {
        this.restTickets = restTickets;
    }

    public Integer getStationIdxFrom() {
        return stationIdxFrom;
    }

    public void setStationIdxFrom(Integer stationIdxFrom) {
        this.stationIdxFrom = stationIdxFrom;
    }

    public Integer getStationIdxTo() {
        return stationIdxTo;
    }

    public void setStationIdxTo(Integer stationIdxTo) {
        this.stationIdxTo = stationIdxTo;
    }

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Time getFromDepartTime() {
        return fromDepartTime;
    }

    public void setFromDepartTime(Time fromDepartTime) {
        this.fromDepartTime = fromDepartTime;
    }

    public Integer getFromDepartDay() {
        return fromDepartDay;
    }

    public void setFromDepartDay(Integer fromDepartDay) {
        this.fromDepartDay = fromDepartDay;
    }

    public Time getToArrTime() {
        return toArrTime;
    }

    public void setToArrTime(Time toArrTime) {
        this.toArrTime = toArrTime;
    }

    public Integer getToArriveDay() {
        return toArriveDay;
    }

    public void setToArriveDay(Integer toArriveDay) {
        this.toArriveDay = toArriveDay;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public Integer getJourneyIdFrom() {
        return journeyIdFrom;
    }

    public void setJourneyIdFrom(Integer journeyIdFrom) {
        this.journeyIdFrom = journeyIdFrom;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public Integer getJourneyIdTo() {
        return journeyIdTo;
    }

    public void setJourneyIdTo(Integer journeyIdTo) {
        this.journeyIdTo = journeyIdTo;
    }

    public String getTrainStatus() {
        return trainStatus;
    }

    public void setTrainStatus(String trainStatus) {
        this.trainStatus = trainStatus;
    }

}

/**
 * //TODO: sql语句
 * select distinct trainid
 * , journeyidfrom
 * , fromstation
 * , journeyidto
 * , tostation
 * , fromdeparttime
 * , fromdepartday
 * , toarrtime
 * , toarriveday
 * , totaldistance
 * , st.seat_name                                  seatname
 * , cast(totaldistance * seat_basic_price as int) ticketprice
 * , status                                        trainstatus
 * <p>
 * from (
 * select x.journey_id                   journeyidfrom,
 * j2.journey_id                  journeyidto,
 * x.train_id                     trainid,
 * x.station_name                 fromstation,
 * s2.station_name                tostation,
 * x.depart_time                  fromdeparttime,
 * x.depart_day                   fromdepartday,
 * j2.arrive_time                 toarrtime,
 * j2.arrive_day                  toarriveday,
 * j2.distance - x.distance       totaldistance,
 * case x.status + j2.status
 * when 0 then 'Normal'
 * when 1 then 'No stop!'
 * when 2 then 'No stop!'
 * else 'Train cancelled' end status
 * from (select *
 * from journeys j
 * join stations s on j.station_id = s.station_id
 * where s.station_name = '武汉') x
 * join journeys j2 on x.train_id = j2.train_id
 * join stations s2 on j2.station_id = s2.station_id
 * where s2.station_name = '深圳北'
 * and x.station_index < j2.station_index
 * ) y
 * join carriages c on y.trainid = c.train_number
 * join seat_type st on c.seat_type_id = st.seat_type_id
 * order by trainid, ticketprice desc;
 * <p>
 * <p>
 * select sum(c.seat_num)
 * from carriages c
 * join seat_type st on c.seat_type_id = st.seat_type_id
 * where c.train_number = 'G77'
 * and st.seat_name = '高铁二等座';
 * <p>
 * select *
 * from (select *
 * from journeys j
 * join stations s on j.station_id = s.station_id
 * where s.station_name = '汉口') x
 * join journeys j2 on x.train_id = j2.train_id
 * join stations s2 on j2.station_id = s2.station_id
 * where s2.station_name = '深圳北'
 * and x.station_index < j2.station_index;
 */
