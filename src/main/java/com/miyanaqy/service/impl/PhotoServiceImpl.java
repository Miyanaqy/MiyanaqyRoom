package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.PhotoBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.PhotoBeanRepository;
import com.miyanaqy.service.IPhotoService;

@Service
public class PhotoServiceImpl extends BaseServiceImpl implements IPhotoService {

	@Autowired
	private PhotoBeanRepository photoReposiry;

	@Override
	public int add(PhotoBean bean) {
		PhotoBean result = photoReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(PhotoBean bean) {
		PhotoBean findBean = photoReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setPhotoDescribe(bean.getPhotoDescribe());
		findBean.setPhotoTitle(bean.getPhotoTitle());
		findBean.setPhotoUrl(bean.getPhotoUrl());
		findBean.setType(bean.getType());
		PhotoBean result = photoReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long photoId) {
		PhotoBean findBean = photoReposiry.findById(photoId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		PhotoBean result = photoReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public PhotoBean findById(Long photoId) {
		return photoReposiry.findById(photoId).orElse(null);
	}
	
	@Override
	public Page<PhotoBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<PhotoBean> queryResult = photoReposiry.findAll(page);
		return queryResult; 
	}
}
