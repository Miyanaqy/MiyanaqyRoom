package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.ArticleBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.ArticleBeanRepository;
import com.miyanaqy.service.IArticleService;

@Service
public class ArticleServiceImpl extends BaseServiceImpl implements IArticleService {

	@Autowired
	private ArticleBeanRepository articleReposiry;

	@Override
	public int add(ArticleBean bean) {
		ArticleBean result = articleReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(ArticleBean bean) {
		ArticleBean findBean = articleReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setArticleContent(bean.getArticleContent());
		findBean.setArticleCover(bean.getArticleCover());
		findBean.setArticleDescribe(bean.getArticleDescribe());
		findBean.setArticleTitle(bean.getArticleTitle());
		findBean.setAuthor(bean.getAuthor());
		findBean.setType(bean.getType());
		ArticleBean result = articleReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long albumId) {
		ArticleBean findBean = articleReposiry.findById(albumId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		ArticleBean result = articleReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public ArticleBean findById(Long albumId) {
		return articleReposiry.findById(albumId).orElse(null);
	}

	@Override
	public Page<ArticleBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<ArticleBean> queryResult = articleReposiry.findAll(page);
		return queryResult; 
	}
}
