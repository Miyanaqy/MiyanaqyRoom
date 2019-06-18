package com.miyanaqy.service;

import com.miyanaqy.bean.bo.Page;
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
