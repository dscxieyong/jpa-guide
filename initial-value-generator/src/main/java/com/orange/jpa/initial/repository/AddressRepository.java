package com.orange.jpa.initial.repository;

import com.orange.jpa.initial.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/3/2.
 *
 * @author zlf
 * @since 1.0
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
