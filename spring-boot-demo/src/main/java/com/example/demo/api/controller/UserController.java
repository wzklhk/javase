package com.example.demo.api.controller;


import com.example.demo.api.service.UserService;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping
    public Result list() {
        return Result.success(userService.list());
    }*/

    @GetMapping
    public Result<User> get(@RequestParam Integer id) {
        return Result.success(userService.get(id));
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        return Result.success(userService.add(user));
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        return Result.success(userService.update(user));
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return Result.success(userService.delete(id));
    }
}
