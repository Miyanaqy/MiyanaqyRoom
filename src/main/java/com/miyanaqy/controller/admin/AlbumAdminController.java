package com.miyanaqy.controller.admin;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.miyanaqy.bean.entity.AlbumBean;
import com.miyanaqy.bean.enums.ResultMapInfo;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.controller.BaseController;
import com.miyanaqy.service.IAlbumService;

@RestController
@RequestMapping(value = "/admin/album")
public class AlbumAdminController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(AlbumAdminController.class);
	
	@Autowired
    private IAlbumService albumService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> add(@RequestBody AlbumBean bean) {
    	Gson gson = new Gson();
    	logger.info(" /admin/album/add---:" + gson.toJson(bean));
        int result = albumService.add(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.ADDSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.ADDFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> edit(@RequestBody AlbumBean bean) {
    	Gson gson = new Gson();
    	logger.info(" /admin/album/edit---:" + gson.toJson(bean));
        int result = albumService.edit(bean); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.EDITSUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.EDITFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> delete(Long id) {
    	logger.info(" /admin/album/delete---:" + id);
        int result = albumService.deleteById(id); // 调用发送回调信息的接口
        if (result == 1) {
            return returnResultMap(ResultMapInfo.DELETESUCCESS);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.DELETEFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findById", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findById(Long id) {
    	logger.info(" /admin/album/findById---:" + id);
        AlbumBean result = albumService.findById(id); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }
    
    @RequestMapping(value = "/findByPage", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public Map<String, Object> findByPage(QueryBean query) {
    	logger.info(" /admin/album/findByPage");
        Page<AlbumBean> result = albumService.findByPage(query); // 调用发送回调信息的接口
        if (result != null) {
            return returnResultMap(ResultMapInfo.GETSUCCESS, result);// 发送成功
        } else {
            return returnResultMap(ResultMapInfo.GETFAIL); // 发送失败
        }
    }
}
