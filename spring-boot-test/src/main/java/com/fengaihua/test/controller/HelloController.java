package com.fengaihua.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fengaihua
 * @package com.fengaihua.swagger.controller
 * @date 2019/12/23 17:07
 * @description
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    @GetMapping("/say")
    public String say(String name, Integer age) {
        return "hello world!";
    }

    @GetMapping("/wrong")
    public Map wrong(@RequestParam("userId") Integer userId) {
        // 设置用户信息前先查询一次ThreadLocal的用户信息
        String before = Thread.currentThread().getName() + ":" + currentUser.get();
        // 设置用户信息到ThreadLocal
        currentUser.set(userId);
        // 设置用户之后再查询一次ThreadLocal的用户信息
        String after = Thread.currentThread().getName() + ":" + currentUser.get();
        // 输出两次查询的结果
        Map result = new HashMap();
        result.put("before", before);
        result.put("after", after);

        return result;
    }
}
