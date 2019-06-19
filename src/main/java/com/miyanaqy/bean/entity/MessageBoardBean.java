package com.miyanaqy.bean.entity;

import com.miyanaqy.base.entity.BaseEntity;

import lombok.Data;

@Data
public class MessageBoardBean extends BaseEntity {
	
	private Long user_id;
	
	private String mb_title;
	
	private String mb_content;
	
	private String author;
	
	private int type;
	
	private int state;

}
