package com.ohrim.spring.database.repository;

import com.ohrim.spring.database.entity.Role;
import com.ohrim.spring.database.entity.User;
import com.ohrim.spring.dto.PersonalInfo;
import com.ohrim.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
