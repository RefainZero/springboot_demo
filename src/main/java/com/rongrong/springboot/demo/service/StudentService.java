package com.rongrong.springboot.demo.service;

import com.rongrong.springboot.demo.domain.Result;
import com.rongrong.springboot.demo.domain.Student;
import com.rongrong.springboot.demo.exception.StudentException;
import com.rongrong.springboot.demo.exceptionenum.ResultEnum;
import com.rongrong.springboot.demo.responstory.StudentResponstory;
import com.rongrong.springboot.demo.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2020/1/1 22:21
 */
@Service
public class StudentService {

    @Autowired
    StudentResponstory studentResponstory;

    @Transactional
    public void insertTwoStudent() {
        Student student1 = new Student();
        student1.setName("Amily");
        student1.setAge(17);
        student1.setSex("girl");
        student1.setEmail("Amily@qq.com");
        studentResponstory.save(student1);
        Student student2 = new Student();
        student2.setName("JoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJoneJone");
        student2.setAge(19);
        student2.setSex("boy");
        student2.setEmail("Jone@qq.com");
        studentResponstory.save(student2);
    }

    /**
     * 查询学生年龄
     *
     * @param id
     * @throws Exception
     */
    public void getStudnetAge(Integer id) throws Exception {
        Student student = studentResponstory.findOne(id);
        Integer age = student.getAge();
        //小于10岁，返回“应该上小学”，大于10岁且小于16岁，返回“应该上初中了”,其他正常输出
        if (age <= 10) {
            throw new StudentException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new StudentException(ResultEnum.HIGH_SCHOOL);
        }else {
            throw new StudentException(ResultEnum.SUCCESS);
        }
    }
}
