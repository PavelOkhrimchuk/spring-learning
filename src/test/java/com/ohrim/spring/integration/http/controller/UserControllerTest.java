package com.ohrim.spring.integration.http.controller;

import com.ohrim.spring.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static com.ohrim.spring.dto.UserCreateEditDto.Fields.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RequiredArgsConstructor

class UserControllerTest extends IntegrationTestBase {

    private final MockMvc mockMvc;



    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"));


    }


    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                                .param(username, "test@gmail.com")
                                .param(firstname, "Test")
                                .param(lastname, "TestTest")
                                .param(role, "ADMIN")
                                .param(companyId, "1")
                                .param(birthDate, "2000-01-01")
                )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/users/{\\d+}")
                );
    }

}