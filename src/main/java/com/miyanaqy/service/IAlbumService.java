package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.AlbumBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IAlbumService {

	int add(AlbumBean bean);

	int edit(AlbumBean bean);

	int deleteById(Long albumId);

	AlbumBean findById(Long albumId);

	Page<AlbumBean> findByPage(QueryBean query);

}
