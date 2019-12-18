package com.orange.jpa.query.infrastructure.repository;

import com.orange.jpa.query.domain.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author xieyong
 * @date 2019/12/18
 * @Description:
 */
@Repository
public interface CustomerQueryDslRepository extends JpaRepository<Customer,Long>, QuerydslPredicateExecutor<Customer> {
}
