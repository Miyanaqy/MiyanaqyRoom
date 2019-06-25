package com.miyanaqy.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.AlbumBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.AlbumBeanRepository;
import com.miyanaqy.service.IAlbumService;

@Service
public class AlbumServiceImpl extends BaseServiceImpl implements IAlbumService {
	
	@Autowired
	private AlbumBeanRepository albumReposiry;

	@Override
	public int add(AlbumBean bean) {
		AlbumBean result = albumReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(AlbumBean bean) {
		AlbumBean findBean = albumReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setAlbumCover(bean.getAlbumCover());
		findBean.setAlbumDescribe(bean.getAlbumDescribe());
		findBean.setAlbumTitle(bean.getAlbumTitle());
		findBean.setType(bean.getType());
		AlbumBean result = albumReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long albumId) {
		AlbumBean findBean = albumReposiry.findById(albumId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		AlbumBean result = albumReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public AlbumBean findById(Long albumId) {
		return albumReposiry.findById(albumId).orElse(null);
	}
	
	@Override
	public Page<AlbumBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<AlbumBean> queryResult = albumReposiry.findAll(page);
		return queryResult; 
	}

}
