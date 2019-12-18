package com.orange.jpa.query.infrastructure.repository;

import com.orange.jpa.query.base.BaseJpaRepository;
import com.orange.jpa.query.domain.entity.customer.Customer;
import com.orange.jpa.query.domain.entity.order.customer.QCustomer;
import com.orange.jpa.query.domain.query.QueryDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

/**
 * @author xieyong
 * @date 2019/12/18
 * @Description:
 */
@Repository
public class CustomerQueryRepository extends BaseJpaRepository<Customer,Long> {

    private static final QCustomer qs = QCustomer.customer;

    CustomerQueryRepository(EntityManager em) {
        super(Customer.class, em);
    }

    public List<Customer> getCustomerById(QueryDTO dto, Integer limit, Integer offset){
        BooleanBuilder whereClause=new BooleanBuilder();
        //dynamic
        if(Objects.nonNull(dto.getCustomerId())){
            whereClause.and(qs.customerId.eq(dto.getCustomerId()));
        }

        return jpaQueryFactory.select(Projections.constructor(Customer.class,qs.customerName,qs.customerId))
                .from(qs)
                .where(whereClause)
                .orderBy(qs.customerId.desc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}
