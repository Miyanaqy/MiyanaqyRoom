package com.miyanaqy.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.NoticeBean;

public interface NoticeBeanRepository extends PagingAndSortingRepository<NoticeBean, Long>, JpaSpecificationExecutor<NoticeBean> {

}
