package com.clb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class helloServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
		
		String user = arg0.getInitParameter("user");
		System.out.println("user:" + user);
		System.out.println("---------------------------------------------");
		
		Enumeration<String> names = arg0.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println("name:" + name);
			
			String value = arg0.getInitParameter(name);
			System.out.println("value:" + value);
			
			System.out.println("---------------------------------------------");
		}
		
		String servletNameString = arg0.getServletName();
		System.out.println(servletNameString);
		
		
		System.out.println("---------------------------------------------");
		//获得全局的参数
		ServletContext servletContext = arg0.getServletContext();
		String driver = servletContext.getInitParameter("driver");
		System.out.println(driver);
		
		//获得当前web应用的某个文件的物理路径
		String realPath = servletContext.getRealPath("/note");
		System.out.println(realPath);
		//获取当前web应用的名称
		String contextPathString = servletContext.getContextPath();
		System.out.println("web应用的名字："+contextPathString);
		//获取web应用的某个输入流
		try {
			InputStream inputstr = servletContext.getResourceAsStream("/WEB-INF/classes/testFile");
			System.out.println("获得文件的输入流:"+inputstr);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service");
		
	}

	
	public helloServlet(){
		System.out.println("helloServlet's constructor");
		
	}
}
