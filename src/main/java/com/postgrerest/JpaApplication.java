package com.postgrerest;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.websocket.Session;


@SpringBootApplication
@EnableJpaRepositories
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class,args);
    }
}
