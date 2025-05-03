package com.example.demo.pojo;


import java.util.List;

public class Page<T> {

    private int pageNum;
    private int pageSize;
    private List<T> page;
}
