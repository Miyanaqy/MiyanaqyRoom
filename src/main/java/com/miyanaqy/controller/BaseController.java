package com.miyanaqy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.miyanaqy.bean.enums.ResultMapInfo;
import com.miyanaqy.service.IBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {
	
	protected Map<String, Object> resultMap = new HashMap<String, Object>();
	
	@Autowired
	private IBaseService baseService;
	
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
		.getRequestAttributes();
		return attrs.getRequest();
	}
	
	public static HttpServletResponse getResponse() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
		.getRequestAttributes();
		return attrs.getResponse();
	}
	
	  /**
     * 获取登陆IP
     * @param request
     * @param response
     * @return 
     */
    public static String getIpAddr() {
    	HttpServletRequest request = getRequest();
    	//处理代理访问获取不到真正的ip问题的        
    	String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        	//获取代理中中的ip
            ip = request.getHeader("PRoxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        	//获取代理中中的ip

            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        	//非代理的情况获取ip
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
        	ip = "127.0.0.1";
        }
        return ip;
    }

	protected Map<String, Object> returnResultMap(ResultMapInfo info) {
		resultMap.put("code", info.getCode());
		resultMap.put("message", info.getMessage());
		if (info.getCode() == 1) resultMap.put("status", "SUCCESS");
		else resultMap.put("status", "FALT");
		resultMap.put("data", null);
		return resultMap;
	}
	
	protected Map<String, Object> returnResultMap(ResultMapInfo info, Object obj) {
		resultMap.put("code", info.getCode());
		resultMap.put("message", info.getMessage());
		if (info.getCode() == 1) resultMap.put("status", "SUCCESS");
		else resultMap.put("status", "FALT");
		resultMap.put("data", obj);
		return resultMap;
	}

}
