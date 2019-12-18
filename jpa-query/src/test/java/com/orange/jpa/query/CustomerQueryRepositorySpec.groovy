package com.orange.jpa.query

import com.orange.jpa.query.domain.query.QueryDTO
import com.orange.jpa.query.infrastructure.repository.CustomerQueryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * @author xieyong* @date 2019/12/18
 * @Description:
 */
@SpringBootTest
class CustomerQueryRepositorySpec extends Specification{
    @Autowired
    private CustomerQueryRepository customerQueryRepository;

    /**
     * ^^ 拼装在repository层
     * !! dto projection无法嵌套
     * !! 无法利用spring repository基于方法名的便利查询
     */
    def "customRepo"(){
        given:
        def dto=new QueryDTO(customerName: '小王')
        expect:
        customerQueryRepository.getCustomer(dto,1,0).size()>0
    }

}
