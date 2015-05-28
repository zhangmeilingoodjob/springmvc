package com.zml.ssh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zml.ssh.domain.User;
import com.zml.ssh.service.login.LoginService;


@Controller
public class LoginAction {
	@Resource
	private LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private String imgCode;
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@RequestMapping("/login")
	public String login(HttpSession session){
		if(imgCode==null){
			return "login";
		}
		String imageCode=(String)session.getAttribute("Rand");
		if(imageCode.equals(imgCode)){
			if(loginService.login(user)!=null){
				msg="登录成功！";
				return "index";
			}else{
				msg="用户名或密码错误！";
				return "login";
			}
		}else{
			msg="请输入正确的验证码！";
			return "login";
		}
	}
	@RequestMapping(value="/regist",method={RequestMethod.POST})
	public String regist(@ModelAttribute("user") User user){
		loginService.saveOrUpdate(user);
		msg="注册成功！";
		return "login";
	}
}
