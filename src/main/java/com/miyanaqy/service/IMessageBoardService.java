package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.MessageBoardBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IMessageBoardService {

	int add(MessageBoardBean bean);

	int edit(MessageBoardBean bean);
	
	int deleteById(Long messageBoardId);

	MessageBoardBean findById(Long messageBoardId);

	Page<MessageBoardBean> findByPage(QueryBean query);

}
