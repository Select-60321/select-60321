package com.example.demo59.entity;

/**
 * 车站和城市信息对应类
 */
public class StationReferToCity {
    private String stationName;
    private String cityName;
    private String province;
    private Integer stationActive;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getStationActive() {
        return stationActive;
    }

    public void setStationActive(Integer stationActive) {
        this.stationActive = stationActive;
    }

    @Override
    public String toString() {
        return "StationReferToCity{" +
                "stationName='" + stationName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", province='" + province + '\'' +
                ", stationActive=" + stationActive +
                '}';
    }
}
