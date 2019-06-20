package com.miyanaqy.service.impl;

import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.SystemInformationBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.ISystemInformationService;

@Service
public class SystemInformationServiceImpl extends BaseServiceImpl implements ISystemInformationService {

	@Override
	public int add(SystemInformationBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(SystemInformationBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SystemInformationBean findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<SystemInformationBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

}
