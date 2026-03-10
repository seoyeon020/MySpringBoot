package com.basic.MySpringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "customers")
@Getter @Setter
@DynamicUpdate
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //ID는 primary key 역할

    @Column(unique = true, nullable = false) //중복 허용 안함
    private String customerId;

    @Column(nullable = false)
    private String customerName;




}
