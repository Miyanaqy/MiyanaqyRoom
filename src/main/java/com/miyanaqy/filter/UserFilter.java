package com.miyanaqy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.miyanaqy.bean.bo.ResultContent;
import com.miyanaqy.bean.entity.UserBean;
import com.miyanaqy.bean.enums.ResultMapInfo;

@WebFilter(filterName = "sessionFilter",urlPatterns = {"/user/*"})
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        System.out.println("***********UserFilter被使用***********");
//        UserBean user = (UserBean) request.getSession().getAttribute("loginUser");
//        if (user == null) {
//        	Gson gson = new Gson();
//        	System.out.println(gson.toJson(new ResultContent(ResultMapInfo.RELOGIN)));
//        	response.getWriter().write(gson.toJson(new ResultContent(ResultMapInfo.RELOGIN)));
//        	return;
//        }
        filterChain.doFilter(request, response);
    }
    @Override
    public void destroy() {

    }
}
