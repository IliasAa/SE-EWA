package com.example.ewaserver.repositories;
//Damiën

import com.example.ewaserver.models.Playerposition;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import javax.swing.text.html.parser.Entity;


@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Repository.class, Entity.class}))


public class LudoRepositoryTest {

    @Autowired
    EntityRepository<Playerposition> repository;

}
