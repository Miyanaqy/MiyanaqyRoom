package com.miyanaqy.service.impl;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.ArticleBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.IArticleService;

public class ArticleServiceImpl extends BaseServiceImpl implements IArticleService {

	@Override
	public int add(ArticleBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(ArticleBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long articleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArticleBean findById(Long articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ArticleBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

}
