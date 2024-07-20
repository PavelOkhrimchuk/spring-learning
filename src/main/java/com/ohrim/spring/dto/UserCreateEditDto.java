package com.ohrim.spring.dto;

import com.ohrim.spring.database.entity.Role;
import com.ohrim.spring.validation.UserInfo;
import com.ohrim.spring.validation.group.CreateAction;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = CreateAction.class)
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @NotNull
            @Size(min = 3, max = 64)
    String firstname;


    String lastname;


    Role role;

    @NotNull
    Integer companyId;

    MultipartFile image;

}
