package com.orange.jpa.query.domain.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 1278754256L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final com.orange.jpa.query.domain.entity.order.customer.QCustomer customer;

    public final NumberPath<Integer> customerId = createNumber("customerId", Integer.class);

    public final DateTimePath<java.util.Date> dateCreate = createDateTime("dateCreate", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateDelete = createDateTime("dateDelete", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateUpdate = createDateTime("dateUpdate", java.util.Date.class);

    public final StringPath orderContent = createString("orderContent");

    public final StringPath orderDesc = createString("orderDesc");

    public final NumberPath<Integer> orderId = createNumber("orderId", Integer.class);

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new com.orange.jpa.query.domain.entity.order.customer.QCustomer(forProperty("customer")) : null;
    }

}

