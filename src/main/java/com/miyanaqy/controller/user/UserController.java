package com.miyanaqy.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.miyanaqy.bean.entity.UserBean;
import com.miyanaqy.bean.enums.ResultMapInfo;
import com.miyanaqy.controller.BaseController;
import com.miyanaqy.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user/userinfo")
public class UserController extends BaseController {
	
    @Autowired
    private IUserService userService;
  
    @RequestMapping(value = "/regist", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> regist(@RequestBody UserBean bean) {
    	Gson gson = new Gson();
    	log.info(" /user/user/regist---:" + gson.toJson(bean));
        UserBean result = userService.regist(bean); // 调用发送回调信息的接口
        if (result != null) {
        	result.setPassword("******");
        	getSession().setAttribute("result", result);
            return returnResultMap(ResultMapInfo.LOGINIPSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.LOGINIPFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> edit(@RequestBody UserBean bean) {
    	Gson gson = new Gson();
    	log.info(" /user/user/edit---:" + gson.toJson(bean));
        int result = userService.edit(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.EDITSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.EDITFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findUserInfo", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findUserInfo() {
    	log.info(" /user/user/findUserInfo");
        UserBean result = (UserBean) getSession().getAttribute("login_user");; // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }
}
