package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.PhotoBean;

public interface PhotoBeanRepository extends PagingAndSortingRepository<PhotoBean, Long>, JpaSpecificationExecutor<PhotoBean> {

}
