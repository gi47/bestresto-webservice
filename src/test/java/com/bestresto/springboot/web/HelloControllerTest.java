package com.bestresto.springboot.web;

import com.bestresto.springboot.config.auth.SecurityConfig;
import com.bestresto.springboot.web.HelloController;
import org.junit.jupiter.api.Test;	// {1}
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)	// {2}
@WebMvcTest(controllers = HelloController.class,  excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
})	// excludeFilters: 스캔대상에서 SecurityConfig 제거
public class HelloControllerTest {

    @Autowired    // {4}
    private MockMvc mvc;	// {5}
    @WithMockUser(roles="USER")
    @Test
    public void hello_to_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @WithMockUser(roles="USER")
    @Test
    public void hello_Dto_return() throws Exception {
        String name = "San";
        int amount = 1900;

        mvc.perform(get("/hello/dto").param("name", name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
