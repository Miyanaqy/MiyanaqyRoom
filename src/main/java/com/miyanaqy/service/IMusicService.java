package com.miyanaqy.service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.MusicBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IMusicService {

	int add(MusicBean bean);

	int edit(MusicBean bean);

	int deleteById(Long musicId);

	MusicBean findById(Long musicId);

	Page<MusicBean> findByPage(QueryBean query);

}
