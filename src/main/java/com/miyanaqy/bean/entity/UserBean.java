package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class UserBean extends BaseEntity {
	
	private String user_name;
	
	private String login_number;
	
	private String password;
	
	private String head_portrait;
	
	private String qq_number;
	
	private String autograph;
	
	private String birth_date;
	
	private String user_location;
	
	private String email;
	
	private int state;
	
	private int type;

}
