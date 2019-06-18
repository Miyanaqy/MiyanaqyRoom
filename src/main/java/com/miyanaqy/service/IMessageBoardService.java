package com.miyanaqy.service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.MessageBoardBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IMessageBoardService {

	int add(MessageBoardBean bean);

	int edit(MessageBoardBean bean);
	
	int deleteById(Long messageBoardId);

	MessageBoardBean findById(Long messageBoardId);

	Page<MessageBoardBean> findByPage(QueryBean query);

}
