package com.ohrim.spring.integration.database.repository;

import com.ohrim.spring.database.entity.Company;
import com.ohrim.spring.database.repository.CompanyRepository;
import com.ohrim.spring.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import java.util.Map;


@RequiredArgsConstructor

class CompanyRepositoryTest extends IntegrationTestBase {

    private static final Integer APPLE_ID = 4;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;



    @Test
    void save(){
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ru","Apple описание",
                        "en", "Apple description"
                )).build();

        entityManager.persist(company);
        Assertions.assertNotNull(company.getId());



    }


    @Test
    @Disabled
    void delete() {
        var maybeCompany = companyRepository.findById(APPLE_ID);
        Assertions.assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        Assertions.assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }


    @Test
    void checkFindByQueries() {
       companyRepository.findByName("google");
       companyRepository.findByNameContainingIgnoreCase("a");
    }



}