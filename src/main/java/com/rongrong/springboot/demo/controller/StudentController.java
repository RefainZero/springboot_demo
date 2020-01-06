package com.rongrong.springboot.demo.controller;

import com.rongrong.springboot.demo.domain.Student;
import com.rongrong.springboot.demo.responstory.StudentResponstory;
import com.rongrong.springboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/30 20:40
 */
@RestController
public class StudentController {

    @Autowired
    StudentResponstory studentResponstory;

    /**
     * 查询所有学生列表
     *
     * @return
     */
    @GetMapping("/students")
    public List<Student> sudentFindAll() {
        return studentResponstory.findAll();
    }

    /**
     * 新增一个学生
     *
     * @return
     */
    @PostMapping("/studentAdd")
    public Student sudentAdd(@Valid Student student, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            //输出错误信息
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        student.setName(student.getName());
        student.setAge(student.getAge());
        student.setSex(student.getSex());
        student.setEmail(student.getEmail());
        //保存和更新都用该方法
        return studentResponstory.save(student);
    }

    /**
     * 通过iD查找一个学生
     *
     * @param id
     * @return
     */
    @GetMapping("/sudentFindOne/{id}")
    public Student sudentFindOne(@PathVariable("id") Integer id) {
        return studentResponstory.findOne(id);
    }

    /**
     * 通过ID更新一个学生信息
     *
     * @param id
     * @param name
     * @param age
     * @param sex
     * @param email
     * @return
     */
    @PutMapping("/sudentUpdate/{id}")
    public Student sudentUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age,
                                @RequestParam("sex") String sex, @RequestParam("email") String email) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setEmail(email);
        //保存和更新都用该方法
        return studentResponstory.save(student);
    }

    /**
     * 通过ID删除一个学生
     *
     * @param id
     */
    @DeleteMapping("/sudentDelete/{id}")
    public void sudentDelete(@PathVariable("id") Integer id) {
        studentResponstory.delete(id);
    }

    /**
     * 通过年龄查询学生
     *
     * @param age
     * @return
     */
    @GetMapping("/sudentFindByAge/{age}")
    public List<Student> sudentFindByAge(@PathVariable("age") Integer age) {
        return studentResponstory.findByAge(age);
    }


    @Autowired
    StudentService studentService;

    /**
     * 插入两个学生信息
     */
    @PostMapping("/student/insertTwo")
    public void insertTwo() {
        studentService.insertTwoStudent();
    }
}
