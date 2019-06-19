package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class PhotoBean extends BaseEntity {
	
	private Long user_id;
	
	private String photo_url;
	
	private String photo_title;
	
	private String photo_describe;
	
	private int state;
	
	private int type;

}
