package com.miyanaqy.service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.SystemInformationBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface ISystemInformationService {

	int add(SystemInformationBean bean);

	int edit(SystemInformationBean bean);

	SystemInformationBean findById(Long id);

	int deleteById(Long id);

	Page<SystemInformationBean> findByPage(QueryBean query);

}
