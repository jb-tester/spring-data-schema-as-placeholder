package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 5/31/2022.</p>
 * <p>Project: spring-data-schema-as-placeholder</p>
 * *
 */
public interface BarRepository extends CrudRepository<Bar,Integer> {



    @Query(value = "select * from jbtests.bar where version > ?", nativeQuery = true)
    List<Bar> someNativeQuery(Integer version);
}
