package com.example.demo59.mapper;

import com.example.demo59.entity.*;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JourneysMapper {

    /**
     * 查询列车信息
     * @param trainNumber 列车车次
     * @return list
     */
    List<Journeys> selectByTrainNumber(String trainNumber);

    /**
     * 根据主键更新Journey
     * @param record journey 信息
     * @return
     */
    int updateByPrimaryKey(Journeys record);

    /**
     * 插入新的列车
     * @param journeysList 旅程列表
     * @return
     */
    int insertOneNewTrainIntoJourney(@Param("journeysList") List<Journeys> journeysList);

    /**
     * 插入一个站点
     * @param journeys 一个站的信息
     * @return 无意义
     */
    int insertOneStation(Journeys journeys);
}