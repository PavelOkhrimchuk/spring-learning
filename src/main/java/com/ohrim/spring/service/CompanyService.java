package com.ohrim.spring.service;

import com.ohrim.spring.database.repository.CompanyRepository;
import com.ohrim.spring.dto.CompanyReadDto;
import com.ohrim.spring.listener.entity.AccessType;
import com.ohrim.spring.listener.entity.EntityEvent;
import com.ohrim.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;
    private  final UserService userService;
    private final ApplicationEventPublisher eventPublisher;
    private final CompanyReadMapper companyReadMapper;




    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return companyReadMapper.map(entity);
                });
    }



    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}
