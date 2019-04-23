package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskA {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void run(){
        System.out.println("TaskA is running"+sdf.format(new Date()));
    }

}
