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
public interface CustomerJpaRepository extends JpaRepository<Customer,Long> {

    /**
     * 需要加上@EntityGraph，否则存在n+1的问题
     * @param customerName
     * @return
     */
    @EntityGraph(attributePaths = "orders")
    List<CustomerView> findByCustomerName(String customerName);

    /**
     *
     * @param customerName
     * @param pageable
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from customer s " +
                    "where (:customerName is null or s.customer_name=:customerName)")
    Page<Customer> findCustomers(@Param("customerName") String  customerName, Pageable pageable);
}
