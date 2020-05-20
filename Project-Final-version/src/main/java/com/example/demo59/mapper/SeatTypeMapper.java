package com.example.demo59.mapper;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SeatTypeMapper {
    //更新基础票价
    void updateBasicPrice(@Param("seatTypeNameList") Map<String, Double> seatTypeNameList);
}