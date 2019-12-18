package com.orange.jpa.query.infrastructure.repository;

import com.orange.jpa.query.domain.entity.customer.Customer;
import com.orange.jpa.query.domain.entity.order.QOrder;
import com.orange.jpa.query.domain.entity.order.customer.QCustomer;
import com.orange.jpa.query.domain.query.QueryDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author xieyong
 * @date 2019/12/18
 * @Description:
 */
@Repository
public class CustomerQueryRepository extends BaseJpaRepository<Customer,Long> {

    private static final QCustomer qs = QCustomer.customer;
    private static final QOrder qo = QOrder.order;
    CustomerQueryRepository(EntityManager em) {
        super(Customer.class, em);
    }

    public List<Customer> getCustomer(QueryDTO dto, Integer limit, Integer offset){
        BooleanBuilder whereClause=new BooleanBuilder();
        //dynamic
        if(StringUtils.isNotBlank(dto.getCustomerName())){
            whereClause.and(qs.customerName.eq(dto.getCustomerName()));
        }

        return jpaQueryFactory.selectFrom(qs)
                .from(qs)
                .where(whereClause)
                .orderBy(qs.dateCreate.desc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}
