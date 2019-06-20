package com.miyanaqy.service.impl;

import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.NoticeBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.INoticeService;

@Service
public class NoticeServiceImpl extends BaseServiceImpl implements INoticeService {

	@Override
	public int add(NoticeBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(NoticeBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<NoticeBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeBean findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
