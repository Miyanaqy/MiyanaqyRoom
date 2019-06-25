package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.NoticeBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.NoticeBeanRepository;
import com.miyanaqy.service.INoticeService;

@Service
public class NoticeServiceImpl extends BaseServiceImpl implements INoticeService {

	@Autowired
	private NoticeBeanRepository noticeReposiry;

	@Override
	public int add(NoticeBean bean) {
		NoticeBean result = noticeReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(NoticeBean bean) {
		NoticeBean findBean = noticeReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setNoticeDescribe(bean.getNoticeDescribe());
		findBean.setNoticeTitle(bean.getNoticeTitle());
		findBean.setNoticeContent(bean.getNoticeContent());
		findBean.setType(bean.getType());
		NoticeBean result = noticeReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long noticeId) {
		NoticeBean findBean = noticeReposiry.findById(noticeId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		NoticeBean result = noticeReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public NoticeBean findById(Long noticeId) {
		return noticeReposiry.findById(noticeId).orElse(null);
	}
	
	@Override
	public Page<NoticeBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<NoticeBean> queryResult = noticeReposiry.findAll(page);
		return queryResult; 
	}
}
