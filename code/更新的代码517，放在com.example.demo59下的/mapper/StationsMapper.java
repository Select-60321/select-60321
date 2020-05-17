package com.example.demo59.mapper;

import com.example.demo59.entity.Cities;
import com.example.demo59.entity.StationReferToCity;
import com.example.demo59.entity.Stations;
//import com.example.demo59.entity.StationsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StationsMapper {

    /**
     * 选出城市的id
     * @param cityName 城市名
     * @return 城市对象实例
     */
    Cities selectCityByCityName(String cityName);

    /**
     * 插表
     * @param record 实例化对象
     * @return
     */
    int insert(Stations record);

    /**
     * 找到插入的信息，或者是其他站点的信息，站名+城市名+状态+省份
     * @param stationName 站名
     * @return 类
     */
    StationReferToCity findStationByName(String stationName);

    /**
     * 更新站点信息，这里有trigger，所以不需要管journey里面的表
     * @param stationNameList 站名->状态，0为正常，1为关闭
     * @return 1
     */
    int updateActiveInfo(@Param("stationNameList") Map<String, Integer> stationNameList);

    /**
     * 待添加的站点信息
     * @param stationNameList 站点顺序，从后往前添加
     * @return 车站类list
     */
    List<Stations> findStationsByStationNames(@Param("stationNameList") List<String> stationNameList);
}