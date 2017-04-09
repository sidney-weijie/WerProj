package com.sidney.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sidney.domain.SysRedisOperation;
import com.sidney.domain.User;
import com.sidney.service.UserService;

@Controller
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/test.html")
	public String testPage(){
		return "Test";
	}
	

	@RequestMapping(value = "/getResponse.html",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String getData(HttpServletRequest request){
		
		
		String url = request.getRequestURI().toString();
		System.err.println("request url=" + url);
		
		SysRedisOperation operation = new SysRedisOperation();
		operation.setId(10001L);
		operation.setInputtime(new Date(System.currentTimeMillis()));
		operation.setOperation("QUERY");
		operation.setOperator("ZWJ");
		operation.setRedisKey(request.getParameter("redisKey"));
		operation.setRedisValue("ABC\tDDD\t T\n曾伟杰\t\n");
		
		JSONObject ob = new JSONObject();
		
		ob.put("resuceCode", "COM00000");
		ob.put("resuleMsg", "success");
		ob.put("resultData", operation);
		return JSON.toJSONString(ob);
	}
	
	@RequestMapping(value = "/getSysRedisOperation.html",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public  String getSysRedisOperation(HttpServletRequest request,HttpServletResponse response){
		
		String redisKey = null;
		String redisValue = null;
		response.setContentType("text/json;charset=UTF-8"); 
		try {
			redisKey = (String) request.getParameter("redisKey");
			redisValue = (String) request.getParameter("redisValue");
			System.out.println("redisKey=" + redisKey);
			System.out.println("redisValue=" + redisValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SysRedisOperation redisOperation = new SysRedisOperation();
		
		redisOperation.setId(1L);
		redisOperation.setInputtime(new Date(System.currentTimeMillis()));
		redisOperation.setOperation("QUERY");
		redisOperation.setOperator("ZWJ");
		redisOperation.setRedisKey(redisKey);
		redisOperation.setRedisValue("这是一个测试\n 测试\n测试\n");
		return JSON.toJSONString(redisOperation);
		
	}
	
	
	@RequestMapping(value = "/insertDataToRedis.html",produces={"text/html;charset=UTF-8;","application/json;"})
	@ResponseBody
	public String insertDataToRedis(HttpServletRequest request, SysRedisOperation operation){
	
		
		String redisKey = null;
		String redisValue = null;
		int ttl = -1;
		
		try {
			redisKey = (String) request.getParameter("redisKey");
			redisValue = (String) request.getParameter("redisValue");
			String ttlStr = (String)request.getParameter("ttlMinutes");
			if(StringUtils.isNotBlank(ttlStr)){
				ttl = Integer.parseInt(ttlStr);
			}
			System.out.println("redisKey=" + redisKey);
			System.out.println("redisValue=" + redisValue);
			
			System.out.println("redisTtl=" + ttl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.err.println(JSON.toJSONString(operation));
		JSONObject result = new JSONObject();
		result.put("resuleCode", "COM00000");
		result.put("resultMsg", "测试Msg");
		return JSON.toJSONString(result);
	
	}
	
}
