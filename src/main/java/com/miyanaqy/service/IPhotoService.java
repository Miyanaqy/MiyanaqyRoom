package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.PhotoBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IPhotoService {

	int add(PhotoBean bean);

	int edit(PhotoBean bean);

	int deleteById(Long photoId);

	PhotoBean findById(Long photoId);

	Page<PhotoBean> findByPage(QueryBean query);

}
