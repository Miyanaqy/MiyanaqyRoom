package com.miyanaqy.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.miyanaqy.bean.entity.SystemInformationBean;
import com.miyanaqy.bean.enums.ResultMapInfo;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.controller.BaseController;
import com.miyanaqy.service.ISystemInformationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/admin/systemInformation")
public class SystemInformationAdminController extends BaseController {
	
    @Autowired
    private ISystemInformationService systemInformationService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> add(@RequestBody SystemInformationBean bean) {
    	Gson gson = new Gson();
    	log.info(" /admin/systemInformation/add---:" + gson.toJson(bean));
        int result = systemInformationService.add(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.ADDSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.ADDFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> edit(@RequestBody SystemInformationBean bean) {
    	Gson gson = new Gson();
    	log.info(" /admin/systemInformation/edit---:" + gson.toJson(bean));
        int result = systemInformationService.edit(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.EDITSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.EDITFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> delete(Long id) {
    	log.info(" /admin/systemInformation/delete---:" + id);
        int result = systemInformationService.deleteById(id); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.DELETESUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.DELETEFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findById", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findById(Long id) {
    	log.info(" /admin/systemInformation/findById---:" + id);
        SystemInformationBean result = systemInformationService.findById(id); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findByPage", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findByPage(QueryBean query) {
    	log.info(" /admin/systemInformation/findByPage");
        Page<SystemInformationBean> result = systemInformationService.findByPage(query); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }

}
