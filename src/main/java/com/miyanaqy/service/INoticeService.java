package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.NoticeBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface INoticeService {

	int add(NoticeBean bean);

	int edit(NoticeBean bean);

	int deleteById(Long id);

	Page<NoticeBean> findByPage(QueryBean query);

	NoticeBean findById(Long id);

}
