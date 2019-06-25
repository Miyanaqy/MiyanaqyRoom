package com.miyanaqy.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.miyanaqy.bean.entity.MusicBean;

public interface MusicBeanRepository extends PagingAndSortingRepository<MusicBean, Long>, JpaSpecificationExecutor<MusicBean> {

}
