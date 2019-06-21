package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.ArticleBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IArticleService {

	int add(ArticleBean bean);

	int edit(ArticleBean bean);

	int deleteById(Long articleId);

	ArticleBean findById(Long articleId);

	Page<ArticleBean> findByPage(QueryBean query);

}
