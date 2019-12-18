package com.orange.jpa.query.domain.entity.order;

import com.orange.jpa.query.domain.entity.customer.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xieyong
 * @date 2019/12/3
 * @Description:
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
@EqualsAndHashCode(of = {"orderId"})
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String orderDesc;

    private String orderContent;

    @Column(name = "date_create")
    @CreatedDate
    private Date dateCreate;

    @Column(name = "date_update")
    @LastModifiedDate
    private Date dateUpdate;

    private Date dateDelete;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
