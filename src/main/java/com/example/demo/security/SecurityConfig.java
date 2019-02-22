//package com.example.demo.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//
//
////@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	
//	 @Autowired
//	    private UserDeailServiceImpl userDeailServiceImpl;
//	 
//	  private String[] swaggerUrls = {"/swagger/index.html",
//				"/swagger/**",
//				"/images/**",
//				"/webjars/**",
//				"/v2/api-docs",
//				"/configuration/ui",
//				"/configuration/security",
//				"/swagger-resources/configuration/ui"};
//	 
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//          // TODO Auto-generated method stub
//          //super.configure(http);
//         
//		
//		 http.authorizeRequests() // 请求权限设置
//         .antMatchers(swaggerUrls).permitAll() .anyRequest().authenticated();
//		
//		// http.csrf().disable();
//    }
//
//	
//	 
//}
