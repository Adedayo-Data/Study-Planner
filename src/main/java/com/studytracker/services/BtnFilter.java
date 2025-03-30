//package com.studytracker.services;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Servlet Filter implementation class BtnFilter
// */
//@WebFilter("/createSession")
//public class BtnFilter extends HttpFilter implements Filter {
//       
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		// place your code here
//		HttpServletRequest req = (HttpServletRequest) request;
//		
//		String value = req.getParameter("action");
//		
//		if(value.equals("add")) {
//		// pass the request along the filter chain
//			chain.doFilter(request, response);
//	}
//
//}
