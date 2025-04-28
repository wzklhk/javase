package com.example.demo.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommonBean {
    private Long id;

    private Date createTime;

    private Date updateTime;
}
