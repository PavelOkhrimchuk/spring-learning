package com.ohrim.spring.database.repository;

import com.ohrim.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

@Query("select c from Company c join fetch c.locales cl where c.name = :name")
Optional<Company> findByName(String name);

List<Company> findByNameContainingIgnoreCase(String fragment);


}
