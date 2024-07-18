package com.ohrim.spring.config;

import com.ohrim.spring.config.condition.JpaCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
@Conditional(JpaCondition.class)
@Configuration
@Slf4j
public class JpaConfiguration {


//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties() {
//        return  new DatabaseProperties();
//    }
    @PostConstruct
    void init() {
      log.info("Jpa configuration is enabled");
    }
}
