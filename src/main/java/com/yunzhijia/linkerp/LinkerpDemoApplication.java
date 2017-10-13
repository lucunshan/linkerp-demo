package com.yunzhijia.linkerp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkerpDemoApplication {

    public static void main(String[] args) {
        try {
            System.out.println("hello world");
            SpringApplication.run(LinkerpDemoApplication.class, args);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }
}
