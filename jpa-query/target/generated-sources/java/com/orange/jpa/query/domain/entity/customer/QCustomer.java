package com.orange.jpa.query.domain.entity.customer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = -227444543L;

    public static final QCustomer customer = new QCustomer("customer");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> customerId = createNumber("customerId", Integer.class);

    public final StringPath customerName = createString("customerName");

    public final DateTimePath<java.util.Date> dateCreate = createDateTime("dateCreate", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateDelete = createDateTime("dateDelete", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateUpdate = createDateTime("dateUpdate", java.util.Date.class);

    public final StringPath email = createString("email");

    public final SetPath<com.orange.jpa.query.domain.entity.order.Order, com.orange.jpa.query.domain.entity.order.QOrder> orders = this.<com.orange.jpa.query.domain.entity.order.Order, com.orange.jpa.query.domain.entity.order.QOrder>createSet("orders", com.orange.jpa.query.domain.entity.order.Order.class, com.orange.jpa.query.domain.entity.order.QOrder.class, PathInits.DIRECT2);

    public final StringPath phone = createString("phone");

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

