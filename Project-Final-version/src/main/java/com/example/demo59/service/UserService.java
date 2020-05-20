package com.example.demo59.service;

import com.example.demo59.entity.*;
import com.example.demo59.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * 用户业务端，只注入UserMapper和 TrainMapper
 * 防止改表
 */
@Service
public class UserService {

    @Autowired
    UsersMapper usersMapper;

    /**
     * 到users表里找用户是否存在
     *
     * @param users 入参，用户名和密码（已通过MD5加密的入参）
     * @return 用户
     */
    public Users findExistUserByUsrnameAndPasswd(Users users) {
        if (users.getUserName() == null || users.getPassword() == null) {
            return null;
        }
        return usersMapper.findUserByUsernameAndPassword(users.getUserName(), users.getPassword());
    }

    /**
     * 插入user
     *
     * @param users 用户信息
     * @return 返回1
     */
    public int insertUser(Users users) {
        return usersMapper.insertUser(users);
    }

    /**
     * 通过用户名找用户
     *
     * @param name 用户名
     * @return 用户类
     */

    public Users findUserByUsername(String name) {
        return usersMapper.findUserByUsername(name);
    }

    /**
     * 插入一个订单
     *
     * @param orders 订单实体类
     */
    public void insertOneOrder(Orders orders) {
        usersMapper.insertOneOrder(orders);
    }

    /**
     * 得到最新的订单信息
     *
     * @return
     */
    public Orders getNewOrders() {
        return usersMapper.getNewOrders();
    }

    /**
     * 更新订单价格
     *
     * @param orderId 订单号
     */
    public void updateOrderPrice(Integer orderId) {
        usersMapper.updateOrderPrice(orderId);
    }

    /**
     * 买票，插表
     *
     * @param tickets 票实例
     */
    public void insertTickets(Tickets tickets) {
        usersMapper.insertTickets(tickets);

    }

    /**
     * 插入多张票
     *
     * @param ticketsList 票列表
     */
    public void insertMultiTickets(List<Tickets> ticketsList) {
        usersMapper.insertMultiTickets(ticketsList);
    }

    @Autowired
    TrainMapper trainMapper;

    /**
     * 查票信息
     *
     * @param station1 起始站
     * @param station2 目的地
     * @return 火车列表
     */
    public List<BetweenStationsInfo> findTicketsBetweenStations(String station1, String station2, Date departDate) {
        List<BetweenStationsInfo> tmp = trainMapper.findTicketsBetweenStations(station1, station2);
        for (BetweenStationsInfo info : tmp) {
            int total = trainMapper.getNumberOfCertainTrainCertainSeatType(info.getTrainId(), info.getSeatName());
            int takenUp = trainMapper.getTrainBoughtCertainTickets(info.getTrainId(), info.getSeatTypeId(),
                    info.getStationIdxFrom(), info.getStationIdxTo(), departDate);
            info.setRestTickets(total - takenUp);
        }
        return tmp;
    }

    /**
     * 查票信息
     *
     * @param city1 起始城市
     * @param city2 目的城市
     * @return 火车列表
     */
    public List<BetweenCitiesInfo> findTicketsBetweenCities(String city1, String city2, Date departDate) {
        List<BetweenCitiesInfo> tmp = trainMapper.findTicketsBetweenCities(city1, city2);
        for (BetweenCitiesInfo info : tmp) {
            int total = trainMapper.getNumberOfCertainTrainCertainSeatType(info.getTrainNum(), info.getSeatName());
            int takenUp = trainMapper.getTrainBoughtCertainTickets(info.getTrainNum(), info.getSeatTypeId(),
                    info.getStationIdxFrom(), info.getStationIdxTo(), departDate);
            info.setRestTickets(total - takenUp);
        }
        return tmp;
    }



    /**
     * 获取对应车厢的总座位数
     *
     * @param trainNumber 车次
     * @param seatTypeId  车座位种类
     * @return <车厢,车座位数>列表
     */
    public List<CarriageNoAndSeatNo> getCarriageNoFromSeatType(String trainNumber, Integer seatTypeId) {
        return trainMapper.getCarriageNoFromSeatType(trainNumber, seatTypeId);
    }

    /**
     * 根据车次查询车次信息
     *
     * @param trainNumber 车次
     * @return 车列表
     */
    public List<Train> trainDetailsByTrainNumber(String trainNumber) {
        return trainMapper.trainDetailsByTrainNumber(trainNumber);
    }


    /**
     * 计算某一车厢已买的票数
     *
     * @param trainNumber    车次
     * @param carriageNo     车厢号
     * @param stationFromIdx 上车站排序号
     * @param stationToIdx   下车站排序号
     * @param departDate     出发日期
     * @return 已卖票数
     */
    public int getTrainCarriageNowBoughtTickets(String trainNumber,
                                                Integer carriageNo,
                                                Integer stationFromIdx,
                                                Integer stationToIdx,
                                                Date departDate) {
        return trainMapper.getTrainCarriageNowBoughtTickets(trainNumber, carriageNo,
                stationFromIdx, stationToIdx, departDate);
    }

    /**
     * 退票
     * @param id 票id
     * @return 无意义
     */
    public Integer refund(Integer id){
        trainMapper.updateByPrimaryKeySelective(id);
        return trainMapper.findOrderId(id);
    }


