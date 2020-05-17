package com.example.demo59.entity;

/**
 * 用于查找订单的入参
 */

public class SearchForOrdersWrapper {
    private String userName;
    private Integer orderId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "SearchForOrdersWrapper{" +
                "userName='" + userName + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
