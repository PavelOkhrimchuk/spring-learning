package com.ohrim.spring.validation.impl;

import com.ohrim.spring.database.repository.CompanyRepository;
import com.ohrim.spring.dto.UserCreateEditDto;
import com.ohrim.spring.validation.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.springframework.util.StringUtils.hasText;
@Component
@RequiredArgsConstructor
public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreateEditDto> {


    private final CompanyRepository companyRepository;
    @Override
    public boolean isValid(UserCreateEditDto value, ConstraintValidatorContext constraintValidatorContext) {
        return hasText(value.getFirstname()) || hasText(value.getLastname());

    }
}
