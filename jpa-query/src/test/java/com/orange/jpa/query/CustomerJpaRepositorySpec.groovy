package com.orange.jpa.query

import com.orange.jpa.query.domain.entity.customer.Customer
import com.orange.jpa.query.infrastructure.repository.CustomerJpaRepository
import org.assertj.core.util.Lists
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
class CustomerJpaRepositorySpec extends Specification{
    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    /**
     * ^^ 只需定义接口,方便易用
     * ^^ 支持nested projection
     * ! view方法必须和entity property保持一致
     */
    def "spring-projection"() {
        expect:
        customerJpaRepository.findByCustomerName("小王").size() > 0
    }

    /**
     * ^^ 支持dynamic-sql page sort
     * ^! 原生sql
     * !! pageable的拼装会带到service层
     * !! sort column为字符串
     * !! 参数多的时候方法难看,如果要用object需要用到spel
     */
    def "spring-dynamic-page"(){
        Pageable pageable= PageRequest.of(0, 2, Sort.by("date_create"))
        expect:
        customerJpaRepository.findCustomers("小王",pageable).getTotalElements()>0
    }

    def "batch-insert"(){
        def list= Lists.newArrayList() << new Customer(customerName: '小王') << new Customer(customerName: '小李')
        expect:
        customerJpaRepository.saveAll(list).size()>0
    }
}
