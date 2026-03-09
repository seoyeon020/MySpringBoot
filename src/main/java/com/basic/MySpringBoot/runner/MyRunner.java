package com.basic.MySpringBoot.runner;

import com.basic.MySpringBoot.config.CustomerVO;
import com.basic.MySpringBoot.property.MyBootProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MyRunner implements ApplicationRunner {

    @Value("${myboot.name}")
    private String name;

    @Value("${myboot.age}")
    private int age;

    @Autowired
    private Environment environment;

    @Autowired
    private MyBootProperties properties;

    @Autowired
    private CustomerVO customerVO;

    //loger 객체생성
    private Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Logger 구현체 클래스명 = " + logger.getClass().getName());
        logger.info("현재 활성화된 CustomerVO = {}", customerVO);
        logger.info("MyBootProperties getName() = {}", properties.getName());
        logger.info("MyBootProperties getFullName() = {}", properties.getFullName());

        logger.info("${myboot.name} = {}", name);
        logger.info("${myboot.age} = {}", age);

        logger.debug("DEBUG 레벨");
        logger.debug("${myboot.fullName} = {}", environment.getProperty("myboot.fullName"));
        logger.debug("VM 아규먼트 foo : {}", args.containsOption("foo"));
        logger.debug("Program 아규먼트 bar : {}", args.containsOption("bar"));


        //Anonymous Inner Class
        args.getOptionNames()
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);

                    }
                });

        //Argument 목록 출력하기 (람다식)
        args.getOptionNames()
                .forEach( name -> System.out.println(name));

        //Methoer Reference (메서드 레퍼런스)
        args.getOptionNames()//Set<String>
                .forEach(System.out::println);
    }
}
