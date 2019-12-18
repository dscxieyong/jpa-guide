package com.orange.jpa.query.domain.entity.customer;
import com.orange.jpa.query.domain.entity.order.Order;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author xieyong
 */

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String customerName;

    private String address;

    private String email;

    private String phone;

    @Column(name = "date_create")
    @CreatedDate
    private Date dateCreate;

    @Column(name = "date_update")
    @LastModifiedDate
    private Date dateUpdate;

    private Date dateDelete;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> orders;
}