package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.ArticleBean;

public interface ArticleBeanRepository extends PagingAndSortingRepository<ArticleBean, Long>, JpaSpecificationExecutor<ArticleBean>{

}
