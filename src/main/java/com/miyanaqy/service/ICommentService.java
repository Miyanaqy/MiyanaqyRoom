package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.CommentBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface ICommentService {

	int add(CommentBean bean);

	int edit(CommentBean bean);

	int deleteById(Long commentId);

	Page<CommentBean> findByPage(QueryBean query);

	CommentBean findById(Long commentId);

}
