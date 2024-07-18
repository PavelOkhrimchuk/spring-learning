package com.ohrim.spring.database.repository;

import com.ohrim.spring.database.entity.User;
import com.ohrim.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
