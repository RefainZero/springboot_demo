package com.rongrong.springboot.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @description: 对API进行单元测试
 * @author rongrong
 * @version 1.0
 * @date 2020/1/10 21:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentApiTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    public void testStudentApiTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":25,\"name\":\"xiaoqiang\",\"age\":33,\"sex\":\"boy\",\"email\":\"xiaoqiang@gmail.com\"}]"));
    }

}
