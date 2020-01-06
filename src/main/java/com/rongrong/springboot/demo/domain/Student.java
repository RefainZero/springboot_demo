package com.rongrong.springboot.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/30 21:24
 */
@Entity
@Data
public class Student {

    //主键ID
    @Id
    //自增型
    @GeneratedValue
    private Integer id;
    private String name;
    @Min(value = 18,message = "未满18岁，还没身份证，不能到网吧上网！")
    private Integer age;
    private String sex;
    private String email;
    public Student() {
    }
}
