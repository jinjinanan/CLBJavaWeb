package com.clb;

import java.io.IOException;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.jms.Message;
import javax.jws.soap.SOAPBinding.Style;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class loginServlet implements Servlet{

	public String useStr;
	public String pwdStr;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();
		useStr = context.getInitParameter("webuser");
		pwdStr = context.getInitParameter("webpassword");
		System.out.print("login："+useStr);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("请求来了");
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		System.out.println(MessageFormat.format( "User:{0}    Password{1}", user, password));
		System.out.printf("Use:%s  password:%s" ,user, password);
		
		System.out.println("");
		String[] mutable = req.getParameterValues("interesting");
		for (String interesting : mutable) {
			System.out.println("兴趣："+interesting);
		}
		
		Enumeration<String> name = req.getParameterNames();
		while (name.hasMoreElements()) {
			String string = (String) name.nextElement();
			System.out.println("参数名："+string);
		}
		
		Map<String, String[]> map = req.getParameterMap();
		for (Map.Entry<String, String[]> string : map.entrySet()) {
			System.out.println("***"+string.getKey()+":"+Arrays.asList(string.getValue() ));
		}
		
	System.out.println("__________________"+useStr + pwdStr);
		if (user.equals(useStr)  && pwdStr.equals(password) ) {
//			res.setContentType("application/msword");
			PrintWriter out = res.getWriter();
			out.println("hello");
		}else {
			PrintWriter out = res.getWriter();
			out.println("sorry user or password is error");
		}
		
	}
	
}
