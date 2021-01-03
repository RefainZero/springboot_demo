package com.rongrong.springboot.demo.controller;

import com.rongrong.springboot.demo.domain.Student;
import com.rongrong.springboot.demo.responstory.StudentResponstory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 对service进行单元测试
 * @author rongrong
 * @version 1.0
 * @date 2020/1/10 20:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    StudentResponstory studentResponstory;

    @Test
    public void sudentFindOne() {
        Student student = studentResponstory.findOne(16);
        Assert.assertEquals(new Integer(10), student.getAge());
    }
}
