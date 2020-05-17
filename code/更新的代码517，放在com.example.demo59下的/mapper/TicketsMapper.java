package com.example.demo59.mapper;

import com.example.demo59.entity.Tickets;
//import com.example.demo59.entity.TicketsExample;
import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketsMapper {
    int insert(Tickets record);

    int insertSelective(Tickets record);

    Tickets selectByPrimaryKey(Integer ticket_id);

    int updateByPrimaryKeySelective(Tickets record);

    int updateByPrimaryKey(Tickets record);
}