package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.NoticeBean;

public interface NoticeBeanRepository extends PagingAndSortingRepository<NoticeBean, Long>, JpaSpecificationExecutor<NoticeBean> {

}
