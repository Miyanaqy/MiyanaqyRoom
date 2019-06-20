package com.miyanaqy.service.impl;

import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.MessageBoardBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.IMessageBoardService;

@Service
public class MessageBoardServiceImpl extends BaseServiceImpl implements IMessageBoardService {

	@Override
	public int add(MessageBoardBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(MessageBoardBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long messageBoardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MessageBoardBean findById(Long messageBoardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MessageBoardBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

}
