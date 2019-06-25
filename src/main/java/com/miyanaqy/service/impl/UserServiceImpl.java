package com.miyanaqy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miyanaqy.bean.entity.UserBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.dao.UserBeanRepository;
import com.miyanaqy.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

	@Autowired
	private UserBeanRepository userReposiry;

	@Override
	public int regist(UserBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int add(UserBean bean) {
		UserBean result = userReposiry.save(bean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int edit(UserBean bean) {
		UserBean findBean = userReposiry.findById(bean.getId()).orElse(null);
		if (findBean == null) return -2;
		findBean.setAutograph(bean.getAutograph());
		findBean.setBirthDate(bean.getBirthDate());
		findBean.setEmail(bean.getEmail());
		findBean.setHeadPortrait(bean.getHeadPortrait());
		findBean.setQqNumber(bean.getQqNumber());
		findBean.setUserName(bean.getUserName());
		findBean.setUserLocation(bean.getUserLocation());
		findBean.setType(bean.getType());
		UserBean result = userReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public int deleteById(Long userId) {
		UserBean findBean = userReposiry.findById(userId).orElse(null);
		if (findBean == null) return -2;
		findBean.setDeleteFlag(1);
		UserBean result = userReposiry.save(findBean);
		if (result != null)
			return 1;
		else
			return 0;
	}

	@Override
	public UserBean findById(Long userId) {
		return userReposiry.findById(userId).orElse(null);
	}
	
	@Override
	public Page<UserBean> findByPage(QueryBean queryBean) {
		Pageable page = PageRequest.of(queryBean.getPageIndex(),queryBean.getPageSize());
        Page<UserBean> queryResult = userReposiry.findAll(page);
		return queryResult; 
	}
}
