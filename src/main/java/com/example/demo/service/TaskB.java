package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TaskB {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void run(){
        System.out.println("TaskB is running"+sdf.format(new Date()));
    }

}
