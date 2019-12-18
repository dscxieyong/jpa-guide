package com.orange.jpa.query

import com.orange.jpa.query.domain.entity.order.customer.QCustomer
import com.orange.jpa.query.domain.query.QueryDTO
import com.orange.jpa.query.infrastructure.repository.CustomerQueryDslRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import spock.lang.Specification

/**
 * @author xieyong* @date 2019/12/18
 * @Description:
 */
@SpringBootTest
class CustomerQueryDslRepositorySpec extends Specification{

    private static QCustomer customer=QCustomer.customer
    @Autowired
    private CustomerQueryDslRepository customerQueryDslRepository;


    /**
     * ^^ 函数式 sql语法不易出错
     * ^^ 类型安全
     * ^^ 支持dynamic sql(通过java层组装Predicate)
     * !! page sort Predicate在service层组装,
     * !! sort需要显式指定列名
     */
    def "querydsl-interface"(){

        Pageable pageable= PageRequest.of(0,5,Sort.by("dateCreate"))

        expect:
        customerQueryDslRepository.findAll(customer.customerName.eq("小王"),pageable)
    }

}
