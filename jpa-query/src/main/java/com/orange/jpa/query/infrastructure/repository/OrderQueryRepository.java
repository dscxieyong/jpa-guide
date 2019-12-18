package com.orange.jpa.query.infrastructure.repository;

import com.orange.jpa.query.domain.entity.customer.Customer;
import com.orange.jpa.query.domain.entity.order.Order;

import javax.persistence.EntityManager;

/**
 * @author xieyong
 * @date 2019/12/18
 * @Description:
 */
public class OrderQueryRepository extends BaseJpaRepository<Order,Long>{

    OrderQueryRepository(EntityManager em) {
        super(Order.class, em);
    }
}
