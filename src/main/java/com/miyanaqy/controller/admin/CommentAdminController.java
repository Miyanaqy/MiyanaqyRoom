package com.miyanaqy.controller.admin;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.miyanaqy.bean.entity.CommentBean;
import com.miyanaqy.bean.enums.ResultMapInfo;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.controller.BaseController;
import com.miyanaqy.service.ICommentService;

@RestController
@RequestMapping(value = "/admin/comment")
public class CommentAdminController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(CommentAdminController.class);
	
	@Autowired
    private ICommentService commentService;

    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> delete(Long id) {
    	logger.info(" /admin/comment/delete---:" + id);
        int result = commentService.deleteById(id); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.DELETESUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.DELETEFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findById", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findById(Long id) {
    	logger.info(" /admin/comment/findById---:" + id);
        CommentBean result = commentService.findById(id); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.DELETESUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.DELETEFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findByPage", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findByPage(QueryBean query) {
    	logger.info(" /admin/comment/findByPage");
        Page<CommentBean> result = commentService.findByPage(query); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.DELETESUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.DELETEFAIL); // 发送失败
        }
    }

}
