package com.ohrim.spring.integration.database.repository;

import com.ohrim.spring.database.entity.Company;
import com.ohrim.spring.database.repository.CompanyRepository;
import com.ohrim.spring.service.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@IT
@RequiredArgsConstructor

class CompanyRepositoryTest {

    private static final Integer APPLE_ID = 4;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {

            var company = entityManager.find(Company.class, 1);
            Assertions.assertNotNull(company);
            assertThat(company.getLocales()).hasSize(2);
        });




    }


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
    void delete() {
        var maybeCompany = companyRepository.findById(APPLE_ID);
        Assertions.assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        Assertions.assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }


    @Test
    void checkFindByQueries() {
       companyRepository.findByName("Google");
       companyRepository.findByNameContainingIgnoreCase("a");
    }
}