package com.basic.MySpringBoot.runner;

import com.basic.MySpringBoot.property.MyBootProperties;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyBootProperties getName() = " + properties.getName());

        System.out.println("${myboot.name} = " + name);
        System.out.println("${myboot.age} = " + age);

        System.out.println("${myboot.fullName} = " + environment.getProperty("myboot.fullName"));

        System.out.println("VM 아규먼트 foo :" + args.containsOption("foo"));
        System.out.println("Program 아규먼트 bar :" + args.containsOption("bar"));


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
