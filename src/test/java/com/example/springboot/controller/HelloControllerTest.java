package com.example.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author fengaihua
 * @project springboot
 * @package com.example.springboot.controller
 * @date 2020/5/15 15:37
 * @description
 */
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Test
    void say(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/say").param("name", "name").param("age", "27"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world!"));
    }

    @Test
    void wrong(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/wrong").param("userId", String.valueOf(10086)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"before\"=\"main:null\", \"after\"=\"main:10086\"}"));
    }
}