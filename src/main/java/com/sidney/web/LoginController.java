package com.sidney.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sidney.domain.User;
import com.sidney.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index.html")
	public String loginPage(){
		return "login";
	}

	
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand cmd){
		boolean isValidUser = userService.hasMatchUser(cmd.getUserName(), cmd.getPassword());
		if(!isValidUser){
			return new ModelAndView("login","error","用户名或密码错误");
		}else{
			User user = userService.findUserByUserName(cmd.getUserName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
		
	}
	
	@RequestMapping(value = "/getRedisScript.html")
	public ModelAndView getRedisScript(HttpServletRequest request){
	
		String script = (String) request.getAttribute("script");
		
		JSONObject jobj = new JSONObject();
		
		return null;
		
		
	}
	
}
