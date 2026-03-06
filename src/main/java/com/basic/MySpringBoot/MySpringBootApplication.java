package com.basic.MySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBootApplication {

	public static void main(String[] args) {

        // SpringApplication.run(MySpringBootApplication.class, args);
        SpringApplication application = new SpringApplication(MySpringBootApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);

	}

    @Bean
    public String Hello() {
        System.out.println("====Spring Bean 입니다. ====");
        return "Hello Bean";
    }
}
