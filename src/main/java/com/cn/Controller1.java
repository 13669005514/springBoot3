package com.cn;


import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class Controller1 {

    @Autowired
    private UserService userService;

    //注入redis模板ddddd
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    @RequestMapping("all")
    @ResponseBody
    public List<User> getAll() {
        List<User> users = (List<User>) redisTemplate.opsForValue().get("ALLUser");

        if (null == users) {
            System.out.println("====还是进来了");
            users = userService.selectAll();
            redisTemplate.opsForValue().set("ALLUser",users);
        }
        return users;
    }

    /*
    * resetfull 风格使用
    * */

    @RequestMapping("/user/{id}/{name}")
    @ResponseBody
    public User getUser(@PathVariable("id") Integer id,@PathVariable("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser2(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        System.out.println(id);
        return user;
    }




}
