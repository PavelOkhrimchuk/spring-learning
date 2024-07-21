package com.ohrim.spring.database.repository;

import com.ohrim.spring.database.entity.Role;
import com.ohrim.spring.database.entity.User;
import com.ohrim.spring.dto.PersonalInfo2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, FilterUserRepository {

    @Query("select u from User u " +
            "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "select u.* from users u where u.username = :username",
            nativeQuery = true
    )
    List<User> findAllByUsername(String username);


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u " +
            "set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);


    Optional<User> findTopByOrderByIdDesc();



   @Lock(LockModeType.PESSIMISTIC_READ)
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

    @EntityGraph(attributePaths = {"company","company.locales"})
    Page<User> findAllBy(Pageable pageable);


    // List<PersonalInfo> findAllByCompanyId(Integer companyId);

    @Query(value = "SELECT firstname, " +
            "lastname, " +
            "birth_date birthDate " +
            "FROM users " +
            "WHERE company_id = :companyId",
            nativeQuery = true)
    List<PersonalInfo2> findAllByCompanyId(Integer companyId);


    Optional <User>  findByUsername(String username);
}


