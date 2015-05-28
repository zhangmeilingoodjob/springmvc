package com.zml.ssh.common;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该方法主要是生成验证码?,并返4位回验证码?
 * 
 * @author Jason *
 */
public class RandomCodeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RandomCode ic = new RandomCode();
		String imageCode = ic.image(request, response);
		request.getSession().removeAttribute("Rand");
		request.getSession().setMaxInactiveInterval(-1);
		// 转为小写，从页面输入也转为小写，以达到不分大小写作用
		request.getSession().setAttribute("Rand", imageCode);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
