package com.ohrim.spring.config;

import com.ohrim.spring.database.pool.ConnectionPool;
import com.ohrim.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
@Import(WebConfiguration.class)
@Configuration




public class ApplicationConfiguration {

    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username,20);
    }

    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool",25);
    }







}
