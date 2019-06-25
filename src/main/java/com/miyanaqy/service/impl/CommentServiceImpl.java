package com.miyanaqy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.CommentBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.CommentBeanRepository;
import com.miyanaqy.service.ICommentService;

@Service
public class CommentServiceImpl extends BaseServiceImpl implements ICommentService {

	@Autowired
	private CommentBeanRepository commentReposiry;

	@Override
	public int add(CommentBean bean) {
		CommentBean result = commentReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(CommentBean bean) {
		CommentBean findBean = commentReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setCommentContent(bean.getCommentContent());
		findBean.setType(bean.getType());
		CommentBean result = commentReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long commentId) {
		CommentBean findBean = commentReposiry.findById(commentId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		CommentBean result = commentReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public CommentBean findById(Long commentId) {
		return commentReposiry.findById(commentId).orElse(null);
	}

	@Override
	public Page<CommentBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<CommentBean> queryResult = commentReposiry.findAll(page);
		return queryResult; 
	}
}
