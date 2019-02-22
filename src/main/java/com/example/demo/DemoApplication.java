package com.example.demo;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.util.HttpRestUtil;


@SpringBootApplication( exclude = SecurityAutoConfiguration.class)
@EnableScheduling
@MapperScan("com.example.demo.dao")
@Controller
public class DemoApplication {
	
	

	//@Autowired
	//private StringRedisTemplate stringRedisTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
	}
	
	@Primary
	@Bean
	public TaskExecutor primaryTaskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    return executor;
	}
	
	@RequestMapping("/cha")
	@ResponseBody
	private String  cha(String date,String fromStation,String toStation) throws IOException{
        //api url地址
		String url = "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date="+date+"&leftTicketDTO.from_station="+fromStation+"&leftTicketDTO.to_station="+toStation+"&purpose_codes=ADULT";
        //post请求
        HttpMethod method =HttpMethod.GET;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        //发送http请求并返回结果
        String result = HttpRestUtil.HttpRestClient(url,method,params);
        return result;
	}
	
	
	
  
    @RequestMapping("/index")
	private String  index() {
     
        return "12306";
	}
    
  
	
   
}
