package com.example.demo.api.repository;

import com.example.demo.pojo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    User findByEmail(String email);
}
