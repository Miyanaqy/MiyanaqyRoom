package com.miyanaqy.service.impl;

import org.springframework.stereotype.Service;

import com.miyanaqy.bean.bo.Page;
import com.miyanaqy.bean.entity.UserBean;
import com.miyanaqy.bean.vo.QueryBean;
import com.miyanaqy.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

	@Override
	public int regist(UserBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edit(UserBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(UserBean bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserBean findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserBean> findByPage(QueryBean query) {
		// TODO Auto-generated method stub
		return null;
	}

}
