package com.example.demo.webStocket;


import java.util.List;

import com.fasterxml.jackson.core.sym.Name;

public class RequestMessage {
	private String name;
	
	private String msg;
	
	private List<Integer> cc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getuser() {
		return this.getName().split(",")[1];
	}

	public List<Integer> getCc() {
		return cc;
	}

	public void setCc(List<Integer> cc) {
		this.cc = cc;
	}
	
	

}
