package com.example.demo59;

import com.example.demo59.entity.*;
import com.example.demo59.service.*;
import com.example.demo59.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo59.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class Demo59ApplicationTests {

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    Date departDate = new Date(120, 4, 20);

    @Test
    void testInsertStation() {
        String cityName = "武汉市";
        String newStation = "测试站1";
        System.err.println(adminService.insertOneStation(cityName, newStation));
//        System.err.println(adminService.findExistStationInfo(newStation));
    }

    @Test
    public void getTicketQuery() {
        System.err.println(userService.findTicketsBetweenStations("武汉", "深圳北", departDate));//size 为 0 表示啥也没有
    }

//    @Test
//    public void getTotalNumberCertainTicket() {
//        System.err.println(userService.getTotalNumbrCertainTicket("G77", "高铁二等座"));
//    }


    @Test
    public void getTicketQueryBetweenCities() {
        System.err.println(userService.findTicketsBetweenCities("武汉市", "深圳市", departDate));
    }

    @Test
    void testInsertOneStation() {
        adminService.insertOneStationIntoExistTrain("Z80",
                1503, new Time(15, 9, 0),
                2, 2000, new Time(6, 30, 0), 2);
    }

    @Test
    void updateBasicPrice() {
        Map<String, Double> map = new HashMap<>();
//        map.put("高铁商务座", 1.486); // 1.486
//        map.put("高铁一等座", 0.74); // 0.74
//        map.put("高铁二等座", 0.46); // 0.46
        adminService.updateBasicPrice(map);
    }

    @Test
    void trainDetailsByTrainNumber() {
        System.err.println(userService.trainDetailsByTrainNumber("Z80"));
    }

//    @Test
//    void selectAllSeatType() {
//        System.err.println(adminService.selectAllSeatType());
//    }

    /**
     * 测试找订单的
     */
    @Test
    void selectAllOrdersByUserNameOrUserNameAndOrderId() {
        System.err.println(userService.getOrdersByNameAndOrderId("nqsnb", 31));
    }

    @Test
    void test5() {
        System.err.println(userService.getCarriageNoFromSeatType("G77", 2));
    }

    @Test
    void test6() {
        String a = "12345678";
        String b = MD5Util.generatePassword(a);
        System.err.println(b);
        Users users = new Users();
        users.setUserName("黎诗龙");
        users.setPassword(MD5Util.generatePassword("lsl213"));
        System.err.println(userService.findExistUserByUsrnameAndPasswd(users));
    }

    @Test
    /**
     * 测试城市到城市买票
     */
    void test7() {
        Users users = new Users();
        users.setUserName("nqsnb");
        users.setPassword(MD5Util.generatePassword("12345678"));
        Users tmp = userService.findExistUserByUsrnameAndPasswd(users);
        if (tmp == null) {
            System.err.println("密码错误");
        } else {
            //第一张票
            List<BetweenCitiesInfo> tmp1 = userService.findTicketsBetweenCities("深圳市", "乌鲁木齐市", departDate);
//            BetweenCitiesInfo tmp2 = tmp1.get(0);
//            Tickets tickets1 = new Tickets();
//            List<CarriageNoAndSeatNo> carriages = userService.getCarriageNoFromSeatType(tmp2.getTrainNum(), tmp2.getSeatTypeId());
//
//            double ticketprice = tmp2.getTicketPrice();
            Orders orders = new Orders();
            orders.setPerson(tmp.getUserId());
            orders.setOrderPrice(0.0);
            orders.setOrderStatus(0);
            int counter = 0;
            userService.insertOneOrder(orders);
            Orders newOrder = userService.getNewOrders();
            int orderId = newOrder.getOrderId();
//            tickets1.setOrderId(orderId);
//            tickets1.setCarriageId(carriages.get(0).getCarriageIndex());
//            tickets1.setDepartJourney(tmp2.getJourneyIdFrom());
//            tickets1.setArriveJourney(tmp2.getJourneyIdTo());
//            tickets1.setDepartDate(new Date(120, 4, 20));
//            tickets1.setTicketPrice(ticketprice);
//            tickets1.setSeatTypeId(tmp2.getSeatTypeId());


            List<Tickets> ticketsList = new ArrayList<>();
            for (BetweenCitiesInfo info : tmp1) {
                counter++;
                Tickets tickets = new Tickets();
                List<CarriageNoAndSeatNo> carriageNoAndSeatNoList = userService.getCarriageNoFromSeatType(info.getTrainNum(), info.getSeatTypeId());
                double ticketp = info.getTicketPrice();
                tickets.setOrderId(orderId);
                tickets.setCarriageId(carriageNoAndSeatNoList.get(0).getCarriageIndex());
                tickets.setDepartJourney(info.getJourneyIdFrom());
                tickets.setArriveJourney(info.getJourneyIdTo());
                tickets.setDepartDate(new Date(120, 4, 20));
                tickets.setTicketPrice(ticketp);
                tickets.setSeatTypeId(info.getSeatTypeId());
                ticketsList.add(tickets);
                if (counter == 4) break;
            }


//            userService.insertTickets(tickets1);
            userService.insertMultiTickets(ticketsList);
            userService.updateOrderPrice(orderId);
        }
    }

    /**
     * 测试站到站买票
     */
    @Test
    void test8() {
        Users users = new Users();
        users.setUserName("nqsnb");
        users.setPassword(MD5Util.generatePassword("12345678"));
        Users tmp = userService.findExistUserByUsrnameAndPasswd(users);
        if (tmp == null) {
            System.err.println("密码错误");
        } else {

            List<BetweenStationsInfo> tmp1 = userService.findTicketsBetweenStations("武汉", "深圳北", departDate);
//这里还要判断是否为null
            Orders orders = new Orders();
            orders.setPerson(tmp.getUserId());
            orders.setOrderPrice(0.0);
            orders.setOrderStatus(0);
            Date departDate = new Date(120, 4, 20);

            userService.insertOneOrder(orders);
            Orders newOrder = userService.getNewOrders();
            int orderId = newOrder.getOrderId();

//            int counter = 0;
            List<Tickets> ticketsList = new ArrayList<>();
            int counter = 0;
            for (BetweenStationsInfo info : tmp1) {
                if (counter == 0) {
                    counter++;
                    continue;
                }
                Tickets tickets = new Tickets();
                List<CarriageNoAndSeatNo> carriageNoAndSeatNoList = userService.getCarriageNoFromSeatType(info.getTrainId(), info.getSeatTypeId());

                for (CarriageNoAndSeatNo no : carriageNoAndSeatNoList) {
                    int takenUpSeat = userService.getTrainCarriageNowBoughtTickets(info.getTrainId(), no.getCarriageIndex(), info.getStationIdxFrom(), info.getStationIdxTo(), departDate);
                    System.err.println(takenUpSeat);
                    if (takenUpSeat < no.getSeatNum()) {
                        tickets.setCarriageId(no.getCarriageIndex());
                        break;
                    }
                }
                double ticketp = info.getTicketPrice();

                tickets.setOrderId(orderId);
//                tickets.setCarriageId(carriageNoAndSeatNoList.get(0).getCarriageIndex());
                tickets.setDepartJourney(info.getJourneyIdFrom());
                tickets.setArriveJourney(info.getJourneyIdTo());
                tickets.setDepartDate(departDate);
                tickets.setTicketPrice(ticketp);
                tickets.setSeatTypeId(info.getSeatTypeId());
                ticketsList.add(tickets);
                break;
            }

//            userService.insertTickets(tickets1);
            userService.insertMultiTickets(ticketsList);
            userService.updateOrderPrice(orderId);
            //接下来是确认订单并支付，支付成功就将order_status改成1
        }
    }


    @Test
        //测试中转站
    void test9() {
        Users users = new Users();
        users.setUserName("nqsnb");
        users.setPassword(MD5Util.generatePassword("12345678"));
        Users tmp = userService.findExistUserByUsrnameAndPasswd(users);
        if (tmp == null) {
            System.err.println("密码错误");
        } else {
            List<BetweenStationsInfo> tmp1 = userService.findTicketsBetweenStations("武汉", "汉口", departDate);
            if (tmp1.size() == 0) {
                return;
            }
            List<BetweenStationsInfo> tmp2 = userService.findTicketsBetweenStations("汉口", "深圳", departDate);
            if (tmp2.size() == 0) {
                return;
            }
//这里还要判断是否为null
            Orders orders = new Orders();
            orders.setPerson(tmp.getUserId());
            orders.setOrderPrice(0.0);
            orders.setOrderStatus(0);

            userService.insertOneOrder(orders);
            Orders newOrder = userService.getNewOrders();
            int orderId = newOrder.getOrderId();


//            int counter = 0;
            List<Tickets> ticketsList = new ArrayList<>();
            for (int i = 0; i < tmp1.size() && i < tmp2.size(); i++) {
                Tickets tickets = new Tickets();
                List<CarriageNoAndSeatNo> carriageNoAndSeatNoList = userService.getCarriageNoFromSeatType(tmp1.get(i).getTrainId(), tmp1.get(i).getSeatTypeId());
                double ticketp = tmp1.get(i).getTicketPrice();
                tickets.setOrderId(orderId);
                tickets.setCarriageId(carriageNoAndSeatNoList.get(0).getCarriageIndex());
                tickets.setDepartJourney(tmp1.get(i).getJourneyIdFrom());
                tickets.setArriveJourney(tmp1.get(i).getJourneyIdTo());
                tickets.setDepartDate(new Date(120, 4, 20));
                tickets.setTicketPrice(ticketp);
                tickets.setSeatTypeId(tmp1.get(i).getSeatTypeId());
                ticketsList.add(tickets);

                Tickets tickets1 = new Tickets();
                List<CarriageNoAndSeatNo> carriageNoAndSeatNoList2 = userService.getCarriageNoFromSeatType(tmp2.get(i).getTrainId(), tmp2.get(i).getSeatTypeId());
                double ticketp2 = tmp2.get(i).getTicketPrice();
                tickets1.setOrderId(orderId);
                tickets1.setCarriageId(carriageNoAndSeatNoList2.get(0).getCarriageIndex());
                tickets1.setDepartJourney(tmp2.get(i).getJourneyIdFrom());
                tickets1.setArriveJourney(tmp2.get(i).getJourneyIdTo());
                tickets1.setDepartDate(new Date(120, 4, 20));
                tickets1.setTicketPrice(ticketp2);
                tickets1.setSeatTypeId(tmp2.get(i).getSeatTypeId());
                ticketsList.add(tickets1);
                break;
            }

//            userService.insertTickets(tickets1);
            userService.insertMultiTickets(ticketsList);
            userService.updateOrderPrice(orderId);
            //接下来是确认订单并支付，支付成功就将order_status改成1
        }
    }

    @Test
    /**
     * 加站
     */
    void testAddingOneTrain() {

        String newTrainNumber = "NQS";
        List<String> stationName = new ArrayList<>();
        List<Integer> arriveDay = new ArrayList<>();
        List<Time> arriveTime = new ArrayList<>();
        List<Integer> departDay = new ArrayList<>();
        List<Time> departTime = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();
        stationName.add("武汉");//第一站
        stationName.add("武昌");
        stationName.add("汉口");

        arriveDay.add(null);
        arriveDay.add(1);
        arriveDay.add(2);

        arriveTime.add(null);
        arriveTime.add(new Time(0, 5, 0));
        arriveTime.add(new Time(0, 59, 0));

        departDay.add(1);
        departDay.add(1);
        departDay.add(null);

        departTime.add(new Time(0, 3, 0));
        departTime.add(new Time(1, 5, 0));
        departTime.add(null);


        distance.add(0);
        distance.add(1);
        distance.add(2);
        List<Journeys> journeysList = new ArrayList<>();
        List<Carriages> carriagesList = new ArrayList<>();


        Journeys journeys1 = new Journeys();
        journeys1.setDistance(0);
        journeys1.setArriveDay(null);
        journeys1.setArriveTime(null);
        journeys1.setDepartDay(1);
        journeys1.setDepartTime(new Time(0, 3, 0));
        journeys1.setStationId(1483);
        journeys1.setStationIndex(1);
        journeys1.setTrainId("NQSL");
        journeysList.add(journeys1);

        Journeys journeys2 = new Journeys();
        journeys2.setDistance(1);
        journeys2.setArriveDay(1);
        journeys2.setArriveTime(new Time(0, 5, 0));
        journeys2.setDepartDay(1);
        journeys2.setDepartTime(new Time(1, 5, 0));
        journeys2.setStationId(1491);
        journeys2.setStationIndex(2);
        journeys2.setTrainId("NQSL");
        journeysList.add(journeys2);

        Journeys journeys3 = new Journeys();
        journeys3.setDistance(2);
        journeys3.setArriveDay(2);
        journeys3.setArriveTime(new Time(0, 59, 0));
        journeys3.setDepartDay(null);
        journeys3.setDepartTime(null);
        journeys3.setStationId(1503);
        journeys3.setStationIndex(3);
        journeys3.setTrainId("NQSL");
        journeysList.add(journeys3);


        for (int i = 1; i <= 4; i++) {
            Carriages carriages = new Carriages();
            carriages.setTrainNumber("NQSL");
            carriages.setCarriageIndex(i);
            carriages.setSeatTypeId(i);
            carriages.setSeatNum(40);
            carriagesList.add(carriages);
        }
        System.err.println(adminService.insertOneTrain(journeysList, carriagesList));
    }

    @Test
    /**
     * 买票
     */
    void testButTicket() {
        Users users = new Users();
        users.setUserName("nqsnb");
        users.setPassword(MD5Util.generatePassword("12345678"));
        Users tmp = userService.findExistUserByUsrnameAndPasswd(users);
        if (tmp == null) {
            System.err.println("密码错误");
        } else {
            List<BetweenStationsInfo> tmp1 = userService.findTicketsBetweenStations("武汉", "深圳北", departDate);
            userService.purchaseTicketsStaToSta(tmp1.get(20), departDate, tmp.getUserId());
            //接下来是确认订单并支付，支付成功就将order_status改成1
        }
    }

    @Test
    /**
     * 城市到城市买票
     */
    void testBuyTicket() {
        Users users = new Users();
        users.setUserName("nqsnb");
        users.setPassword(MD5Util.generatePassword("12345678"));
        Users tmp = userService.findExistUserByUsrnameAndPasswd(users);
        if (tmp == null) {
            System.err.println("密码错误");
        } else {
            List<BetweenCitiesInfo> tmp1 = userService.findTicketsBetweenCities("武汉市", "深圳市", departDate);
            if (tmp1.size() == 0) {
                System.err.println("不能买票");
            } else {
                userService.purchaseTicketsCityToCity(tmp1.get(20), departDate, tmp.getUserId());
                userService.purchaseTicketsCityToCity(tmp1.get(20), departDate, tmp.getUserId());
                userService.purchaseTicketsCityToCity(tmp1.get(20), departDate, tmp.getUserId());
                userService.purchaseTicketsCityToCity(tmp1.get(20), departDate, tmp.getUserId());
                userService.purchaseTicketsCityToCity(tmp1.get(20), departDate, tmp.getUserId());
            }
            //接下来是确认订单并支付，支付成功就将order_status改成1
        }
    }
}

