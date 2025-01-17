package com.ohrim.spring.integration.service;

import com.ohrim.spring.config.DatabaseProperties;
import com.ohrim.spring.dto.CompanyReadDto;
import com.ohrim.spring.integration.annotation.IT;
import com.ohrim.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestConstructor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@IT
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    @Autowired
    private final CompanyService companyService;

    @Autowired
    private final DatabaseProperties databaseProperties;


    @Test
    void findById() {


        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID, null);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));



    }
}
