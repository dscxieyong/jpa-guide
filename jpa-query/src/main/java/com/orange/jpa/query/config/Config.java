package com.orange.jpa.query.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author tuzhenxian
 * @date 19-12-12
 */
@Configuration
public class Config {

    @Bean
    public JPAQueryFactory jpaQuery(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
