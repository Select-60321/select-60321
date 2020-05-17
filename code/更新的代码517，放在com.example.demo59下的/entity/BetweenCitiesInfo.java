package com.example.demo59.entity;

import java.sql.Time;

/**
 * temporary class for searching the tickets information between the cities
 *
 * @author lori
 */
public class BetweenCitiesInfo {
    private Integer journeyIdFrom;
    private Integer journeyIdTo;
    private String trainNum;
    private Integer stationIdxFrom;
    private String stationFrom;
    private String fromLocationCity;
    private Integer stationIdxTo;
    private String stationTo;
    private String toLocationCity;
    private Time startTime;
    private Integer startDay;
    private Time endTime;
    private Integer endDay;
    private Integer totalDistance;
    private Integer seatTypeId;
    private String seatName;
    private Integer ticketPrice;
    private String trainStatus;
    private Integer restTickets;

    public Integer getRestTickets() {
        return restTickets;
    }

    public void setRestTickets(Integer restTickets) {
        this.restTickets = restTickets;
    }

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public Integer getJourneyIdTo() {
        return journeyIdTo;
    }

    public void setJourneyIdTo(Integer journeyIdTo) {
        this.journeyIdTo = journeyIdTo;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public Integer getStationIdxFrom() {
        return stationIdxFrom;
    }

    public void setStationIdxFrom(Integer stationIdxFrom) {
        this.stationIdxFrom = stationIdxFrom;
    }

    public String getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
    }

    public String getFromLocationCity() {
        return fromLocationCity;
    }

    public void setFromLocationCity(String fromLocationCity) {
        this.fromLocationCity = fromLocationCity;
    }

    public Integer getStationIdxTo() {
        return stationIdxTo;
    }

    public void setStationIdxTo(Integer stationIdxTo) {
        this.stationIdxTo = stationIdxTo;
    }

    public String getStationTo() {
        return stationTo;
    }

    public void setStationTo(String stationTo) {
        this.stationTo = stationTo;
    }

    public String getToLocationCity() {
        return toLocationCity;
    }

    public void setToLocationCity(String toLocationCity) {
        this.toLocationCity = toLocationCity;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
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

    public Integer getJourneyIdFrom() {
        return journeyIdFrom;
    }

    public void setJourneyIdFrom(Integer journeyIdFrom) {
        this.journeyIdFrom = journeyIdFrom;
    }

    public String getTrainStatus() {
        return trainStatus;
    }

    public void setTrainStatus(String trainStatus) {
        this.trainStatus = trainStatus;
    }

    @Override
    public String toString() {
        return "BetweenCitiesInfo{" +
                "trainNum='" + trainNum + '\'' +
                ", stationFrom='" + stationFrom + '\'' +
                ", fromLocationCity='" + fromLocationCity + '\'' +
                ", stationTo='" + stationTo + '\'' +
                ", toLocationCity='" + toLocationCity + '\'' +
                ", startTime=" + startTime +
                ", startDay=" + startDay +
                ", endTime=" + endTime +
                ", endDay=" + endDay +
                ", totalDistance=" + totalDistance +
                ", seatName='" + seatName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", trainStatus='" + trainStatus + '\'' +
                ", restTickets=" + restTickets +
                '}';
    }
}

/**
 * //TODO: sql 语句
 * select distinct journeyidfrom,
 * journeyidto,
 * trainnum,
 * stationidxfrom,
 * stationfrom,
 * fromlocationcity,
 * stationidxto,
 * stationto,
 * tolocationcity,
 * starttime,
 * startday,
 * endtime,
 * endday,
 * totaldistance,
 * st.seat_name                                  seatname,
 * cast(totaldistance * seat_basic_price as int) ticketprice,
 * status                                        trainstatus
 * from (
 * select journeyidfrom,
 * trainnum,
 * stationidxfrom,
 * stationfrom,
 * fromlocationcity,
 * j2.journey_id                  journeyidto,
 * j2.station_index               stationidxto,
 * s2.station_name                stationto,
 * c2.city_name                   tolocationcity,
 * starttime,
 * startday,
 * j2.arrive_time                 endtime,
 * j2.arrive_day                  endday,
 * j2.distance - startdistance    totaldistance,
 * case startstatus + j2.status
 * when 0 then 'Normal'
 * when 1 then 'No stop!'
 * when 2 then 'No stop!'
 * else 'Train cancelled' end status
 * from (select j.journey_id    journeyidfrom,
 * j.train_id      trainnum,
 * s.station_name  stationfrom,
 * c.city_name     fromlocationcity,
 * j.station_index stationidxfrom,
 * j.depart_time   starttime,
 * j.depart_day    startday,
 * j.distance      startdistance,
 * j.status        startstatus
 * from journeys j
 * join stations s on j.station_id = s.station_id
 * join cities c on s.city_id = c.city_id
 * where c.city_name = '武汉市') x
 * join journeys j2 on x.trainnum = j2.train_id
 * join stations s2 on j2.station_id = s2.station_id
 * join cities c2 on s2.city_id = c2.city_id
 * where c2.city_name = '深圳市'
 * and x.stationidxfrom < j2.station_index) y
 * join carriages c3 on y.trainnum = c3.train_number
 * join seat_type st on c3.seat_type_id = st.seat_type_id
 * order by trainnum, ticketprice desc;
 */
