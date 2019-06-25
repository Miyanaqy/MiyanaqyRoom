package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.MessageBoardBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.MessageBoardBeanRepository;
import com.miyanaqy.service.IMessageBoardService;

@Service
public class MessageBoardServiceImpl extends BaseServiceImpl implements IMessageBoardService {

	@Autowired
	private MessageBoardBeanRepository messageBoardReposiry;

	@Override
	public int add(MessageBoardBean bean) {
		MessageBoardBean result = messageBoardReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(MessageBoardBean bean) {
		MessageBoardBean findBean = messageBoardReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setMbContent(bean.getMbContent());
		findBean.setType(bean.getType());
		MessageBoardBean result = messageBoardReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long messageBoardId) {
		MessageBoardBean findBean = messageBoardReposiry.findById(messageBoardId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		MessageBoardBean result = messageBoardReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public MessageBoardBean findById(Long messageBoardId) {
		return messageBoardReposiry.findById(messageBoardId).orElse(null);
	}
	
	@Override
	public Page<MessageBoardBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<MessageBoardBean> queryResult = messageBoardReposiry.findAll(page);
		return queryResult; 
	}

}
