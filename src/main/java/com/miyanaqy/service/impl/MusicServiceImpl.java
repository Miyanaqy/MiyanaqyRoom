package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.MusicBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.MusicBeanRepository;
import com.miyanaqy.service.IMusicService;

@Service
public class MusicServiceImpl extends BaseServiceImpl implements IMusicService {

	@Autowired
	private MusicBeanRepository musicReposiry;

	@Override
	public int add(MusicBean bean) {
		MusicBean result = musicReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(MusicBean bean) {
		MusicBean findBean = musicReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setMusicCover(bean.getMusicCover());
		findBean.setMusicDescribe(bean.getMusicDescribe());
		findBean.setMusicTitle(bean.getMusicTitle());
		findBean.setMusicUrl(bean.getMusicUrl());
		findBean.setType(bean.getType());
		MusicBean result = musicReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long musicId) {
		MusicBean findBean = musicReposiry.findById(musicId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		MusicBean result = musicReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public MusicBean findById(Long musicId) {
		return musicReposiry.findById(musicId).orElse(null);
	}
	
	@Override
	public Page<MusicBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<MusicBean> queryResult = musicReposiry.findAll(page);
		return queryResult; 
	}

}
