package com.miyanaqy.service.impl;

import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.MusicBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.IMusicService;

@Service
public class MusicServiceImpl extends BaseServiceImpl implements IMusicService {

	@Override
	public int add(MusicBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(MusicBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long musicId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MusicBean findById(Long musicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MusicBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

}
