package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner {

    @Autowired
    private BarRepository barRepository;
    @Autowired
    private BarService barService;

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-- all: --");
        for (Bar bar : barRepository.findAll()) {
            System.out.println(bar);
        }
        System.out.println("--- test query with schema placeholder: -- ");
        System.out.println(barService.testQuery1());

        System.out.println("-- test query with schema constant: --");
        System.out.println(barService.testQuery2());

    }
}
