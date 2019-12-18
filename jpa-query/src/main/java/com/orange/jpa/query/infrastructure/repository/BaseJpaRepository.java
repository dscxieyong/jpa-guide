package com.orange.jpa.query.infrastructure.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;


/**
 * @author dasouche
 */

public abstract class BaseJpaRepository<T, ID> extends SimpleJpaRepository<T, ID> {
    @Autowired
    protected final JPAQueryFactory jpaQueryFactory;
    @Autowired
    protected final EntityManager em;

    BaseJpaRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }
}
