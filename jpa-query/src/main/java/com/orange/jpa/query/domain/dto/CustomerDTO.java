package com.orange.jpa.query.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xieyong
 * @date 2019/12/18
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer customerId;

    private String customerName;

    private String address;

    private String email;

    private String phone;

}
