package com.rongrong.springboot.demo.responstory;

import com.rongrong.springboot.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/30 22:20
 */
public interface StudentResponstory extends JpaRepository<Student,Integer> {
    List<Student> findByAge(Integer age);
}
