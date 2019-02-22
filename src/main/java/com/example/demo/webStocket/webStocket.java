package com.example.demo.webStocket;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

/**
 * 为 webStocket 实例
 * 其中redis 可以使用消息队列替代 
 * 可以在登录时访问消息队列获取对话信息 
 * @author zeyin.zhang
 *
 */
@Controller
public class webStocket {
	
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
	
	 private static final Logger logger = LoggerFactory.getLogger(webStocket.class);

	    // 收到消息记数
	    private AtomicInteger count = new AtomicInteger(0);

	    /**
	     * @MessageMapping 指定要接收消息的地址，类似@RequestMapping。除了注解到方法上，也可以注解到类上
	     * @SendTo默认 消息将被发送到与传入消息相同的目的地
	     * 消息的返回值是通过{@link org.springframework.messaging.converter.MessageConverter}进行转换
	     * @param requestMessage
	     * @return
	     */
	    @MessageMapping("/receive/{c}")
	    @SendTo("/topic/getResponse/{c}")
	    public ResponseMessage broadcast(RequestMessage requestMessage,@PathVariable("c") String c){
	    	
	    	logger.info("receive message = {}" , JSONObject.toJSONString(requestMessage));
	    	ResponseMessage responseMessage = new ResponseMessage();
	    	
	    	String status = findRdeis(requestMessage.getuser());
	        if(status==null||"false".equals(status)) {
	        	setRdeis(requestMessage.getName(),findRdeis(requestMessage.getName())==null?requestMessage.getMsg():findRdeis(requestMessage.getName())+"<br/>"+requestMessage.getMsg());
	        }else {
	        	if(findRdeis(requestMessage.getName())!=null) {
	        		requestMessage.setMsg(requestMessage.getMsg()+"<br/>"+findRdeis(requestMessage.getName()));
	        		delRdeis(requestMessage.getName());
	        	}
	        }
	        
	        responseMessage.setResponseMessage(requestMessage.getMsg());
	        return responseMessage;
	    }

		private String findRdeis(String key) {
		//	ValueOperations<String, String> operations = this.stringRedisTemplate.opsForValue();
	    	return null;
		}
	
		private void setRdeis(String key,String value) {
		//	ValueOperations<String, String> operations = this.stringRedisTemplate.opsForValue();
		//	operations.set(key, value);
		}

		private void delRdeis(String key) {
		//	stringRedisTemplate.delete(key);
		}
		
	    @RequestMapping(value="/webStocket/index")
	    public String broadcastIndex(HttpServletRequest req){
	        System.out.println(req.getRemoteHost());
	        return "/ind";
	    }
	
	    
	
	  
	    @RequestMapping(value="/login")
	    public String login(String user){
	    	setRdeis(user,"true");
	        return "/ind";
	    }
	  
	    
	    
}
