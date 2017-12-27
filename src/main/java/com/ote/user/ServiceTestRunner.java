package com.ote.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigInteger;

@SpringBootApplication
@Slf4j
public class ServiceTestRunner {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(ServiceTestRunner.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public CommandLineRunner commandLineRunner() {

        return args -> {
            EntityManager session = entityManagerFactory.createEntityManager();
            try {
                BigInteger id = (BigInteger) session.createNativeQuery("select max(id) from my_table").getSingleResult();
                log.info("##################### : " + id);
            } finally {
                if (session.isOpen()) {
                    session.close();
                }
            }
        };
    }

}
