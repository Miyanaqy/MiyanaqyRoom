package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.CommentBean;

public interface CommentBeanRepository extends PagingAndSortingRepository<CommentBean, Long>, JpaSpecificationExecutor<CommentBean> {

}
