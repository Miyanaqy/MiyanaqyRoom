package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class NoticeBean extends BaseEntity {
	
	private String notice_title;
	
	private String notice_content;
	
	private String notice_describe;
	
	private int state;
	
	private int type;

}
