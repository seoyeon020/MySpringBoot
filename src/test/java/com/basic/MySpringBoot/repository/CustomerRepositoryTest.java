package com.basic.MySpringBoot.repository;

import com.basic.MySpringBoot.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    //1. Customer 등록
    @Test
    @Rollback(value = false) //Rollback 처리를 하지 마세요
    @Disabled
    void testCreate() {
        //Given(준비단계)
        Customer customer = new Customer();
        customer.setCustomerId("A004");
        customer.setCustomerName("스프링부트4");
        //When(실행단계)
        Customer addCustomer = customerRepository.save(customer);
        //Then(검증단계)
        assertThat(addCustomer).isNotNull();
        assertThat(addCustomer.getCustomerName()).isEqualTo("스프링부트4");
    }

    //2. Customer 조회
    @Test
    void testFindBy() {
        Optional<Customer> optionalCustomer = customerRepository.findById(1L);
        if(optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            assertThat(customer.getId()).isEqualTo(1L);

        } else {
            System.out.println("Customer Not Found");
        }

        //ifPresent(Consumer)
        //Consumer의 추상메서드는 void Accept(T t)
        optionalCustomer.ifPresent(customer -> System.out.println(customer.getCustomerName()));



    }

}