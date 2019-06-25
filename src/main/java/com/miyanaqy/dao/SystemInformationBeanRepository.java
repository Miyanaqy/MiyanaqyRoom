package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.SystemInformationBean;

public interface SystemInformationBeanRepository extends PagingAndSortingRepository<SystemInformationBean, Long>, JpaSpecificationExecutor<SystemInformationBean> {

}
