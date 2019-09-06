package com.miyanaqy.controller.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.miyanaqy.bean.entity.CommentBean;
import com.miyanaqy.bean.enums.ResultMapInfo;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.controller.BaseController;
import com.miyanaqy.service.ICommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user/comment")
public class CommentController extends BaseController {
	
	@Autowired
    private ICommentService commentService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> add(@RequestBody CommentBean bean) {
    	Gson gson = new Gson();
    	log.info(" /user/comment/add---:" + gson.toJson(bean));
        int result = commentService.add(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.ADDSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.ADDFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> edit(@RequestBody CommentBean bean) {
    	Gson gson = new Gson();
    	log.info(" /user/comment/edit---:" + gson.toJson(bean));
        int result = commentService.edit(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.EDITSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.EDITFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> delete(Long id) {
    	log.info(" /user/comment/delete---:" + id);
        int result = commentService.deleteById(id); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.DELETESUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.DELETEFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findById", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findById(Long id) {
    	log.info(" /user/comment/findById---:" + id);
        CommentBean result = commentService.findById(id); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findByPage", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findByPage(QueryBean query) {
    	log.info(" /user/comment/findByPage");
        Page<CommentBean> result = commentService.findByPage(query); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }

}
