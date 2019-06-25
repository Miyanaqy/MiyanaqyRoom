package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.UserBean;

public interface UserBeanRepository extends PagingAndSortingRepository<UserBean, Long>, JpaSpecificationExecutor<UserBean> {

}
