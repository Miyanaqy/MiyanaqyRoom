package com.miyanaqy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PreUpdate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.NoticeBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.NoticeBeanRepository;
import com.miyanaqy.service.INoticeService;

@Service
public class NoticeServiceImpl extends BaseServiceImpl implements INoticeService {

	@Autowired
	private NoticeBeanRepository noticeReposiry;

	@Override
	public int add(NoticeBean bean) {
		NoticeBean result = noticeReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(NoticeBean bean) {
		NoticeBean findBean = noticeReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setNoticeDescribe(bean.getNoticeDescribe());
		findBean.setNoticeTitle(bean.getNoticeTitle());
		findBean.setNoticeContent(bean.getNoticeContent());
//		findBean.setType(bean.getType());
		NoticeBean result = noticeReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long noticeId) {
		NoticeBean findBean = noticeReposiry.findById(noticeId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		NoticeBean result = noticeReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public NoticeBean findById(Long noticeId) {
		return noticeReposiry.findById(noticeId).orElse(null);
	}
	
	@Override
	public Page<NoticeBean> findByPage(QueryBean queryBean) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		if(queryBean.getTitle() != null)
			queryMap.put("noticeTitle", queryBean.getTitle());
		queryMap.put("deleteFlag", 0);
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
		Specification<NoticeBean> specification = createWhere(queryMap);
        Page<NoticeBean> queryResult = noticeReposiry.findAll(specification, page);
		return queryResult; 
	}
	
	private Specification<NoticeBean> createWhere(Map<String, Object> searchMap){
		 
       return new Specification<NoticeBean>() {
           @Override
           public Predicate toPredicate(Root<NoticeBean> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               List<Predicate> predicateList = new ArrayList<Predicate>();
               System.err.println("*********deleteFlag:"+searchMap.get("deleteFlag"));
               //id
               if(searchMap.get("deleteFlag")!=null && !"".equals(searchMap.get("deleteFlag"))){
                   predicateList.add(cb.equal(root.get("deleteFlag").as(Integer.class),(Integer)searchMap.get("deleteFlag")));
               }
               System.err.println("***noticeTitle:"+searchMap.get("noticeTitle"));
               //name
               if(searchMap.get("noticeTitle")!=null && !"".equals(searchMap.get("noticeTitle"))){
                   predicateList.add(cb.like(root.get("noticeTitle").as(String.class),"%"+(String)searchMap.get("noticeTitle")+"%"));
               }
               //注意cb.or表示两个查询条件之间是or；cb.and表示查询条件之间是and关系
               return cb.or(predicateList.toArray(new Predicate[predicateList.size()]));
           }
       };
    }
}
