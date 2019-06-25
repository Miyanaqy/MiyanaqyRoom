package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.MessageBoardBean;

public interface MessageBoardBeanRepository extends PagingAndSortingRepository<MessageBoardBean, Long>, JpaSpecificationExecutor<MessageBoardBean> {

}
