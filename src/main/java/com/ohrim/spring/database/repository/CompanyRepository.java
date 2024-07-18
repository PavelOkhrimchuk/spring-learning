package com.ohrim.spring.database.repository;

import com.ohrim.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {


Optional<Company> findByName(String name);

List<Company> findByNameContainingIgnoreCase(String fragment);


}
