package com.basic.MySpringBoot.repository;

import com.basic.MySpringBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //finder(query) method
    //1. CustomerId(고객번호, Unique)로 조회하는 finder 메서드
    Optional<Customer> findByCustomerId(String customerId);

    //2. customerName(고객명, 중복허용)으로 조회하는 finder 메서드
    List<Customer> findByCustomerNameContaining(String customerName);

}
