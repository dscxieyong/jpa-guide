package com.orange.jpa.query.infrastructure.repository;

import com.orange.jpa.query.domain.entity.customer.Customer;
import com.orange.jpa.query.domain.entity.customer.CustomerView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author xieyong
 * @date 2019/12/4
 * @Description:
 */
@Repository
public interface CustomerJPARepository extends JpaRepository<Customer,Long> {

    /**
     *
     * @param customerName
     * @return
     */
    @EntityGraph(attributePaths = "orderSet")
    List<CustomerView> findByCustomerName(String customerName);

    /**
     *
     * @param CustomerId
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from customer s " +
                    "where (:CustomerId is null or s.customer_id=:CustomerId)")
    Page<Customer> findSchool(@Param("CustomerId") Integer  CustomerId, Pageable pageable);
}
