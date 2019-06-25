package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.SystemInformationBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.SystemInformationBeanRepository;
import com.miyanaqy.service.ISystemInformationService;

@Service
public class SystemInformationServiceImpl extends BaseServiceImpl implements ISystemInformationService {

	@Autowired
	private SystemInformationBeanRepository systemInformationReposiry;

	@Override
	public int add(SystemInformationBean bean) {
		SystemInformationBean result = systemInformationReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(SystemInformationBean bean) {
		SystemInformationBean findBean = systemInformationReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setSiContent(bean.getSiContent());
		findBean.setSendIds(bean.getSendIds());
		findBean.setSiDescribe(bean.getSiDescribe());
		findBean.setSiTitle(bean.getSiTitle());
		findBean.setType(bean.getType());
		SystemInformationBean result = systemInformationReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long systemInformationId) {
		SystemInformationBean findBean = systemInformationReposiry.findById(systemInformationId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		SystemInformationBean result = systemInformationReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public SystemInformationBean findById(Long systemInformationId) {
		return systemInformationReposiry.findById(systemInformationId).orElse(null);
	}
	
	@Override
	public Page<SystemInformationBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<SystemInformationBean> queryResult = systemInformationReposiry.findAll(page);
		return queryResult; 
	}
}
