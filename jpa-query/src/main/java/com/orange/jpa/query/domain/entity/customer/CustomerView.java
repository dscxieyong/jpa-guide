package com.orange.jpa.query.domain.entity.customer;

import com.orange.jpa.query.domain.entity.order.Order;

import java.util.Set;

/**
 * @author xieyong
 * @date 2019/12/18
 * @Description:
 */
public interface CustomerView {

    Integer getCustomerId();

    String getCustomerName();

    Set<Order> getOrderSet();
}
