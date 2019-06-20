package com.miyanaqy.service.impl;

import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.PhotoBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.IPhotoService;

@Service
public class PhotoServiceImpl extends BaseServiceImpl implements IPhotoService {

	@Override
	public int add(PhotoBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(PhotoBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long photoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PhotoBean findById(Long photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PhotoBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

}
