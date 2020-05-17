package com.example.demo59.mapper;
import com.example.demo59.entity.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsersMapper {


    /**
     * 通过用户名和密码来找用户
     * @param username 用户名
     * @param password 密码（通过MD5加密）
     * @return 用户类
     */
    Users findUserByUsernameAndPassword(String username, String password);

    /**
     * 通过用户名找用户
     * @param user_name 用户名
     * @return 用户类
     */
    Users findUserByUsername(String user_name);

    /**
     * 插入用户
     * @param users 用户实体类
     * @return 无意义
     */
    int insertUser(Users users);

    /**
     * 插入订单，入参必须是三个
     * @param orders 订单入参
     */
    void insertOneOrder(Orders orders);

    Orders getNewOrders();

    /**
     * 更新订单价格
     * @param orderId 订单id
     */
    void updateOrderPrice(Integer orderId);

    /**
     * 插入单张票，可以被下面的多张票的取代
     * @param tickets
     */
    void insertTickets(Tickets tickets);

    /**
     * 插入多张票
     * @param ticketsList 票列表
     */
    void insertMultiTickets(@Param("ticketsList") List<Tickets> ticketsList);

    /**
     * 更新订单状态，已支付等等
     * @param orderId 订单号
     * @param status 订单状态  0 未支付 1 已支付
     * @return 无意义
     */
    int updateOrderStatus(Integer orderId,Integer status);

}