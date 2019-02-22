package com.example.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class test {

	@Autowired
	private UserDao articleService;
	
	//@Scheduled(cron = "0/1 * * * * ? ")
	private void test() {
		articleService.deleteByPrimaryKey(1);
		System.out.println("1-----------------------------");
	}
	
}
