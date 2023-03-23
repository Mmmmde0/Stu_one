package com.testa.usermanager.controller;

import com.testa.usermanager.db.entity.User;
import com.testa.usermanager.service.UserService;
import com.testa.usermanager.vo.QueryParam;
import com.testa.usermanager.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    //添加用户
    @PostMapping("")
    public R insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    //删除单个用户
    @DeleteMapping("{id}")
    public R deleteUser(@PathVariable(value = "id") Integer id) {
        return userService.deleteUser(id);
    }

    //编辑用户
    @PutMapping("")
    public R updateUser(@RequestBody User user) {return userService.updateUser(user); }

    //删除多个用户
    @DeleteMapping("")
    public R deleteUsers(@RequestBody List<Integer> ids) {
        return userService.deleteUsers(ids);
    }

    // 查询用户列表
    @PostMapping("{index}/{size}")
    public R findUserList(@PathVariable(value = "index") Integer index,
                          @PathVariable(value = "size") Integer size,
                          @RequestBody(required = false) QueryParam queryParam) {
        return userService.findUserList(index, size, queryParam);
    }

    //根据用户ID查询用户信息
    @GetMapping("{id}")
    public R getUserInfoById(@PathVariable(value = "id") Integer id) {
        return userService.getUserInfoById(id);
    }
}
