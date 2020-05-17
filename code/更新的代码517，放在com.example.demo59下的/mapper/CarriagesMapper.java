package com.example.demo59.mapper;

import com.example.demo59.entity.*;
import com.example.demo59.entity.CarriagesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarriagesMapper {

    /**
     * 插入新增车次的车厢信息
     * @param carriagesList carriage类列表
     * @return 无意义
     */
    int insertOneTrainCarriages(@Param("carriageList") List<Carriages> carriagesList);

    int updateByPrimaryKeySelective(Carriages record);

    int updateByPrimaryKey(Carriages record);
}