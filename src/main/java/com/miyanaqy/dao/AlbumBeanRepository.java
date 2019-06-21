package com.miyanaqy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.miyanaqy.bean.entity.AlbumBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface AlbumBeanRepository extends PagingAndSortingRepository<AlbumBean, Long>, JpaSpecificationExecutor<AlbumBean>{

//	@Query("update AdminInfo set loginErrorCount = (loginErrorCount - 1) where loginErrorCount > 0 and deleteFlag = 0")
//	int getBeanListByCount(QueryBean query);
//
//	@Query("update AdminInfo set loginErrorCount = (loginErrorCount - 1) where loginErrorCount > 0 and deleteFlag = 0")
//	List<AlbumBean> getBeanListByPage(QueryBean query);

//	@Transactional
//    @Modifying
//    @Query("update AdminInfo set loginErrorCount = (loginErrorCount - 1) where loginErrorCount > 0 and deleteFlag = 0")
//	void recoveryLoginErrorCount();

}
