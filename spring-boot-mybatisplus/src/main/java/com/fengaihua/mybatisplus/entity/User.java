package com.fengaihua.mybatisplus.entity;

import lombok.Data;

/**
 * @author fengaihua
 * @project spring-boot-learn
 * @package com.fengaihua.mybatisplus.entity
 * @date 2020/5/19 16:01
 * @description
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
