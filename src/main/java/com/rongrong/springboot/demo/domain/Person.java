package com.rongrong.springboot.demo.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author rongrong
 * @version 1.0
 * @description:
 * @date 2019/12/28 13:56
 */
@Data
//注入配置
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private Integer age;
    private String gName;
}
