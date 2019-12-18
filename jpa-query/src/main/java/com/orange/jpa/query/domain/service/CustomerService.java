package com.orange.jpa.query.domain.service;

import com.orange.jpa.query.domain.entity.customer.Customer;
import com.orange.jpa.query.domain.entity.order.customer.QCustomer;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * @author xieyong
 * @date 2019/12/4
 * @Description:
 */
public class CustomerService {
    @Autowired
    private EntityManager entityManager;

    //
    public Customer getCustomerById(Integer customerId){
        QCustomer customer = QCustomer.customer;
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        Customer result = queryFactory.selectFrom(customer)
                .where(customer.customerId.eq(customerId  ))
                .fetchOne();
        return result;
    }


}
