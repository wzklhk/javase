package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<DO, ID>
        extends JpaRepository<DO, ID>, JpaSpecificationExecutor<DO> {
}
