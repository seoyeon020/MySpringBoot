package com.basic.MySpringBoot.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CustomerVO {
    private String mode;
    private double rate;
}
