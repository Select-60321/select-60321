package com.example.demo59.mapper;

import com.example.demo59.entity.*;

import java.sql.Date;
import java.util.List;

/**
 * 专门用来集合所有的查询接口，防止更改表格数据
 */
public interface TrainMapper {

    /**
     * 通过车次来查询该车次的每一站
     *
     * @param trainNumber 车次
     * @return 车次的信息
     */
    List<Train> trainDetailsByTrainNumber(String trainNumber);

    /**
     * 查找订单，动态sql，根据用户名和订单号
     *
     * @param searchForOrdersWrapper 包含用户名和订单号，动态sql
     * @return 所有订单
     */
    List<OrdersDetails> getOrderDetails(SearchForOrdersWrapper searchForOrdersWrapper);

    /**
     * 某趟列车某种座位有多少个
     *
     * @param trainNumber 车次
     * @param seatType    座位种类
     * @return 座位数量
     */
    int getNumberOfCertainTrainCertainSeatType(String trainNumber, String seatType);

    /**
     * 根据车站名来找票
     *
     * @param station1 出发地站名
     * @param station2 目的地站名
     * @return 车次信息
     */
    List<BetweenStationsInfo> findTicketsBetweenStations(String station1, String station2);

    /**
     * 根据城市名来找票
     *
     * @param city1 出发地
     * @param city2 目的地
     * @return 车次信息
     */
    List<BetweenCitiesInfo> findTicketsBetweenCities(String city1, String city2);

    /**
     * 得到所有满足条件的车厢号
     *
     * @param trainNumber 车次
     * @param seatTypeId  座位种类, e.g. 硬座 -> 对应的id etc.
     * @return 车厢号列表
     */
    List<CarriageNoAndSeatNo> getCarriageNoFromSeatType(String trainNumber, Integer seatTypeId);

    /**
     * 返回已占座位数量
     *
     * @param carriageNo     车厢号
     * @param journeyFromIdx 出发地
     * @param journeyToIdx   目的地
     * @param departDate     出发日期
     * @param trainNumber    车次
     * @return 已占座位数量列表
     *
     */

    int getTrainCarriageNowBoughtTickets(String trainNumber,
                                             Integer carriageNo,
                                             Integer journeyFromIdx,
                                             Integer journeyToIdx,
                                             Date departDate);

     /**
     * 计算余票时用到的
     * @param trainNumber
     * @param seatTypeId
     * @param stationFromIdx
     * @param stationToIdx
     * @param departDate
     * @return
     */
    int getTrainBoughtCertainTickets(String trainNumber, Integer seatTypeId, Integer stationFromIdx, Integer stationToIdx, Date departDate);

    /**
     * 计算座位号时用到的
     * @param trainNumber
     * @param seatTypeId
     * @param stationFromIdx
     * @param stationToIdx
     * @param departDate
     * @return
     */
    int getTrainBoughtCertainTicketsCalculateSeatNum(String trainNumber, Integer seatTypeId, Integer stationFromIdx, Integer stationToIdx, Date departDate);
    /**
     * 退票
     * @param id 票id
     * @return 无意义
     */
    int updateByPrimaryKeySelective(Integer id);

    Integer findOrderId(Integer id);
}
