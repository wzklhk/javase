package com.example.demo.api.service;

import com.example.demo.api.mapper.UserMapper;
import com.example.demo.pojo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> list() {
        return userMapper.findAll();
    }

    public User get(Integer id) {
        return userMapper.findById(id);
    }

    public int add(User user) {
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
