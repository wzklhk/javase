package com.example.demo.api.mapper;

import com.example.demo.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);

    int insert(User user);

    int update(User user);

    int delete(Integer id);
}
