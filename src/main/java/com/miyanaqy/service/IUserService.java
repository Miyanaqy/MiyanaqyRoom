package com.miyanaqy.service;

import org.springframework.data.domain.Page;

import com.miyanaqy.bean.entity.UserBean;
import com.miyanaqy.bean.vo.QueryBean;

public interface IUserService {

	int regist(UserBean bean);

	int edit(UserBean bean);

	int add(UserBean bean);

	int deleteById(Long id);

	UserBean findById(Long id);

	Page<UserBean> findByPage(QueryBean query);

}
