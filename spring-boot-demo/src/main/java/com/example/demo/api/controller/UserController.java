package com.example.demo.api.controller;


import com.example.demo.api.service.UserService;
import com.example.demo.pojo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userService.get(id);
    }

    @PostMapping
    public int add(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
