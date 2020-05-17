package com.example.demo59.mapper;

import com.example.demo59.entity.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SeatTypeMapper {
    //根据主键选座位种类和座位单价
    SeatType selectByPrimaryKey(Integer seat_type_id);

    //选出所有座位种类
    List<SeatType> selectAllSeatType();

    //更新基础票价
    void updateBasicPrice(@Param("seatTypeNameList") Map<String, Double> seatTypeNameList);
}