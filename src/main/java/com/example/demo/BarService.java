package com.example.demo;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

/**
 * *
 * <p>Created by irina on 5/31/2022.</p>
 * <p>Project: spring-data-schema-as-placeholder</p>
 * *
 */
@Service
public class BarService {

    @Autowired
    EntityManager entityManager;

    @Value("${dataSource.appAttrsSchema}")
    String schema;

    public String DEFAULT_SCHEMA = "jbtests";

    public Bar testQuery1() {

        return (Bar) entityManager
                .createNativeQuery("select * from "+schema+".bar  where version = 1", Bar.class)
                .setMaxResults(1).getSingleResult();


    }
    public Bar testQuery2() {

        return (Bar) entityManager
                .createNativeQuery("select * from "+DEFAULT_SCHEMA+".bar  where version = 1", Bar.class)
                .setMaxResults(1).getSingleResult();


    }
}
