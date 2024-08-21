package com.example.microsocialnet.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    private void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    void createUser() throws Exception {
        String request = """
                {
                    "email":"vasya.petrov@test.orb",
                    "firstName":"Vasya",
                    "lastName":"Petrov",
                    "birthdate":"01.02.2003",
                    "gender":"man",
                    "avatar":"ava_petrov_001.jpeg",
                    "info":"характер скверный, не женат",
                    "deleted":false,
                    "cityId":1L,
                    "universityId":1L
                }
                                """;

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request));

        resultActions.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$",
                        Matchers.equalTo("Пользователь Petrov добавлен в базу с id = 1")));
    }
}