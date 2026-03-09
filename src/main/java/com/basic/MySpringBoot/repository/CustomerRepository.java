package com.basic.MySpringBoot.repository;

import com.basic.MySpringBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
