package com.ohrim.spring.service.integration.service;

import com.ohrim.spring.database.pool.ConnectionPool;
import com.ohrim.spring.service.UserService;
import com.ohrim.spring.service.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor

public class UserServiceIT {

    private final UserService userService;



    private final ConnectionPool pool1;

    @Test
    void test () {
        System.out.println();

    }

    @Test
    void test2() {
        System.out.println();

    }
}