    /**
     * 根据站到站进行订票
     *
     * @param info       站到站类
     * @param departDate 出发日期
     * @param userId     用户id
     * @return 订单号
     */
    public int purchaseTicketsStaToSta(BetweenStationsInfo info, Date departDate, Integer userId) {
        Orders orders = new Orders();
        orders.setPerson(userId);
        orders.setOrderPrice(0.0);
        orders.setOrderStatus(0);
        List<CarriageNoAndSeatNo> carriageNoAndSeatNoList = getCarriageNoFromSeatType(info.getTrainId(), info.getSeatTypeId());
        Tickets tickets = new Tickets();
        int takenUp = trainMapper.getTrainBoughtCertainTicketsCalculateSeatNum(info.getTrainId(), info.getSeatTypeId(),
                info.getStationIdxFrom(), info.getStationIdxTo(), departDate);

        for (CarriageNoAndSeatNo no : carriageNoAndSeatNoList) {
            System.err.println(takenUp);
            if (takenUp < no.getSeatNum()) {
                tickets.setCarriageId(no.getCarriageIndex());
                int row = (takenUp + 1) / 5;
                int column = (takenUp) % 5;
                switch (column) {
                    case 0:
                        System.err.println((row + 1) + "A");
                        tickets.setSeatNum((row + 1) + "A");
                        break;
                    case 1:
                        System.err.println((row + 1) + "B");
                        tickets.setSeatNum((row + 1) + "B");
                        break;
                    case 2:
                        System.err.println((row + 1) + "C");
                        tickets.setSeatNum((row + 1) + "C");
                        break;
                    case 3:
                        System.err.println((row + 1) + "D");
                        tickets.setSeatNum((row + 1) + "D");
                        break;
                    default:
                        System.err.println((row + 1) + "F");
                        tickets.setSeatNum((row + 1) + "F");
                }
                break;
            } else {
                takenUp -= no.getSeatNum();
            }
        }
        insertOneOrder(orders);
        Orders newOrder = getNewOrders();
        int orderId = newOrder.getOrderId();
        double price = info.getTicketPrice();
        tickets.setOrderId(orderId);

        tickets.setDepartJourney(info.getJourneyIdFrom());
        tickets.setArriveJourney(info.getJourneyIdTo());
        tickets.setDepartDate(departDate);
        tickets.setTicketPrice(price);
        tickets.setSeatTypeId(info.getSeatTypeId());

        insertTickets(tickets);
        updateOrderPrice(orderId);
        usersMapper.updateOrderStatus(orderId, 1);
        return orderId;
    }

    /**
     * 返回订单详情
     *
     * @param userName 用户名
     * @param orderId  订单号
     * @return 订单列表
     */
    public List<OrdersDetails> getOrdersByNameAndOrderId(String userName, Integer orderId) {
        SearchForOrdersWrapper searchForOrdersWrapper = new SearchForOrdersWrapper();
        searchForOrdersWrapper.setUserName(userName);
        searchForOrdersWrapper.setOrderId(orderId);
        return trainMapper.getOrderDetails(searchForOrdersWrapper);
    }


    /**
     * 城市到城市买票
     *
     * @param info       城市之间列车信息
     * @param departDate 出发日期
     * @param userId     用户id
     * @return 订单号
     */
    public int purchaseTicketsCityToCity(BetweenCitiesInfo info, Date departDate, Integer userId) {
        Orders orders = new Orders();
        orders.setPerson(userId);
        orders.setOrderPrice(0.0);
        orders.setOrderStatus(0);
        List<CarriageNoAndSeatNo> carriageNoAndSeatNoList = getCarriageNoFromSeatType(info.getTrainNum(), info.getSeatTypeId());
        Tickets tickets = new Tickets();
        int takenUp = trainMapper.getTrainBoughtCertainTicketsCalculateSeatNum(info.getTrainNum(), info.getSeatTypeId(),
                info.getStationIdxFrom(), info.getStationIdxTo(), departDate);
        for (CarriageNoAndSeatNo no : carriageNoAndSeatNoList) {
//            System.err.println(takenUp);
            if (takenUp < no.getSeatNum()) {
                tickets.setCarriageId(no.getCarriageIndex());
                int row = (takenUp + 1) / 5;
                int column = (takenUp) % 5;
                switch (column) {
                    case 0:
                        System.err.println((row + 1) + "A");
                        tickets.setSeatNum((row + 1) + "A");
                        break;
                    case 1:
                        System.err.println((row + 1) + "B");
                        tickets.setSeatNum((row + 1) + "B");
                        break;
                    case 2:
                        System.err.println((row + 1) + "C");
                        tickets.setSeatNum((row + 1) + "C");
                        break;
                    case 3:
                        System.err.println((row + 1) + "D");
                        tickets.setSeatNum((row + 1) + "D");
                        break;
                    default:
                        System.err.println((row + 1) + "F");
                        tickets.setSeatNum((row + 1) + "F");
                }
                break;
            } else {
                takenUp -= no.getSeatNum();
            }
        }
        insertOneOrder(orders);
        Orders newOrder = getNewOrders();
        int orderId = newOrder.getOrderId();
        double price = info.getTicketPrice();
        tickets.setOrderId(orderId);

        tickets.setDepartJourney(info.getJourneyIdFrom());
        tickets.setArriveJourney(info.getJourneyIdTo());
        tickets.setDepartDate(departDate);
        tickets.setTicketPrice(price);
        tickets.setSeatTypeId(info.getSeatTypeId());

        insertTickets(tickets);
        updateOrderPrice(orderId);
        usersMapper.updateOrderStatus(orderId, 1);
        return orderId;
    }

}
